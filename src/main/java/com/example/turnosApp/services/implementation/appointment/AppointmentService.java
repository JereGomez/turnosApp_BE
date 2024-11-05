package com.example.turnosApp.services.implementation.appointment;

import com.example.turnosApp.models.dto.create.AppointmetCreateDTO;
import com.example.turnosApp.models.dto.response.AppointmentResponseDTO;
import com.example.turnosApp.models.dto.response.LocationResponseDTO;
import com.example.turnosApp.models.dto.response.ProfessionalResponseDTO;
import com.example.turnosApp.models.dto.response.ServiceResponseDTO;
import com.example.turnosApp.models.dto.update.AppointmentUpdateDTO;
import com.example.turnosApp.models.entity.Appointment;
import com.example.turnosApp.repository.AppointmentReporitory;
import com.example.turnosApp.services.interfaces.appointment.IAppointmentService;
import com.example.turnosApp.services.interfaces.location.ILocationService;
import com.example.turnosApp.services.interfaces.professional.IProfessionalService;
import com.example.turnosApp.services.interfaces.service.IServiceService;
import com.example.turnosApp.utils.JsonPrinter;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
@Service
public class AppointmentService implements IAppointmentService {

    private AppointmentReporitory appointmentRepository;
    private ModelMapper modelMapper;
    private IProfessionalService professionalService;
    private IServiceService serviceService;
    private ILocationService locationService;

    private JsonPrinter jsonPrinter = new JsonPrinter();

    private Logger logger = LoggerFactory.getLogger(AppointmentService.class);

    public AppointmentService(AppointmentReporitory appointmentRepository, ModelMapper modelMapper, IProfessionalService professionalService, IServiceService serviceService, ILocationService locationService){
        this.appointmentRepository = appointmentRepository;
        this.modelMapper =  modelMapper;
        this.professionalService = professionalService;
        this.serviceService = serviceService;
        this.locationService = locationService;
        configureMapping();
    }

    @Override
    public List<AppointmentResponseDTO> getAllAppointments() {
        return (List<AppointmentResponseDTO>) appointmentRepository.findAll()
                .stream()
                .map(appointment -> modelMapper.map(appointment, AppointmentResponseDTO.class))
                .toList();
    }


    @Override
    public AppointmentResponseDTO createAppointment(AppointmetCreateDTO appointmetCreateDTO) {
        //validate that service is available with date, professional, location.
        ProfessionalResponseDTO professionalResponseDTO = professionalService.getProfessionalById(appointmetCreateDTO.getProfessionalId());
        ServiceResponseDTO serviceResponseDTO = serviceService.getServiceById(appointmetCreateDTO.getServiceId());
        LocationResponseDTO locationResponseDTO = locationService.getLocationById(appointmetCreateDTO.getLocationId());
        //Validate that Service is provided in that Location, that Professional works in that location and that Professional provides that Service.
        if(locationService.getServicesInLocation(appointmetCreateDTO.getLocationId()).contains(appointmetCreateDTO.getServiceId()) &&
                locationService.getProfessionalsInLocation(appointmetCreateDTO.getProfessionalId()).contains(appointmetCreateDTO.getProfessionalId()) &&
                professionalService.getServicesOffered(appointmetCreateDTO.getProfessionalId()).contains(appointmetCreateDTO.getServiceId())){
            if(validateDate(getAppointmentByLocationId(appointmetCreateDTO.getLocationId()),appointmetCreateDTO) &&
            validateDate(getAppointmentByServiceId(appointmetCreateDTO.getServiceId()),appointmetCreateDTO) &&
            validateDate(getAppointmentByProfessionalId(appointmetCreateDTO.getProfessionalId()),appointmetCreateDTO)){
                //Validate that Service in that date is available and that Professional in that date is available. Validate that Location is available in that Date
                logger.info("Appointment available to be created: " + jsonPrinter.toString(appointmetCreateDTO));
                Appointment appointmentToSave = modelMapper.map(appointmetCreateDTO, Appointment.class);
                appointmentRepository.save(appointmentToSave);
                AppointmentResponseDTO appointmentResponseDTO = modelMapper.map(appointmentToSave, AppointmentResponseDTO.class);
                return appointmentResponseDTO;
            }
        }



        logger.info("Appointment not available to be created: "+ jsonPrinter.toString(appointmetCreateDTO));
        return null;
    }

    @Override
    public List<AppointmentResponseDTO> getUserAppointments(Long userId) throws Exception {
        //Convert userId into long
        List<AppointmentResponseDTO> appointmentsResponseList= appointmentRepository.findByUserId(userId)
                .stream()
                .map(appointment -> modelMapper.map(appointment, AppointmentResponseDTO.class))
                .toList();
       return appointmentsResponseList;
    }

