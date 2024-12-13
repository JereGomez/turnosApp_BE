package com.example.turnosApp.services.interfaces.user;

import com.example.turnosApp.models.dto.UserLogInDTO;
import com.example.turnosApp.models.dto.create.UserCreateDTO;
import com.example.turnosApp.models.dto.response.TokenResponseDTO;
import com.example.turnosApp.models.dto.response.UserResponseDTO;
import com.example.turnosApp.models.dto.update.UserUpdateDTO;
import com.example.turnosApp.models.entity.User;

public interface IUserService {
    UserResponseDTO getUserById(Long userId);

    User getUserByEmail(String email, String name);

    TokenResponseDTO createUser(UserCreateDTO userCreateDTO);
    TokenResponseDTO login(UserLogInDTO userLogInDTO);
    TokenResponseDTO refresh(String refreshToken);
    UserResponseDTO updateUser(UserUpdateDTO userUpdateDTO);
    String deleteUserById (Long userId);
}
