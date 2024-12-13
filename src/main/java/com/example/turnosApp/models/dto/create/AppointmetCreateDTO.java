package com.example.turnosApp.models.dto.create;

import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@NoArgsConstructor
public class AppointmetCreateDTO {
    @NotNull(message = "The Title of the appointment can not be null")
    @NotEmpty(message = "Title may not be empty")
    @NotBlank(message = "Title may not be blank")
    private String title;
    @NotNull(message = "The Description of the appointment can not be null")
    @NotEmpty(message = "Description may not be empty")
    @NotBlank(message = "Description may not be blank")
    private String description;
    @NotNull(message = "The userEmail of the appointment can not be null")
    @NotEmpty(message = "userEmail may not be empty")
    @NotBlank(message = "userEmail may not be blank")
    private String userEmail;

    @NotNull(message = "The userName of the appointment can not be null")
    @NotEmpty(message = "userName may not be empty")
    @NotBlank(message = "userName may not be blank")
    private String userName;
    @NotNull(message = "The locationId of the appointment can not be null")
    @NotEmpty(message = "locationId may not be empty")
    @NotBlank(message = "locationId may not be blank")
    private Long locationId;
    @NotNull(message = "The professionalId of the appointment can not be null")
    @NotEmpty(message = "professionalId may not be empty")
    @NotBlank(message = "professionalId may not be blank")
    private Long professionalId;
    @NotNull(message = "The serviceId of the appointment can not be null")
    @NotEmpty(message = "serviceId may not be empty")
    @NotBlank(message = "serviceId may not be blank")
    private Long serviceId;
    @NotNull(message = "The date of the appointment can not be null")
    @NotEmpty(message = "date may not be empty")
    @NotBlank(message = "date may not be blank")
    private String date;

    public AppointmetCreateDTO(String title, String description, String userEmail, String userName, Long locationId, Long professionalId, Long serviceId, String date) {
        this.title = title;
        this.description = description;
        this.userEmail = userEmail;
        this.userName = userName;
        this.locationId = locationId;
        this.professionalId = professionalId;
        this.serviceId = serviceId;
        this.date = date;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public Long getProfessionalId() {
        return professionalId;
    }

    public void setProfessionalId(Long professionalId) {
        this.professionalId = professionalId;
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



    public Long getService() {
        return serviceId;
    }

    public void setService(Long serviceId) {
        this.serviceId = serviceId;
    }
}
