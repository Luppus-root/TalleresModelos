package com.beautyathome.beautyathome.service.core;

import com.beautyathome.beautyathome.model.Resena;
import com.beautyathome.beautyathome.model.ResenaEntity;
import com.beautyathome.beautyathome.proxy.ResenaProxy;
import com.beautyathome.beautyathome.repository.ResenaRepository;
import com.beautyathome.beautyathome.repository.dto.ResenaDTO;
import com.beautyathome.beautyathome.repository.dto.ResenaPrivadaDTO;
import com.beautyathome.beautyathome.visitor.EstadisticasResenasVisitor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ResenaService {

    private final ResenaRepository repo;

    public void publicar(String profesionalId, ResenaDTO dto) {
        ResenaEntity r = new ResenaEntity();
        r.setClienteAnonimo(dto.clienteAnonimo());
        r.setTexto(dto.texto());
        r.setEstrellas(dto.estrellas());
        r.setFecha(LocalDate.now());
        r.setImagenes(dto.imagenes());
        r.setProfesionalId(profesionalId);

        repo.save(r);
    }

    public List<ResenaPrivadaDTO> obtenerConPrivacidad(String profesionalId, boolean tienePermiso) {
        return repo.findByProfesionalId(profesionalId).stream()
                .map(r -> {
                    ResenaProxy proxy = new ResenaProxy(convertir(r), tienePermiso);
                    return new ResenaPrivadaDTO(
                            proxy.getTexto().orElse("Contenido oculto"),
                            proxy.getEstrellas(),
                            proxy.getImagenes().orElse(List.of())
                    );
                })
                .toList();
    }

    public double promedioEstrellas(String profesionalId) {
        List<Resena> resenas = repo.findByProfesionalId(profesionalId).stream()
                .map(this::convertir)
                .toList();

        EstadisticasResenasVisitor visitor = new EstadisticasResenasVisitor();
        resenas.forEach(r -> r.aceptar(visitor));
        return visitor.obtenerPromedio();
    }

    private Resena convertir(ResenaEntity r) {
        return new Resena(r.getClienteAnonimo(), r.getTexto(), r.getEstrellas(), r.getFecha(), r.getImagenes());
    }
}
