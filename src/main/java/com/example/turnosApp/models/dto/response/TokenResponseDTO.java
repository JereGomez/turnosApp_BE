package com.example.turnosApp.models.dto.response;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class TokenResponseDTO {

    private String token;
    private String refreshToken;
}
