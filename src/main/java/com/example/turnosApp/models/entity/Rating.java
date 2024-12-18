package com.example.turnosApp.models.entity;

import jakarta.persistence.*;

@Entity
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private Float rating;
    @ManyToOne
    @JoinColumn(name = "serviceEntity_id")
    private ServiceEntity service;
    @ManyToOne
    @JoinColumn(name = "professional_id")
    private Professional professional;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

//    @OneToOne
//    @JoinColumn(name="appointment_id")
//    private Appointment appointment;


    public Rating() {
    }


    public Rating(Long id, String title, String description, Float rating, ServiceEntity service, Professional professional, User user, Appointment appointment) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.service = service;
        this.professional = professional;
        this.user = user;
//        this.appointment = appointment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public ServiceEntity getService() {
        return service;
    }

    public void setService(ServiceEntity service) {
        this.service = service;
    }

    public Professional getProfessional() {
        return professional;
    }

    public void setProfessional(Professional professional) {
        this.professional = professional;
    }

//    public Appointment getAppointment() {
//        return appointment;
//    }
//
//    public void setAppointment(Appointment appointment) {
//        this.appointment = appointment;
//    }
}
