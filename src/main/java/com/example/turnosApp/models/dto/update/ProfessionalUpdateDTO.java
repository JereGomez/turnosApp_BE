package com.example.turnosApp.models.dto.update;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ProfessionalUpdateDTO {
    @NotNull(message = "The id of the appointment can not be null")
    @NotEmpty(message = "id may not be empty")
    @NotBlank(message = "id may not be blank")
    private Long id; // Required for identifying which professional to update
    @NotNull(message = "The firstName of the appointment can not be null")
    @NotEmpty(message = "firstName may not be empty")
    @NotBlank(message = "firstName may not be blank")
    private String firstName;
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

    public ProfessionalUpdateDTO(Long id, String firstName, String lastName, String email, String picture) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.picture = picture;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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
