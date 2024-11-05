package com.example.turnosApp.models.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;
    private String country;
    private String name;
    private String postalCode;

    private Long capability; // capability of the location to bring services at the same time

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "location_service", // Name of the join table
            joinColumns = @JoinColumn(name = "location_id"), // Foreign key for Location
            inverseJoinColumns = @JoinColumn(name = "service_id") // Foreign key for Service
    )
    private List<ServiceEntity> serviceEntityLocations;

    @ManyToMany(mappedBy = "locations",fetch = FetchType.LAZY)
    private List<Professional> professionals;

//    @OneToMany(mappedBy = "location")
//    private List<Appointment> appointments;

    public Location() {
    }

    public Location(Long id, String name, String address, String country, String postalCode, List<ServiceEntity> serviceEntityLocations, List<Appointment> appointments, Long capability, List<Professional> professionals) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.country = country;
        this.postalCode = postalCode;
        this.serviceEntityLocations = serviceEntityLocations;
        this.capability = capability;
//        this.appointments = appointments;
        this.professionals = professionals;
    }

    public Long getCapability() {
        return capability;
    }

    public void setCapability(Long capability) {
        this.capability = capability;
    }

    public List<Professional> getProfessionals() {
        return professionals;
    }

    public void setProfessionals(List<Professional> professionals) {
        this.professionals = professionals;
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

    public List<ServiceEntity> getServiceEntityLocations() {
        return serviceEntityLocations;
    }

    public void setServiceEntityLocations(List<ServiceEntity> serviceEntityLocations) {
        this.serviceEntityLocations = serviceEntityLocations;
    }

//    public List<Appointment> getAppointments() {
//        return appointments;
//    }
//
//    public void setAppointments(List<Appointment> appointments) {
//        this.appointments = appointments;
//    }
}
