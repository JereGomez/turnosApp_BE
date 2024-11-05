package com.example.turnosApp.models.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Professional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String picture;

    private Float averageRating;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "professional_service", // Name of the join table
            joinColumns = @JoinColumn(name = "professional_id"), // Join column from Professional
            inverseJoinColumns = @JoinColumn(name = "service_id") // Join column from Service
    )
    private List<ServiceEntity> servicesOffer;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "professional_location", // Name of the join table
            joinColumns = @JoinColumn(name = "professional_id"), // Join column from Professional
            inverseJoinColumns = @JoinColumn(name = "location_id") // Join column from Service
    )
    private List<Location> locations;

    @OneToMany(mappedBy = "professional")
    private List<Appointment> appointments;



    public Professional() {
    }

    public Professional(Long id, String name, String email, String picture, Float averageRating, List<ServiceEntity> servicesOffer, List<Location> locations, List<Appointment> appointments) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.averageRating = averageRating;
        this.servicesOffer = servicesOffer;
        this.locations = locations;
        this.appointments = appointments;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
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

    public Float getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Float averageRating) {
        this.averageRating = averageRating;
    }

    public List<ServiceEntity> getServicesOffer() {
        return servicesOffer;
    }

    public void setServicesOffer(List<ServiceEntity> servicesOffer) {
        this.servicesOffer = servicesOffer;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}
