package com.example.turnosApp.models.dto.response;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class LocationResponseDTO {
    private Long id;
    private String name;
    private String description;
    private String address;
    private String country;
    private String postalCode;

    private Long capability;

    public LocationResponseDTO(Long id, String name, String description, String address, String country, String postalCode, Long capability) {
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
