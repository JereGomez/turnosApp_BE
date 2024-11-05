package com.example.turnosApp.models.dto.response;

import com.example.turnosApp.models.entity.Appointment;
import com.example.turnosApp.models.entity.Rating;
import lombok.NoArgsConstructor;

import java.util.List;
@NoArgsConstructor
public class ServiceResponseDTO {
    private Long id;
    private String title;
    private String description;
    private Float amount;
    private int duration;
    private String category;
//    private List<Appointment> appointments; // Assuming AppointmentDTO exists
//    List of Appointments not needed, return list of ID's or the range of available dates,
    private Float averageRating; // Assuming ServiceRatingDTO exists
    private List<Long> professionalsId;

    public ServiceResponseDTO(Long id, String title, String description, Float amount, int duration, String category, Float averageRating, List<Long> professionalsId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.amount = amount;
        this.duration = duration;
        this.category = category;
        this.averageRating = averageRating;
        this.professionalsId = professionalsId;
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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
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

    public List<Long> getProfessionalsId() {
        return professionalsId;
    }

    public void setProfessionalsId(List<Long> professionalsId) {
        this.professionalsId = professionalsId;
    }
}
