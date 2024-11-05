package com.example.turnosApp.repository;

import com.example.turnosApp.models.entity.Appointment;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentReporitory  extends JpaRepository<Appointment, Long> {
    @Query("SELECT a FROM Appointment a WHERE a.user.id = :user_id")
    List<Appointment> findByUserId(@Param("user_id")Long user_id);

    @Query("SELECT a FROM Appointment a WHERE a.location.id = :location_id")
    List<Appointment> findByLocationId(@Param("location_id")Long location_id);

    @Query("SELECT a FROM Appointment a WHERE a.professional.id = :professional_id")
    List<Appointment> findByProfessionalId(@Param("professional_id")Long professional_id);

    @Query("SELECT a FROM Appointment a WHERE a.serviceEntity.id = :serviceEntity_id")
    List<Appointment> findByServiceId(@Param("serviceEntity_id")Long serviceEntity_id);
}
