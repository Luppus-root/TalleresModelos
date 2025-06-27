package com.beautyathome.beautyathome.repository;

import com.beautyathome.beautyathome.model.Profesional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfesionalRepository extends JpaRepository<Profesional, Long> {
    Optional<Profesional> findByNombre(String nombre);
}
