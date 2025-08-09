package com.github.guiziin227.cozidosrestaurant.dto.request;

import com.github.guiziin227.cozidosrestaurant.model.enums.StatusTable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record TableRequestDTO(
        @NotNull @Positive
        Integer number,
        @NotNull @Positive
        Integer capacity,
        @NotNull
        StatusTable status
) {
}
