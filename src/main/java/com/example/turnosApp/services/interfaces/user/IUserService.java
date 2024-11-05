package com.example.turnosApp.services.interfaces.user;

import com.example.turnosApp.models.dto.create.UserCreateDTO;
import com.example.turnosApp.models.dto.response.UserResponseDTO;
import com.example.turnosApp.models.dto.update.UserUpdateDTO;

public interface IUserService {
    UserResponseDTO getUserById(Long userId);

    UserResponseDTO createUser(UserCreateDTO userCreateDTO);
    UserResponseDTO updateUser(UserUpdateDTO userUpdateDTO);
    String deleteUserById (Long userId);
}
