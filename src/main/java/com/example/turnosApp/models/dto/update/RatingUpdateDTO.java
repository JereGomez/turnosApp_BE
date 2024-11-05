package com.example.turnosApp.models.dto.update;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class RatingUpdateDTO {
    @NotNull(message = "The id of the appointment can not be null")
    @NotEmpty(message = "id may not be empty")
    @NotBlank(message = "id may not be blank")
    private Long id; // ID of the rating to be updated
    @NotNull(message = "The Title of the appointment can not be null")
    @NotEmpty(message = "Title may not be empty")
    @NotBlank(message = "Title may not be blank")
    private String title;
    @NotNull(message = "The description of the appointment can not be null")
    @NotEmpty(message = "description may not be empty")
    @NotBlank(message = "description may not be blank")
    private String description;
    @NotNull(message = "The rating of the appointment can not be null")
    @NotEmpty(message = "rating may not be empty")
    @NotBlank(message = "rating may not be blank")
    private Float rating;
    @NotNull(message = "The serviceId of the appointment can not be null")
    @NotEmpty(message = "serviceId may not be empty")
    @NotBlank(message = "serviceId may not be blank")
    private Long serviceId; // Updated service if needed
    @NotNull(message = "The professionalId of the appointment can not be null")
    @NotEmpty(message = "professionalId may not be empty")
    @NotBlank(message = "professionalId may not be blank")
    private Long professionalId; // Updated service if needed

    public RatingUpdateDTO(Long id, String title, String description, Float rating, Long serviceId, Long professionalId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.serviceId = serviceId;
        this.professionalId = professionalId;
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
