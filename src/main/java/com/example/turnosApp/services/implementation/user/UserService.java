package com.example.turnosApp.services.implementation.user;

import com.example.turnosApp.models.dto.create.UserCreateDTO;
import com.example.turnosApp.models.dto.response.UserResponseDTO;
import com.example.turnosApp.models.dto.update.UserUpdateDTO;
import com.example.turnosApp.models.entity.User;
import com.example.turnosApp.repository.UserRepository;
import com.example.turnosApp.services.implementation.professional.ProfessionalService;
import com.example.turnosApp.services.interfaces.user.IUserService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

@Service
public class UserService implements IUserService {
    UserRepository userRepository;
    ModelMapper modelMapper;
    Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserResponseDTO getUserById(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if(user!= null){
            return modelMapper.map(user, UserResponseDTO.class);
        }
        return null;
    }

    @Override
    public UserResponseDTO createUser(UserCreateDTO userCreateDTO) {
        User user = userRepository.findByName(userCreateDTO.getName()).orElse(null);
        UserResponseDTO userResponseDTO = null;
        if(user == null) {
            user = modelMapper.map(userCreateDTO, User.class);
            userRepository.save(user);
            userResponseDTO = modelMapper.map(user, UserResponseDTO.class);
        }
        else{
            logger.info("User with that name already exists");
        }
        return userResponseDTO;
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
