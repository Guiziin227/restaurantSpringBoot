package com.github.guiziin227.cozidosrestaurant.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record WaiterRequestDTO(
        @NotBlank
        @Size(min = 4, max = 120)
        String name,

        @NotBlank
        @Size(max = 7)
        String accessCode
) {
}
