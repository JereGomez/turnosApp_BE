package com.example.turnosApp.services.interfaces.authentication;

import com.example.turnosApp.models.entity.User;

public interface IJWTService {
    String generateToken(User user);
    String generateRefreshToken(User user);
    String extractUsername(String token);
    boolean isTokenValid(String token,User user);

    void saveUserToken( User user,String token);

    void revokeAllUserTokens(User user);
}
