package com.github.guiziin227.cozidosrestaurant.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public record ClientRequestDTO(
        @NotBlank
        @Size(min = 5, max = 120, message = "Name must be between 5 and 120 characters")
        String name,

        @NotBlank
        @Size(min = 11, max = 11, message = "CPF must be exactly 11 digits")
        String cpf,

        @NotNull
        int age
        ) {
}
