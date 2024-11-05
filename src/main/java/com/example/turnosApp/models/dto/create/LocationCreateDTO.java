package com.example.turnosApp.models.dto.create;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class LocationCreateDTO {
    @NotNull(message = "The address of the appointment can not be null")
    @NotEmpty(message = "address may not be empty")
    @NotBlank(message = "address may not be blank")
    private String address;
    @NotNull(message = "The country of the appointment can not be null")
    @NotEmpty(message = "country may not be empty")
    @NotBlank(message = "country may not be blank")
    private String country;
    @NotNull(message = "The name of the appointment can not be null")
    @NotEmpty(message = "name may not be empty")
    @NotBlank(message = "name may not be blank")
    private String name;
    @NotNull(message = "The postalCode of the appointment can not be null")
    @NotEmpty(message = "postalCode may not be empty")
    @NotBlank(message = "postalCode may not be blank")
    private String postalCode;
    @NotNull(message = "The capability of the appointment can not be null")
    @NotEmpty(message = "capability may not be empty")
    @NotBlank(message = "capability may not be blank")
    private Long capability;

    public LocationCreateDTO(String name, String address, String country, String postalCode, Long capability) {
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
