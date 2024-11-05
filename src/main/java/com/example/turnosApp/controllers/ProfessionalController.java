package com.example.turnosApp.controllers;

import com.example.turnosApp.models.dto.create.ProfessionalCreateDTO;
import com.example.turnosApp.models.dto.response.ProfessionalResponseDTO;
import com.example.turnosApp.models.dto.update.ProfessionalUpdateDTO;
import com.example.turnosApp.services.interfaces.professional.IProfessionalService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professionals")
public class ProfessionalController {

    IProfessionalService professionalService;

    public ProfessionalController(IProfessionalService professionalService) {
        this.professionalService = professionalService;
    }

//    GET
    @GetMapping()
    public ResponseEntity<List<ProfessionalResponseDTO>> getAllProfessionals(){
        return new ResponseEntity<>(professionalService.getAllProfessionals(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessionalResponseDTO> getProfessionalById(@PathVariable Long id){
        return new ResponseEntity<>(professionalService.getProfessionalById(id), HttpStatus.OK);
    }

//    POST
    @PostMapping
    public ResponseEntity<ProfessionalResponseDTO> createProfessional(@RequestBody ProfessionalCreateDTO professionalCreateDTO){
        return new ResponseEntity<>(professionalService.createProfessional(professionalCreateDTO), HttpStatus.OK);
    }

//    PUT
    public ResponseEntity<ProfessionalResponseDTO> updateProfessional(@RequestBody ProfessionalUpdateDTO professionalUpdateDTO){
        return new ResponseEntity<>(professionalService.updateProfessional(professionalUpdateDTO), HttpStatus.OK);
    }
//    DELETE
    public ResponseEntity<String> deleteProfessionalById(@RequestParam Long professionalId){
        return new ResponseEntity<>(professionalService.deleteProfessionalById(professionalId), HttpStatus.OK);
    }
}
