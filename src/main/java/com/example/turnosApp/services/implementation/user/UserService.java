package com.example.turnosApp.services.implementation.user;

import com.example.turnosApp.models.dto.UserLogInDTO;
import com.example.turnosApp.models.dto.create.UserCreateDTO;
import com.example.turnosApp.models.dto.response.TokenResponseDTO;
import com.example.turnosApp.models.dto.response.UserResponseDTO;
import com.example.turnosApp.models.dto.update.UserUpdateDTO;
import com.example.turnosApp.models.entity.User;
import com.example.turnosApp.repository.UserRepository;
import com.example.turnosApp.services.interfaces.authentication.IJWTService;
import com.example.turnosApp.services.interfaces.user.IUserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final IJWTService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public UserResponseDTO getUserById(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if(user!= null){
            return modelMapper.map(user, UserResponseDTO.class);
        }
        return null;
    }

    @Override
    public User getUserByEmail(String email, String name) {
        User user =  userRepository.findByEmail(email).orElse(null);
        if (user == null) {
            logger.info("User with that email does not exist. One for that Email and Name have been created");
            user =createUserClient(email, name);
        }
        return user;
    }

    private User createUserClient(String email, String name) {
        User user = new User();
        user.setEmail(email);
        user.setName(name);
        userRepository.save(user);
        return user;
    }

    @Override
    public TokenResponseDTO createUser(UserCreateDTO userCreateDTO) {
        User user = userRepository.findByName(userCreateDTO.getName()).orElse(null);
        UserResponseDTO userResponseDTO = null;
        if(user == null) {
            user = modelMapper.map(userCreateDTO, User.class);
            //codificar la contraseña
            user.setPassword(passwordEncoder.encode(userCreateDTO.getPassword()));
            userRepository.save(user);
            var jwtToken = jwtService.generateToken(user);
            var refreshToken = jwtService.generateRefreshToken(user);
            jwtService.saveUserToken(user, jwtToken);
//            userResponseDTO = modelMapper.map(user, UserResponseDTO.class); SE DEVUELVE TOKEN NO USERRESPONSEDTO
            return new TokenResponseDTO(jwtToken, refreshToken);
        }
        else{
            logger.info("User with that name already exists");
        }
        return null; //Hacer Exception personalizada
    }

    @Override
    public TokenResponseDTO login(UserLogInDTO userLogInDTO) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userLogInDTO.getEmail(),
                        userLogInDTO.getPassword()
                )
        );
        var user = userRepository.findByEmail(userLogInDTO.getEmail()).orElse(null);
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        jwtService.revokeAllUserTokens(user);
        jwtService.saveUserToken(user, jwtToken);
        return new TokenResponseDTO(jwtToken, refreshToken);
    }

    @Override
    public TokenResponseDTO refresh(String refreshToken) {
       if(refreshToken == null || !refreshToken.startsWith("Bearer ")){
           throw new IllegalArgumentException("Invalid Bearer Token");
       }
       final String refreshTokenWithoutBearer = refreshToken.substring(7);
       final String email = jwtService.extractUsername(refreshTokenWithoutBearer); //IN OUR CASE IS USERNAME

       final User user = userRepository.findByEmail(email).orElse(null);
       if(user == null){
           throw new IllegalArgumentException("Invalid Bearer Token");
       }
       if(!jwtService.isTokenValid(refreshTokenWithoutBearer, user)){
           throw new IllegalArgumentException("Invalid Bearer Token");

       }
        final String accessToken = jwtService.generateToken(user);
        jwtService.revokeAllUserTokens(user);
        return new TokenResponseDTO(accessToken, refreshToken);

    }


    @Override
    public UserResponseDTO updateUser(UserUpdateDTO userUpdateDTO) {
        User user = userRepository.findById(userUpdateDTO.getId()).orElse(null);
        UserResponseDTO userResponseDTO = null;
        if (user != null){
            user = modelMapper.map(userUpdateDTO, User.class);
            userRepository.save(user);
            userResponseDTO = modelMapper.map(user, UserResponseDTO.class);
        }
        return userResponseDTO;
    }

    @Override
    public String deleteUserById(Long userId) {
        userRepository.deleteById(userId);
        return MessageFormat.format( "User with ID {0} has been deleted successfully.", userId);
    }
}
