package com.example.turnosApp.services.interfaces.service;

import com.example.turnosApp.models.dto.create.ServiceCreateDTO;
import com.example.turnosApp.models.dto.response.ServiceResponseDTO;
import com.example.turnosApp.models.dto.update.ServiceUpdateDTO;

import java.util.List;

public interface IServiceService {

    List<ServiceResponseDTO> getAllServices();

    ServiceResponseDTO getServiceById (Long serviceId);
    ServiceResponseDTO createService(ServiceCreateDTO serviceCreateDTO);
    ServiceResponseDTO updateService(ServiceUpdateDTO serviceUpdateDTO);
    String deleteServiceById(Long serviceId);

}
