package com.beautyathome.backend.dto;

import lombok.*;
import jakarta.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReseñaDTO {

    private Long id;

    @NotBlank
    private String texto;

    @Min(1)
    @Max(5)
    private int estrellas;

    private Long servicioRealizadoId;
}

