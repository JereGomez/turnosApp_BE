package com.example.turnosApp.models.dto.create;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class RatingCreateDTO {
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
    @NotNull(message = "The appointmentId of the appointment can not be null")
    @NotEmpty(message = "appointmentId may not be empty")
    @NotBlank(message = "appointmentId may not be blank")
    private Long appointmentId;


    public RatingCreateDTO(String title, String description, Float rating, Long appointmentId) {
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.appointmentId = appointmentId;
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
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


}
