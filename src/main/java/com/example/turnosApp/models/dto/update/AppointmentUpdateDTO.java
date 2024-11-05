package com.example.turnosApp.models.dto.update;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
public class AppointmentUpdateDTO {
    @NotNull(message = "The id of the appointment can not be null")
    @NotEmpty(message = "id may not be empty")
    @NotBlank(message = "id may not be blank")
    private Long id; // Required to identify the appointment to be updated
    @NotNull(message = "The title of the appointment can not be null")
    @NotEmpty(message = "Title may not be empty")
    @NotBlank(message = "Title may not be blank")
    private String title;
    @NotNull(message = "The description of the appointment can not be null")
    @NotEmpty(message = "description may not be empty")
    @NotBlank(message = "description may not be blank")
    private String description;
    @NotNull(message = "The date of the appointment can not be null")
    @NotEmpty(message = "date may not be empty")
    @NotBlank(message = "date may not be blank")
    private String date;
    @NotNull(message = "The userId of the appointment can not be null")
    @NotEmpty(message = "userId may not be empty")
    @NotBlank(message = "userId may not be blank")
    private Long userId; // To update the associated user
    @NotNull(message = "The professionalId of the appointment can not be null")
    @NotEmpty(message = "professionalId may not be empty")
    @NotBlank(message = "professionalId may not be blank")
    private Long professionalId; // To update the associated professional
    @NotNull(message = "The serviceId of the appointment can not be null")
    @NotEmpty(message = "serviceId may not be empty")
    @NotBlank(message = "serviceId may not be blank")
    private Long serviceId; // To update the associated service
    @NotNull(message = "The locationId of the appointment can not be null")
    @NotEmpty(message = "locationId may not be empty")
    @NotBlank(message = "locationId may not be blank")
    private Long locationId; // To update the associated location

    public AppointmentUpdateDTO(Long id, String title, String description, String date, Long userId, Long professionalId, Long serviceId, Long locationId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.date = date;
        this.userId = userId;
        this.professionalId = professionalId;
        this.serviceId = serviceId;
        this.locationId = locationId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProfessionalId() {
        return professionalId;
    }

    public void setProfessionalId(Long professionalId) {
        this.professionalId = professionalId;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }
}
