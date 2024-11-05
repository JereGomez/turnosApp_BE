package com.example.turnosApp.controllers;

import com.example.turnosApp.models.dto.create.RatingCreateDTO;
import com.example.turnosApp.models.dto.response.RatingResponseDTO;
import com.example.turnosApp.services.interfaces.rating.IRatingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {
    private IRatingService ratingService;

    public RatingController(IRatingService ratingService){
        this.ratingService = ratingService;
    }
    //GET
    @GetMapping
    public ResponseEntity<List<RatingResponseDTO>> getAllRatings(){
        return new ResponseEntity<List<RatingResponseDTO>>(ratingService.getAllRatings(), HttpStatus.OK);
    }

    @GetMapping("/{ratingId}")
    public ResponseEntity<RatingResponseDTO> getRatingById(@PathVariable Long ratingId){
        return new ResponseEntity<RatingResponseDTO>(ratingService.getRatingById(ratingId), HttpStatus.OK);
    }

    //POST
    @PostMapping()
    public ResponseEntity<RatingResponseDTO> createRating(@RequestBody RatingCreateDTO ratingCreateDTO){
        return new ResponseEntity<>(ratingService.createRating(ratingCreateDTO), HttpStatus.OK);
    }
    //PUT
    @PutMapping()
    public ResponseEntity<RatingResponseDTO> updateRatingById(@PathVariable Long ratingId){
        return new ResponseEntity<>(ratingService.updateRating(ratingId), HttpStatus.OK);
    }

    //DELETE
    @DeleteMapping("/{ratingId}")
    public ResponseEntity<String> deleteRatingById(@PathVariable Long ratingId){
        return new ResponseEntity<>(ratingService.deleteRatingById(ratingId), HttpStatus.OK);
    }

}
