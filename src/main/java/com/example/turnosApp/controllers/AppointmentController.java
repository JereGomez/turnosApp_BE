package com.example.turnosApp.controllers;

import com.example.turnosApp.models.dto.create.AppointmetCreateDTO;
import com.example.turnosApp.models.dto.response.AppointmentResponseDTO;
import com.example.turnosApp.models.dto.update.AppointmentUpdateDTO;
import com.example.turnosApp.services.interfaces.appointment.IAppointmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private IAppointmentService appointmentService;

    public AppointmentController(IAppointmentService appointmentService){
        this.appointmentService = appointmentService;
    }

    //GET
    @GetMapping("/{userId}")
    public ResponseEntity<List<AppointmentResponseDTO>>  getUserAppointments(@PathVariable Long userId) throws Exception {
        return new ResponseEntity<>(appointmentService.getUserAppointments(userId), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<AppointmentResponseDTO>> getAllAppointments(){
        return new ResponseEntity<>(appointmentService.getAllAppointments(),HttpStatus.OK);
    }

    //POST
    @PostMapping
    public ResponseEntity<AppointmentResponseDTO> createAppointment(@RequestBody AppointmetCreateDTO appointmetCreateDTO){
        return new ResponseEntity<>(appointmentService.createAppointment(appointmetCreateDTO), HttpStatus.OK);
    }

    //PUT
    @PutMapping
    public ResponseEntity<AppointmentResponseDTO> updateAppointment (@RequestBody AppointmentUpdateDTO appointmentUpdateDTO){
        return new ResponseEntity<>(appointmentService.updateAppointment(appointmentUpdateDTO), HttpStatus.OK);
    }

    //DELETE
    @DeleteMapping("/{Id}")
    public ResponseEntity<String> deleteAppointmentById (@PathVariable Long Id){
        return new ResponseEntity<>(appointmentService.deleteAppointmentById(Id),HttpStatus.OK);
    }
}
