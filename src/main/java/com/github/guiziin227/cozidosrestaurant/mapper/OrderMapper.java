package com.github.guiziin227.cozidosrestaurant.mapper;

import com.github.guiziin227.cozidosrestaurant.dto.request.ClientRequestDTO;
import com.github.guiziin227.cozidosrestaurant.dto.request.OrderRequestDTO;
import com.github.guiziin227.cozidosrestaurant.dto.response.ClientResponseDTO;
import com.github.guiziin227.cozidosrestaurant.dto.response.OrderResponseDTO;
import com.github.guiziin227.cozidosrestaurant.model.Client;
import com.github.guiziin227.cozidosrestaurant.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {WaiterMapper.class, TableMapper.class})
public interface OrderMapper extends GenericMapper<Order, OrderRequestDTO, OrderResponseDTO> {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(source = "waiterId", target = "waiter.id")
    @Mapping(source = "tableId", target = "table.id")
    @Override
    Order toEntity(OrderRequestDTO requestDTO);


    @Override
    OrderResponseDTO toResponseDTO(Order entity);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(source = "waiterId", target = "waiter.id")
    @Mapping(source = "tableId", target = "table.id")
    @Override
    void updateEntityFromDTO(OrderRequestDTO requestDTO, @MappingTarget Order entity);
}
