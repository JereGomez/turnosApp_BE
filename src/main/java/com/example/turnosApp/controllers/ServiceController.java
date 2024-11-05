package com.example.turnosApp.controllers;

import com.example.turnosApp.models.dto.create.ServiceCreateDTO;
import com.example.turnosApp.models.dto.response.ServiceResponseDTO;
import com.example.turnosApp.models.dto.update.ServiceUpdateDTO;
import com.example.turnosApp.models.entity.ServiceEntity;
import com.example.turnosApp.services.interfaces.service.IServiceService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")
public class ServiceController {
    IServiceService serviceService;

    public ServiceController(IServiceService serviceService) {
        this.serviceService = serviceService;
    }

//    GET
    @GetMapping()
    public ResponseEntity<List<ServiceResponseDTO>> getAllServices(){
        return new ResponseEntity<>(serviceService.getAllServices(), HttpStatus.OK);
    }

//    POST
    @PostMapping()
    public ResponseEntity<ServiceResponseDTO> createService(@RequestBody ServiceCreateDTO serviceCreateDTO){
        return new ResponseEntity<>(serviceService.createService(serviceCreateDTO), HttpStatus.OK);
    }
//    PUT
    @PutMapping()
    public ResponseEntity<ServiceResponseDTO> updateService(@RequestBody ServiceUpdateDTO serviceUpdateDTO){
        return new ResponseEntity<>(serviceService.updateService(serviceUpdateDTO), HttpStatus.OK);
    }
//    DELETE
    @DeleteMapping("{serviceId}")
    public ResponseEntity<String> deleteServiceById(@RequestParam Long serviceId){
        return new ResponseEntity<>(serviceService.deleteServiceById(serviceId), HttpStatus.OK);
    }
}

