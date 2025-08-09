package com.github.guiziin227.cozidosrestaurant.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.guiziin227.cozidosrestaurant.model.enums.StatusTable;

public record TableResponseDTO(
        Integer id,
        Integer number,
        Integer capacity,
        StatusTable statusTable,

        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        String createdAt,
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        String updatedAt
) {
}
