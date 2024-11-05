package com.example.turnosApp.services.interfaces.rating;

import com.example.turnosApp.models.dto.create.RatingCreateDTO;
import com.example.turnosApp.models.dto.response.RatingResponseDTO;

import java.util.List;

public interface IRatingService {

    List<RatingResponseDTO> getAllRatings();

    RatingResponseDTO getRatingById(Long ratingId);

    RatingResponseDTO createRating (RatingCreateDTO ratingCreateDTO);

    RatingResponseDTO updateRating(Long ratingId);

    String deleteRatingById(Long ratingId);
}
