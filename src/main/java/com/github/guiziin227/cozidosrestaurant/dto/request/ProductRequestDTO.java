package com.github.guiziin227.cozidosrestaurant.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductRequestDTO(
        @NotBlank(message = "Name is mandatory")
        String name,
        @NotBlank
        String description,
        @NotNull
        Double price,
        @NotNull
        Boolean prepared
) {
}