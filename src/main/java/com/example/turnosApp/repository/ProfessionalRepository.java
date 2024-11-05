package com.example.turnosApp.repository;

import com.example.turnosApp.models.entity.Location;
import com.example.turnosApp.models.entity.Professional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfessionalRepository extends JpaRepository<Professional, Long> {

    Optional<Professional> findByName(String name);
}
