package com.example.turnosApp.services.interfaces.location;

import com.example.turnosApp.models.dto.create.LocationCreateDTO;
import com.example.turnosApp.models.dto.response.LocationResponseDTO;
import com.example.turnosApp.models.dto.update.LocationUpdateDTO;

import java.util.List;

public interface ILocationService {

    List<LocationResponseDTO> getAllLocations();
    LocationResponseDTO getLocationById(Long locationId);
    List<Long> getServicesInLocation(Long locationId);
    List<Long> getProfessionalsInLocation (Long locationId);

    LocationResponseDTO createLocation(LocationCreateDTO locationCreateDTO);
    LocationResponseDTO updateLocation(LocationUpdateDTO locationUpdateDTO);
    String deleteLocationById (Long locationId);

}
