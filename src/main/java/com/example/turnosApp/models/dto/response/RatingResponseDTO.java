package com.example.turnosApp.models.dto.response;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class RatingResponseDTO {
    private Long id;
    private String title;
    private String description;
    private Float rating;
    private Long serviceId; // Assuming ServiceResponseDTO exists
    private Long professionalId; // Assuming ServiceResponseDTO exists
    private Long userId; // Assuming ServiceResponseDTO exists

    public RatingResponseDTO(Long id, String title, String description, Float rating, Long serviceId, Long professionalId, Long userId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.serviceId = serviceId;
        this.professionalId = professionalId;
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public Long getProfessionalId() {
        return professionalId;
    }

    public void setProfessionalId(Long professionalId) {
        this.professionalId = professionalId;
    }
}
