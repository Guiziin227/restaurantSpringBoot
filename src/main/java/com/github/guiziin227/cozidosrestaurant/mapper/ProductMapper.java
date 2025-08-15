package com.github.guiziin227.cozidosrestaurant.mapper;

import com.github.guiziin227.cozidosrestaurant.dto.request.ProductRequestDTO;
import com.github.guiziin227.cozidosrestaurant.dto.response.ProductResponseDTO;
import com.github.guiziin227.cozidosrestaurant.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper extends GenericMapper<Product, ProductRequestDTO, ProductResponseDTO> {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Override
    Product toEntity(ProductRequestDTO requestDTO);

    /**
     * Mapeia Product para ProductResponseDTO
     * Todos os campos são mapeados automaticamente
     */
    @Override
    ProductResponseDTO toResponseDTO(Product entity);

    /**
     * Atualiza uma entidade Product existente com dados do ProductRequestDTO
     * Ignora campos de identidade e auditoria
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Override
    void updateEntityFromDTO(ProductRequestDTO requestDTO, @MappingTarget Product entity);
}
