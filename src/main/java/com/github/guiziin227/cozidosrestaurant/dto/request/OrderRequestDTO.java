package com.github.guiziin227.cozidosrestaurant.dto.request;

import com.github.guiziin227.cozidosrestaurant.model.enums.StatusOrder;
import jakarta.validation.constraints.NotNull;

public record OrderRequestDTO(
        @NotNull
        Long tableId,

        @NotNull
        Long waiterId,

        @NotNull
        StatusOrder statusOrder
) {
}