    @Override
    public List<AppointmentResponseDTO> getAppointmentByLocationId(Long locationId) {
        List<AppointmentResponseDTO> appointmentResponseDTOS = null;
        if(locationId !=null){
            appointmentResponseDTOS = appointmentRepository.findByLocationId(locationId)
                    .stream()
                    .map(appointment -> modelMapper.map(appointment, AppointmentResponseDTO.class))
                    .toList();
        }
        return appointmentResponseDTOS;
    }

    @Override
    public List<AppointmentResponseDTO> getAppointmentByProfessionalId(Long professionalId) {
        List<AppointmentResponseDTO> appointmentResponseDTOS = null;
        if(professionalId !=null){
            appointmentResponseDTOS = appointmentRepository.findByProfessionalId(professionalId)
                    .stream()
                    .map(appointment -> modelMapper.map(appointment, AppointmentResponseDTO.class))
                    .toList();
        }
        return appointmentResponseDTOS;

    }

    @Override
    public List<AppointmentResponseDTO> getAppointmentByServiceId(Long serviceId) {
        List<AppointmentResponseDTO> appointmentResponseDTOS = null;
        if(serviceId !=null){
            appointmentResponseDTOS = appointmentRepository.findByServiceId(serviceId)
                    .stream()
                    .map(appointment -> modelMapper.map(appointment, AppointmentResponseDTO.class))
                    .toList();
        }
        return appointmentResponseDTOS;

    }

    @Override
    public AppointmentResponseDTO getAppointmentById(Long appointmentId) {
        AppointmentResponseDTO appointmentResponseDTO = null;
        if(appointmentId != null){
            appointmentResponseDTO = modelMapper.map(appointmentRepository.getById(appointmentId),AppointmentResponseDTO.class);
            return appointmentResponseDTO;
        }
        return null;
    }

    @Override
    public AppointmentResponseDTO updateAppointment(AppointmentUpdateDTO appointmentUpdateDTO) {
        Appointment appointment = appointmentRepository.findById(appointmentUpdateDTO.getId()).orElse(null);;
        AppointmentResponseDTO appointmentResponseDTO = null;
        Appointment appointmentToSave;
        if (appointment != null){
            appointmentToSave = modelMapper.map(appointmentUpdateDTO, Appointment.class);
            appointmentRepository.save(appointmentToSave);
            appointmentResponseDTO = modelMapper.map(appointmentToSave, AppointmentResponseDTO.class);
        }
        return appointmentResponseDTO;
    }

    @Override
    public String deleteAppointmentById(Long appointmentId) {
        Appointment appointment = appointmentRepository.findById(appointmentId).orElse(null);
        if(appointment != null){
            appointmentRepository.delete(appointment);
            return MessageFormat.format( "Appointment with ID {0} has been deleted successfully.", appointmentId);
        }
        return MessageFormat.format( "There was an issue deleting the appointment with ID {0}. Or the appointment does not exist.", appointmentId);
    }

    private boolean validateDate(List<AppointmentResponseDTO> appointmentsStored, AppointmetCreateDTO appointmentToCreate){
        boolean valid = true;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime bookedDate = null;
        LocalDateTime newAppointmentDate = null;
        for (AppointmentResponseDTO appointmentStored: appointmentsStored) {
            bookedDate = LocalDateTime.parse(appointmentStored.getDate(), formatter);
            newAppointmentDate = LocalDateTime.parse(appointmentToCreate.getDate(), formatter);
            if (newAppointmentDate.isBefore(bookedDate.plusMinutes(30)) && newAppointmentDate.plusMinutes(30).isAfter(bookedDate)) valid=false;

        }
        return valid;
    }

    private void configureMapping(){
        modelMapper.typeMap(AppointmetCreateDTO.class , Appointment.class);
        modelMapper.typeMap(AppointmentUpdateDTO.class , Appointment.class);
        modelMapper.typeMap(Appointment.class, AppointmentResponseDTO.class);
//                .addMappings(mapper-> {
//                    mapper.map(fuente -> fuente.getProfessional().getId(),
//                                AppointmentResponseDTO::setProfessionalId);
//                })
//                .addMappings(mapper-> {
//                    mapper.map(fuente -> fuente.getService().getId(),
//                            AppointmentResponseDTO::setServiceEntityId);
//                })
//                .addMappings(mapper-> {
//                    mapper.map(fuente -> fuente.getLocation().getId(),
//                            AppointmentResponseDTO::setLocationId);
//                })
//                .addMappings(mapper-> {
//                    mapper.map(fuente -> fuente.getRating().getId(),
//                            AppointmentResponseDTO::setRatingId);
//                });

    }
}
