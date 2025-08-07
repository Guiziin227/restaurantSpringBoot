package com.github.guiziin227.cozidosrestaurant.mapper;

import com.github.guiziin227.cozidosrestaurant.dto.request.ClientRequestDTO;
import com.github.guiziin227.cozidosrestaurant.dto.response.ClientResponseDTO;
import com.github.guiziin227.cozidosrestaurant.model.Client;
import org.mapstruct.*;

/**
 * Mapper para a entidade Client usando MapStruct
 */
@Mapper(componentModel = "spring")
public interface ClientMapper extends GenericMapper<Client, ClientRequestDTO, ClientResponseDTO> {

    /**
     * Mapeia ClientRequestDTO para Client
     * Ignora campos de auditoria que são gerenciados automaticamente
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Override
    Client toEntity(ClientRequestDTO requestDTO);

    /**
     * Mapeia Client para ClientResponseDTO
     * Todos os campos são mapeados automaticamente
     */
    @Override
    ClientResponseDTO toResponseDTO(Client entity);

    /**
     * Atualiza uma entidade Client existente com dados do ClientRequestDTO
     * Ignora campos de identidade e auditoria
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Override
    void updateEntityFromDTO(ClientRequestDTO requestDTO, @MappingTarget Client entity);
}

