package com.example.turnosApp.controllers;

import com.example.turnosApp.models.dto.create.UserCreateDTO;
import com.example.turnosApp.models.dto.response.UserResponseDTO;
import com.example.turnosApp.models.dto.update.UserUpdateDTO;
import com.example.turnosApp.services.interfaces.user.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    //GET
    @GetMapping()
    public ResponseEntity<UserResponseDTO> getUserById(@RequestParam Long userId){
        return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
    }
//    POST
    @PostMapping()
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserCreateDTO userCreateDTO){
        return new ResponseEntity<>(userService.createUser(userCreateDTO), HttpStatus.OK);
    }
//    PUT
    @PutMapping()
    public ResponseEntity<UserResponseDTO> updateUser(@RequestBody UserUpdateDTO userUpdateDTO){
        return new ResponseEntity<>(userService.updateUser(userUpdateDTO), HttpStatus.OK);
    }
//    DELETE
    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUserById(@RequestParam Long userId){
        return new ResponseEntity<>(userService.deleteUserById(userId),HttpStatus.OK);
    }
}
