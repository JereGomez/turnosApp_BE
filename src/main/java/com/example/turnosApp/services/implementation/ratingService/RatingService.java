package com.example.turnosApp.services.implementation.ratingService;

import com.example.turnosApp.models.dto.create.RatingCreateDTO;
import com.example.turnosApp.models.dto.response.AppointmentResponseDTO;
import com.example.turnosApp.models.dto.response.ProfessionalResponseDTO;
import com.example.turnosApp.models.dto.response.RatingResponseDTO;
import com.example.turnosApp.models.dto.response.UserResponseDTO;
import com.example.turnosApp.models.entity.*;
import com.example.turnosApp.repository.RatingRepository;
import com.example.turnosApp.services.implementation.appointment.AppointmentService;
import com.example.turnosApp.services.implementation.professional.ProfessionalService;
import com.example.turnosApp.services.implementation.service.ServiceService;
import com.example.turnosApp.services.implementation.user.UserService;
import com.example.turnosApp.services.interfaces.rating.IRatingService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

@Service
public class RatingService implements IRatingService {
    ModelMapper modelMapper;
    RatingRepository ratingRepository;
    AppointmentService appointmentService;
    UserService userService;
    ServiceService serviceService;
    ProfessionalService professionalService;

    private Logger logger = LoggerFactory.getLogger(RatingService.class);


    public RatingService(ModelMapper modelMapper, RatingRepository ratingRepository, AppointmentService appointmentService, UserService userService, ServiceService serviceService, ProfessionalService professionalService) {
        this.modelMapper = modelMapper;
        this.ratingRepository = ratingRepository;
        this.appointmentService = appointmentService;
        this.userService = userService;
        this.serviceService = serviceService;
        this.professionalService = professionalService;
    }

    @Override
    public List<RatingResponseDTO> getAllRatings() {
        return ratingRepository.findAll()
                .stream()
                .map(rating -> modelMapper.map(rating, RatingResponseDTO.class))
                .toList();
    }

    @Override
    public RatingResponseDTO getRatingById(Long ratingId) {
        RatingResponseDTO ratingResponseDTO = null;
        Rating rating = null;
        if(ratingId != null){
            rating  = ratingRepository.findById(ratingId).orElse(null);
            ratingResponseDTO = modelMapper.map(rating, RatingResponseDTO.class);
        }
        return ratingResponseDTO;
    }

    @Override
    public RatingResponseDTO createRating(RatingCreateDTO ratingCreateDTO) {
        Rating ratingToSave = modelMapper.map(ratingCreateDTO, Rating.class);
        AppointmentResponseDTO appointmentOfRating = appointmentService.getAppointmentById(ratingCreateDTO.getAppointmentId());
        UserResponseDTO user = userService.getUserById(appointmentOfRating.getUserId());
        logger.info(user.toString());
        if(appointmentOfRating != null){
            ratingToSave.setProfessional(modelMapper.map(professionalService.getProfessionalById(appointmentOfRating.getProfessionalId()), Professional.class));
            ratingToSave.setService(modelMapper.map(serviceService.getServiceById(appointmentOfRating.getServiceEntityId()), ServiceEntity.class));
            ratingToSave.setUser(modelMapper.map(userService.getUserById( appointmentOfRating.getUserId()), User.class));
//            ratingToSave.setAppointment(modelMapper.map(appointmentOfRating.getServiceEntityId(), Appointment.class));
            ratingToSave = ratingRepository.save(ratingToSave);
        }

        RatingResponseDTO ratingResponseDTO = modelMapper.map(ratingToSave, RatingResponseDTO.class);
        return ratingResponseDTO;
    }

    @Override
    public RatingResponseDTO updateRating(Long ratingId) {
        return null;
    }

    @Override
    public String deleteRatingById(Long ratingId) {
        ratingRepository.deleteById(ratingId);
        return MessageFormat.format( "Rating with ID {0} has been deleted successfully.", ratingId);
    }

    private void configMapper(){
        modelMapper.typeMap(ProfessionalResponseDTO.class, Professional.class);
    }
}
