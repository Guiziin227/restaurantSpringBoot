package com.github.guiziin227.cozidosrestaurant.mapper;

import com.github.guiziin227.cozidosrestaurant.dto.request.TableRequestDTO;
import com.github.guiziin227.cozidosrestaurant.dto.response.TableResponseDTO;
import com.github.guiziin227.cozidosrestaurant.model.Tables;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TableMapper extends GenericMapper<Tables, TableRequestDTO, TableResponseDTO> {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Override
    Tables toEntity(TableRequestDTO requestDTO);

    @Override
    TableResponseDTO toResponseDTO(Tables entity);

    @Mapping(target = "id", ignore = true)
    @Override
    void updateEntityFromDTO(TableRequestDTO requestDTO, @MappingTarget Tables entity);
}
