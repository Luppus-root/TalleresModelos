package com.beautyathome.backend.repository;

import com.beautyathome.backend.pattern.composite.ServicioComponent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicioRepository extends JpaRepository<ServicioComponent, Long> {
}
