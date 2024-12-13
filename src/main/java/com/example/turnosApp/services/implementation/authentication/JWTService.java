package com.example.turnosApp.services.implementation.authentication;

import com.example.turnosApp.models.entity.Token;
import com.example.turnosApp.models.entity.User;
import com.example.turnosApp.repository.TokenRepository;
import com.example.turnosApp.services.interfaces.authentication.IJWTService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class JWTService implements IJWTService {

    @Value("${application.security.jwt.secret-key}")
    private String secretKey;

    @Value("${application.security.jwt.expiration}")
    private Long jwtExpiration;

    @Value("${application.security.jwt.refresh-token.expiration}")
    private Long jwtRefreshExpiration;

    TokenRepository tokenRepository;

    @Autowired
    public JWTService(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    @Override
    public String generateToken(User user) {
        return buildToken(user, jwtExpiration);
    }

    private String buildToken(User user, Long jwtExpiration) {
        return Jwts.builder()
                .id(user.getId().toString())
                .claims(Map.of("name", user.getName()))
                .setSubject(user.getEmail())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpiration))
                .signWith(getSignInKey(secretKey))
                .compact();
    }

    private SecretKey getSignInKey(String secretKey) {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    @Override
    public String generateRefreshToken(User user) {
        return buildToken(user, jwtRefreshExpiration);
    }

    @Override
    public String extractUsername(String token) {
        final Claims jwtToken = Jwts.parser()
                .verifyWith(getSignInKey(secretKey))
                .build()
                .parseSignedClaims(token)
                .getPayload();
        return jwtToken.getSubject();
    }

    @Override
    public boolean isTokenValid(String token, User user) {
       final String username = extractUsername(token);
       return (username.equals(user.getEmail()) && !istokenExpired(token));
    }

    private boolean istokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        final Claims jwtToken = Jwts.parser()
                .verifyWith(getSignInKey(secretKey))
                .build()
                .parseSignedClaims(token)
                .getPayload();
        return jwtToken.getExpiration();
    }

    @Override
    public void saveUserToken(User user, String token) {
        var tokenEntity = Token.builder()
                .token(token)
                .user(user)
                .tokenType(Token.TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(tokenEntity);
    }

    @Override
    public void revokeAllUserTokens(User user) {
       final List<Token> validUserTokens = tokenRepository.findAllValidIsFalseOrRevokedIsFalseByUser(user);
       if(!validUserTokens.isEmpty()){
           validUserTokens.forEach(token -> {
               token.setRevoked(true);
               token.setExpired(true);
           });
           tokenRepository.saveAll(validUserTokens);
       }
    }
}
