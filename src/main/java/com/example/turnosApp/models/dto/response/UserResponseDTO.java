package com.example.turnosApp.models.dto.response;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserResponseDTO {
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String picture;

    public UserResponseDTO(String name, String lastName, String email, String picture, Long id) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.picture = picture;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
