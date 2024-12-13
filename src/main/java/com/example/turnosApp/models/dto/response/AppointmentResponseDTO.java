package com.example.turnosApp.models.dto.response;

import com.example.turnosApp.models.entity.*;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AppointmentResponseDTO {
    private Long id;
    private String title;
    private String description;

    private String date;
    private UserResponseDTO user;
    private Long professionalId; // Assuming ProfessionalResponseDTO exists
    private Long serviceEntityId; // Assuming ServiceResponseDTO exists
    private Long locationId; // Assuming LocationResponseDTO exists
    private Long ratingId; // Assuming RatingResponseDTO exists

    public AppointmentResponseDTO(Long id, String title, String description, String date, UserResponseDTO user, Long professionalId, Long serviceEntityId, Long locationId, Long ratingId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.date = date;
        this.user = user;
        this.professionalId = professionalId;
        this.serviceEntityId = serviceEntityId;
        this.locationId = locationId;
        this.ratingId = ratingId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public UserResponseDTO getUser() {
        return user;
    }

    public void setUser(UserResponseDTO user) {
        this.user = user;
    }

    public Long getProfessionalId() {
        return professionalId;
    }

    public void setProfessionalId(Long professionalId) {
        this.professionalId = professionalId;
    }

    public Long getServiceEntityId() {
        return serviceEntityId;
    }

    public void setServiceEntityId(Long serviceEntityId) {
        this.serviceEntityId = serviceEntityId;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public Long getRatingId() {
        return ratingId;
    }

    public void setRatingId(Long ratingId) {
        this.ratingId = ratingId;
    }
}
