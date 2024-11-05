package com.example.turnosApp.models.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class ServiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private Float amount;
    private Float duration; //minutes

    private String category;
    private Float averageRating;

    @ManyToMany(mappedBy = "serviceEntityLocations", fetch = FetchType.LAZY)
    private List<Location> locations;
//    @OneToMany(mappedBy = "service")
//    private List<Appointment> appointments;


    @ManyToMany(mappedBy = "servicesOffer",fetch = FetchType.LAZY)
    private List<Professional> professionals;

    public ServiceEntity() {
    }

    public ServiceEntity(Long id, String title, String description, Float amount, Float duration, String category, Float averageRating, List<Location> locations, List<Appointment> appointments, List<Professional> professionals) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.amount = amount;
        this.duration = duration;
        this.category = category;
        this.averageRating = averageRating;
        this.locations = locations;
//        this.appointments = appointments;
        this.professionals = professionals;
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

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Float getDuration() {
        return duration;
    }

    public void setDuration(Float duration) {
        this.duration = duration;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Float getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Float averageRating) {
        this.averageRating = averageRating;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

//    public List<Appointment> getAppointments() {
//        return appointments;
//    }
//
//    public void setAppointments(List<Appointment> appointments) {
//        this.appointments = appointments;
//    }


    public List<Professional> getProfessionals() {
        return professionals;
    }

    public void setProfessionals(List<Professional> professionals) {
        this.professionals = professionals;
    }
}
