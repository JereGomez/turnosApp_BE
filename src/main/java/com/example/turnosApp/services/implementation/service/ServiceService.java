package com.example.turnosApp.services.implementation.service;

import com.example.turnosApp.models.dto.create.ServiceCreateDTO;
import com.example.turnosApp.models.dto.response.ServiceResponseDTO;
import com.example.turnosApp.models.dto.update.ServiceUpdateDTO;
import com.example.turnosApp.models.entity.ServiceEntity;
import com.example.turnosApp.repository.ServiceRepository;
import com.example.turnosApp.services.interfaces.service.IServiceService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

@Service
public class ServiceService implements IServiceService {
    ServiceRepository serviceRepository;
    ModelMapper modelMapper;

    public ServiceService(ServiceRepository serviceRepository, ModelMapper modelMapper) {
        this.serviceRepository = serviceRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ServiceResponseDTO> getAllServices() {
        List<ServiceResponseDTO> serviceList= serviceRepository.findAll()
                .stream()
                .map(serviceEntity -> modelMapper.map(serviceEntity, ServiceResponseDTO.class))
                .toList();
        return serviceList;
    }

    @Override
    public ServiceResponseDTO getServiceById(Long serviceId){
        ServiceEntity serviceEntity = serviceRepository.findById(serviceId).orElse(null);
        if(serviceEntity != null){
            return modelMapper.map(serviceEntity, ServiceResponseDTO.class);
        }

        return null;
    }

    @Override
    public ServiceResponseDTO createService(ServiceCreateDTO serviceCreateDTO) {
        ServiceEntity service = serviceRepository.findByTitle(serviceCreateDTO.getTitle()).orElse(null);
        ServiceResponseDTO serviceResponseDTO = null;
        if(service == null){
            service = modelMapper.map(serviceCreateDTO, ServiceEntity.class);
            serviceRepository.save(service);
            serviceResponseDTO = modelMapper.map(service, ServiceResponseDTO.class);
        }
        return serviceResponseDTO;
    }

    @Override
    public ServiceResponseDTO updateService(ServiceUpdateDTO serviceUpdateDTO) {
        ServiceEntity service = serviceRepository.findById(serviceUpdateDTO.getId()).orElse(null);
        ServiceResponseDTO serviceResponseDTO = null;
        if(service != null){
           service = modelMapper.map(serviceUpdateDTO, ServiceEntity.class);
           serviceRepository.save(service);
           serviceResponseDTO = modelMapper.map(service, ServiceResponseDTO.class);
        }
        return serviceResponseDTO;
    }

    @Override
    public String deleteServiceById(Long serviceId) {
        serviceRepository.deleteById(serviceId);
        return MessageFormat.format("Service with ID {0} has been deleted successfully.", serviceId);
    }
}
