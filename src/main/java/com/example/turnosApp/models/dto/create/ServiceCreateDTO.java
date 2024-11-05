package com.example.turnosApp.models.dto.create;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@NoArgsConstructor
public class ServiceCreateDTO {
    @NotNull(message = "The Title of the appointment can not be null")
    @NotEmpty(message = "Title may not be empty")
    @NotBlank(message = "Title may not be blank")
    private String title;
    @NotNull(message = "The description of the appointment can not be null")
    @NotEmpty(message = "description may not be empty")
    @NotBlank(message = "description may not be blank")
    private String description;
    @NotNull(message = "The amount of the appointment can not be null")
    @NotEmpty(message = "amount may not be empty")
    @NotBlank(message = "amount may not be blank")
    private Float amount;
    @NotNull(message = "The duration of the appointment can not be null")
    @NotEmpty(message = "duration may not be empty")
    @NotBlank(message = "duration may not be blank")
    private int duration; // In minutes
    @NotNull(message = "The category of the appointment can not be null")
    @NotEmpty(message = "category may not be empty")
    @NotBlank(message = "category may not be blank")
    private String category;

    public ServiceCreateDTO(String title, String description, Float amount, int duration, String category) {
        this.title = title;
        this.description = description;
        this.amount = amount;
        this.duration = duration;
        this.category = category;
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
}
