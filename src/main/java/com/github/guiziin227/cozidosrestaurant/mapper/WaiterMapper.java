package com.github.guiziin227.cozidosrestaurant.mapper;

import com.github.guiziin227.cozidosrestaurant.dto.request.ClientRequestDTO;
import com.github.guiziin227.cozidosrestaurant.dto.request.WaiterRequestDTO;
import com.github.guiziin227.cozidosrestaurant.dto.response.ClientResponseDTO;
import com.github.guiziin227.cozidosrestaurant.dto.response.WaiterResponseDTO;
import com.github.guiziin227.cozidosrestaurant.model.Client;
import com.github.guiziin227.cozidosrestaurant.model.Waiter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface WaiterMapper extends GenericMapper<Waiter, WaiterRequestDTO, WaiterResponseDTO> {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Override
    Waiter toEntity(WaiterRequestDTO requestDTO);

    @Override
    WaiterResponseDTO toResponseDTO(Waiter entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Override
    void updateEntityFromDTO(WaiterRequestDTO requestDTO, @MappingTarget Waiter entity);
}
