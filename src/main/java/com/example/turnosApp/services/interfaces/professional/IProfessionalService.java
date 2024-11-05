package com.example.turnosApp.services.interfaces.professional;


import com.example.turnosApp.models.dto.create.ProfessionalCreateDTO;
import com.example.turnosApp.models.dto.response.ProfessionalResponseDTO;
import com.example.turnosApp.models.dto.update.ProfessionalUpdateDTO;

import java.util.List;

public interface IProfessionalService {

    List<ProfessionalResponseDTO> getAllProfessionals();
    ProfessionalResponseDTO getProfessionalById(Long professionalId);
    List<Long> getServicesOffered(Long profesionalId);

    ProfessionalResponseDTO createProfessional(ProfessionalCreateDTO professionalCreateDTO);
    ProfessionalResponseDTO updateProfessional(ProfessionalUpdateDTO professionalUpdateDTO);

    String deleteProfessionalById (Long professionalId);
}
