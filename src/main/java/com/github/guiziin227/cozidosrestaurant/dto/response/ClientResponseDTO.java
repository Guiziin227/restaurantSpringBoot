package com.github.guiziin227.cozidosrestaurant.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;

public record ClientResponseDTO(
        UUID id,
        String name,
        String cpf,
        int age,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
