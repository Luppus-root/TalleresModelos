package com.beautyathome.beautyathome.auth.service;

import com.beautyathome.beautyathome.auth.dto.AuthResponse;
import com.beautyathome.beautyathome.auth.dto.LoginRequest;
import com.beautyathome.beautyathome.auth.dto.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

// auth/service/AuthService.java
@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository usuarioRepo;
    private final PasswordEncoder encoder;
    private final JwtService jwtService;

    public AuthResponse register(RegisterRequest req) {
        Usuario nuevo = new Usuario();
        nuevo.setNombre(req.nombre());
        nuevo.setCorreo(req.correo());
        nuevo.setPassword(encoder.encode(req.password()));
        nuevo.setRol(req.rol());
        usuarioRepo.save(nuevo);

        String token = jwtService.generarToken(nuevo);
        return new AuthResponse(token, req.rol().name(), req.nombre());
    }

    public AuthResponse login(LoginRequest req) {
        Usuario usuario = usuarioRepo.findByCorreo(req.correo())
                .orElseThrow(() -> new UsernameNotFoundException("Correo no registrado"));

        if (!encoder.matches(req.password(), usuario.getPassword())) {
            throw new BadCredentialsException("Contraseña incorrecta");
        }

        String token = jwtService.generarToken(usuario);
        return new AuthResponse(token, usuario.getRol().name(), usuario.getNombre());
    }
}
