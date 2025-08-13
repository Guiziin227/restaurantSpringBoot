package com.github.guiziin227.cozidosrestaurant.dto.response.summary;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.guiziin227.cozidosrestaurant.model.enums.StatusOrder;

import java.time.LocalDateTime;

public record OrderSummaryResponseDTO(
        Long id,
        StatusOrder status,
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        LocalDateTime createdAt,
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        LocalDateTime updatedAt,
        Long waiterId,
        Long tableId
) {
}
