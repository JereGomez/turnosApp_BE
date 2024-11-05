package com.example.turnosApp.services.implementation.location;

import com.example.turnosApp.models.dto.create.LocationCreateDTO;
import com.example.turnosApp.models.dto.response.AppointmentResponseDTO;
import com.example.turnosApp.models.dto.response.LocationResponseDTO;
import com.example.turnosApp.models.dto.update.LocationUpdateDTO;
import com.example.turnosApp.models.entity.Appointment;
import com.example.turnosApp.models.entity.Location;
import com.example.turnosApp.models.entity.Professional;
import com.example.turnosApp.models.entity.ServiceEntity;
import com.example.turnosApp.repository.LocationRepository;
import com.example.turnosApp.services.interfaces.location.ILocationService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class LocationService implements ILocationService {
    LocationRepository locationRepository;
    ModelMapper modelMapper;
    Logger logger = LoggerFactory.getLogger(LocationService.class);

    public LocationService(LocationRepository locationRepository, ModelMapper modelMapper) {
        this.locationRepository = locationRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<LocationResponseDTO> getAllLocations() {
        return locationRepository.findAll()
                .stream()
                .map(location -> modelMapper.map(location, LocationResponseDTO.class))
                .toList();
    }

    @Override
    public LocationResponseDTO getLocationById(Long locationId) {
        LocationResponseDTO locationResponseDTO = null;
        if(locationId != null){
            Location location = locationRepository.findById(locationId).orElse(null);
            locationResponseDTO = modelMapper.map(location, LocationResponseDTO.class);
            return locationResponseDTO;
        }
        return null;
    }

    @Override
    public List<Long> getServicesInLocation(Long locationId) {
        List<Long> servicesInLocation = new ArrayList<>();
        Location location = locationRepository.findById(locationId).orElse(null);
        if(location!= null){
            for (ServiceEntity service : location.getServiceEntityLocations()) {
                servicesInLocation.add(service.getId());
            }
        }
        return servicesInLocation;
    }


    @Override
    public List<Long> getProfessionalsInLocation(Long locationId) {
        List<Long> professionalsInLocation = new ArrayList<>();
        Location location = locationRepository.findById(locationId).orElse(null);
        if(location != null){
            for (Professional professional : location.getProfessionals()) {
                professionalsInLocation.add(professional.getId());
            }
        }
        return professionalsInLocation;
    }

    @Override
    public LocationResponseDTO createLocation(LocationCreateDTO locationCreateDTO) {
        logger.info(locationCreateDTO.getName());
        Location location = locationRepository.findByName(locationCreateDTO.getName()).orElse(null);;
        LocationResponseDTO locationResponseDTO = null;
        if(location == null){
            logger.info("Location with that name does not exists");
            Location locationToSave = modelMapper.map(locationCreateDTO, Location.class);
            locationRepository.save(locationToSave);
            locationResponseDTO = modelMapper.map(locationToSave, LocationResponseDTO.class);
        }
        else{
            logger.info("Location with that name already exists");
        }
        return locationResponseDTO;
    }

    @Override
    public LocationResponseDTO updateLocation(LocationUpdateDTO locationUpdateDTO) {
        Location location = locationRepository.findById(locationUpdateDTO.getId()).orElse(null);;
        LocationResponseDTO locationResponseDTO= null;
        if (location != null){
            location = modelMapper.map(locationUpdateDTO, Location.class);
            locationRepository.save(location);
            locationResponseDTO = modelMapper.map(location, LocationResponseDTO.class);
        }
        return locationResponseDTO;
    }

    @Override
    public String deleteLocationById(Long locationId) {
        Location location = locationRepository.findById(locationId).orElse(null);
        if(location != null){
            locationRepository.delete(location);
            return MessageFormat.format( "Location with ID {0} has been deleted successfully.", locationId);
        }
        return MessageFormat.format( "There was an issue deleting the location with ID {0}. Or the location does not exist.", locationId);

    }

}
