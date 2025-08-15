package com.github.guiziin227.cozidosrestaurant.dto.response;

public record ProductResponseDTO(
        Long id,
        String name,
        String description,
        Double price,
        Boolean prepared
) {
}