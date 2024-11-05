package com.example.turnosApp.repository;

import com.example.turnosApp.models.dto.response.ServiceResponseDTO;
import com.example.turnosApp.models.entity.Location;
import com.example.turnosApp.models.entity.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ServiceRepository extends JpaRepository<ServiceEntity, Long> {

    Optional<ServiceEntity> findByTitle(String title);

}
