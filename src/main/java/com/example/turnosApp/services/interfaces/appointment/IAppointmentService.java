package com.example.turnosApp.services.interfaces.appointment;

import com.example.turnosApp.models.dto.create.AppointmetCreateDTO;
import com.example.turnosApp.models.dto.response.AppointmentResponseDTO;
import com.example.turnosApp.models.dto.update.AppointmentUpdateDTO;

import java.util.List;

public interface IAppointmentService {
    List<AppointmentResponseDTO> getAllAppointments();

    AppointmentResponseDTO createAppointment(AppointmetCreateDTO appointmetCreateDTO);

    List<AppointmentResponseDTO> getUserAppointments(Long userId) throws Exception;
    List<AppointmentResponseDTO> getAppointmentByLocationId(Long locationId);
    List<AppointmentResponseDTO> getAppointmentByProfessionalId(Long professionalId);
    List<AppointmentResponseDTO> getAppointmentByServiceId(Long serviceId);

    AppointmentResponseDTO getAppointmentById(Long appointmentId);

    AppointmentResponseDTO updateAppointment(AppointmentUpdateDTO appointmentUpdateDTO);

    String deleteAppointmentById (Long Id);
}
