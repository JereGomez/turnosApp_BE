package com.example.turnosApp.models.dto.update;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class LocationUpdateDTO {
    @NotNull(message = "The id of the appointment can not be null")
    @NotEmpty(message = "id may not be empty")
    @NotBlank(message = "id may not be blank")
    private Long id; // Required to identify the location
    @NotNull(message = "The name of the appointment can not be null")
    @NotEmpty(message = "name may not be empty")
    @NotBlank(message = "name may not be blank")
    private String name;
    @NotNull(message = "The description of the appointment can not be null")
    @NotEmpty(message = "description may not be empty")
    @NotBlank(message = "description may not be blank")
    private String description;
    @NotNull(message = "The address of the appointment can not be null")
    @NotEmpty(message = "address may not be empty")
    @NotBlank(message = "address may not be blank")
    private String address;
    @NotNull(message = "The country of the appointment can not be null")
    @NotEmpty(message = "country may not be empty")
    @NotBlank(message = "country may not be blank")
    private String country;
    @NotNull(message = "The postalCode of the appointment can not be null")
    @NotEmpty(message = "postalCode may not be empty")
    @NotBlank(message = "postalCode may not be blank")
    private String postalCode;

    @NotNull(message = "The capability of the appointment can not be null")
    @NotEmpty(message = "capability may not be empty")
    @NotBlank(message = "capability may not be blank")
    private Long capability;

    public LocationUpdateDTO(Long id, String name, String description, String address, String country, String postalCode, Long capability) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.address = address;
        this.country = country;
        this.postalCode = postalCode;
        this.capability = capability;
    }

    public Long getCapability() {
        return capability;
    }

    public void setCapability(Long capability) {
        this.capability = capability;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
