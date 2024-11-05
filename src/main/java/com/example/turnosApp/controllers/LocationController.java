package com.example.turnosApp.controllers;

import com.example.turnosApp.models.dto.create.LocationCreateDTO;
import com.example.turnosApp.models.dto.response.LocationResponseDTO;
import com.example.turnosApp.models.dto.update.LocationUpdateDTO;
import com.example.turnosApp.models.entity.Location;
import com.example.turnosApp.services.interfaces.location.ILocationService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationController {

    private ILocationService locationService;

    public LocationController(ILocationService locationService) {
        this.locationService = locationService;
    }

    //GET
    @GetMapping()
    public ResponseEntity<List<LocationResponseDTO>> getAllLocations(){
        return new ResponseEntity<List<LocationResponseDTO>>(locationService.getAllLocations(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocationResponseDTO> getLocationById(@PathVariable Long locationId){
        return new ResponseEntity<>(locationService.getLocationById(locationId), HttpStatus.OK);
    }
    //POST
    @PostMapping
    public ResponseEntity<LocationResponseDTO> createLocation(@RequestBody LocationCreateDTO locationCreateDTO){
        return new ResponseEntity<>(locationService.createLocation(locationCreateDTO), HttpStatus.OK);
    }
    //PUT
    @PutMapping
    public ResponseEntity<LocationResponseDTO> updateLocation(@RequestBody LocationUpdateDTO locationUpdateDTO){
        return new ResponseEntity<>(locationService.updateLocation(locationUpdateDTO), HttpStatus.OK);
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLocationById (@PathVariable Long locationId){
        return new ResponseEntity<>(locationService.deleteLocationById(locationId), HttpStatus.OK);
    }
}
