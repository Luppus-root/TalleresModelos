package com.beautyathome.beautyathome.repository;
import com.beautyathome.beautyathome.model.ResenaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// repository/ResenaRepository.java
public interface ResenaRepository extends JpaRepository<ResenaEntity, Long> {
    List<ResenaEntity> findByProfesionalId(Long profesionalId);
}
