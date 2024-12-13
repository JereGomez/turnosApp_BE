package com.example.turnosApp.services.implementation.professional;

import com.example.turnosApp.models.dto.create.ProfessionalCreateDTO;
import com.example.turnosApp.models.dto.response.ProfessionalResponseDTO;
import com.example.turnosApp.models.dto.update.ProfessionalUpdateDTO;
import com.example.turnosApp.models.entity.Location;
import com.example.turnosApp.models.entity.Professional;
import com.example.turnosApp.models.entity.ServiceEntity;
import com.example.turnosApp.models.entity.Appointment;
import com.example.turnosApp.repository.ProfessionalRepository;
import com.example.turnosApp.services.implementation.location.LocationService;
import com.example.turnosApp.services.interfaces.professional.IProfessionalService;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.nio.file.ProviderNotFoundException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProfessionalService implements IProfessionalService {

    private ProfessionalRepository professionalRepository;
    private ModelMapper modelMapper;

    Logger logger = LoggerFactory.getLogger(ProfessionalService.class);

    public ProfessionalService(ModelMapper modelMapper,ProfessionalRepository professionalRepository ){
        this.modelMapper = modelMapper;
        this.professionalRepository = professionalRepository;
    }


    @Override
    public List<ProfessionalResponseDTO> getAllProfessionals() {
        List<ProfessionalResponseDTO> professionalResponseDTOS = professionalRepository.findAll()
                .stream()
                .map(professional -> modelMapper.map(professional, ProfessionalResponseDTO.class))
                .toList();
        return professionalResponseDTOS;
    }

    @Override
    public ProfessionalResponseDTO getProfessionalById(Long professionalId) {
        Professional professional = null;
        professional = professionalRepository.findById(professionalId).orElse(null);
        ProfessionalResponseDTO professionalResponseDTO = modelMapper.map(professional, ProfessionalResponseDTO.class);
        if(professionalResponseDTO != null){
           return professionalResponseDTO;
        }
        return null;
    }

    @Override
    public List<Long> getServicesOffered(Long Id) {
        List<Long> servicesOffered = new ArrayList<>();
        Professional professional = professionalRepository.findById(Id).orElse(null);
        if(professional != null){
            for (ServiceEntity service : professional.getServicesOffer()) {
                servicesOffered.add(service.getId());
            }
        }
        return servicesOffered;
    }

    @Override
    public ProfessionalResponseDTO createProfessional(ProfessionalCreateDTO professionalCreateDTO) {
        Professional professional = professionalRepository.findByName(professionalCreateDTO.getFirstName()).orElse(null);
        ProfessionalResponseDTO professionalResponseDTO = null;
        if(professional == null) {
            professional = modelMapper.map(professionalCreateDTO, Professional.class);
            professionalRepository.save(professional);
            professionalResponseDTO = modelMapper.map(professional, ProfessionalResponseDTO.class);
        }
        else{
            logger.info("Professional with that name already exists.");
        }
        return professionalResponseDTO;
    }

    @Override
    public ProfessionalResponseDTO updateProfessional(ProfessionalUpdateDTO professionalUpdateDTO) {
        Professional professional = professionalRepository.findById(professionalUpdateDTO.getId()).orElse(null);
        ProfessionalResponseDTO professionalResponseDTO = null;
        if(professional != null) {
            professional = modelMapper.map(professionalUpdateDTO, Professional.class);
            professionalRepository.save(professional);
            professionalResponseDTO = modelMapper.map(professional,ProfessionalResponseDTO.class);
        }

        return professionalResponseDTO;
    }

    @Override
    public String deleteProfessionalById(Long professionalId) {
        professionalRepository.deleteById(professionalId);
        return MessageFormat.format( "Professional with ID {0} has been deleted successfully.", professionalId);

    }
}
