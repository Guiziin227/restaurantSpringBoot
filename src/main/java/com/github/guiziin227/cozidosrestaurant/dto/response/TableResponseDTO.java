package com.github.guiziin227.cozidosrestaurant.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.guiziin227.cozidosrestaurant.model.enums.StatusTable;

import java.time.LocalDateTime;
import java.util.Date;

public record TableResponseDTO(
        Long id,
        Integer number,
        Integer capacity,
        StatusTable status,

        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        LocalDateTime createdAt,
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        LocalDateTime updatedAt
) {
}
