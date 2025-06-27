package com.beautyathome.beautyathome.repository;

import com.beautyathome.beautyathome.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// repository/UsuarioRepository.java
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByCorreo(String correo);
}

