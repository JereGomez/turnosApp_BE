package com.example.turnosApp.controllers;

import com.example.turnosApp.models.dto.UserLogInDTO;
import com.example.turnosApp.models.dto.create.UserCreateDTO;
import com.example.turnosApp.models.dto.response.TokenResponseDTO;
import com.example.turnosApp.services.interfaces.authentication.IAuthService;
import com.example.turnosApp.services.interfaces.user.IUserService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {


    private final IUserService userService;

    @PostMapping("/register")
    public ResponseEntity<TokenResponseDTO> register(@RequestBody final UserCreateDTO userCreateDTO) {
        final TokenResponseDTO toekn = userService.createUser(userCreateDTO);
        return ResponseEntity.ok(toekn);
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponseDTO> login(@RequestBody final UserLogInDTO userLogInDTO) {
        final TokenResponseDTO token = userService.login(userLogInDTO);
        return ResponseEntity.ok(token);
    }

    @PostMapping("/refresh")
    public ResponseEntity<TokenResponseDTO> refresh(@RequestHeader(HttpHeaders.AUTHORIZATION) final String authHeader) {
        final TokenResponseDTO token = userService.refresh(authHeader);
        return ResponseEntity.ok(token);
    }

}
