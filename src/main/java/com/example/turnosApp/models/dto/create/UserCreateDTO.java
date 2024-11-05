package com.example.turnosApp.models.dto.create;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserCreateDTO {
    @NotNull(message = "The name of the appointment can not be null")
    @NotEmpty(message = "name may not be empty")
    @NotBlank(message = "name may not be blank")
    private String name;
    @NotNull(message = "The lastName of the appointment can not be null")
    @NotEmpty(message = "lastName may not be empty")
    @NotBlank(message = "lastName may not be blank")
    private String lastName;
    @NotNull(message = "The email of the appointment can not be null")
    @NotEmpty(message = "email may not be empty")
    @NotBlank(message = "email may not be blank")
    private String email;
    @NotNull(message = "The picture of the appointment can not be null")
    @NotEmpty(message = "picture may not be empty")
    @NotBlank(message = "picture may not be blank")
    private String picture;

    @NotNull(message = "The password of the appointment can not be null")
    @NotEmpty(message = "password may not be empty")
    @NotBlank(message = "password may not be blank")
    private String password;

    public UserCreateDTO(String name, String lastName, String email, String picture, String password) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.picture = picture;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
