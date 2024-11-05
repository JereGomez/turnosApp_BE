package com.example.turnosApp.models.dto.response;

import com.example.turnosApp.models.entity.Appointment;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@NoArgsConstructor
public class ProfessionalResponseDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String picture;
    private List<Long> appointmentsIds;
    private Float averageRating;
    private List<Long> servicesIds;

    public ProfessionalResponseDTO(Long id, String firstName, String lastName, String email, String picture, List<Long> appointments, Float averageRating, List<Long> services) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.picture = picture;
        this.appointmentsIds = appointments;
        this.averageRating = averageRating;
        this.servicesIds = services;
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

    public List<Long> getAppointmentsIds() {
        return appointmentsIds;
    }

    public void setAppointmentsIds(List<Long> appointmentsIds) {
        this.appointmentsIds = appointmentsIds;
    }

    public Float getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Float averageRating) {
        this.averageRating = averageRating;
    }

    public List<Long> getServicesIds() {
        return servicesIds;
    }

    public void setServicesIds(List<Long> servicesIds) {
        this.servicesIds = servicesIds;
    }
}
