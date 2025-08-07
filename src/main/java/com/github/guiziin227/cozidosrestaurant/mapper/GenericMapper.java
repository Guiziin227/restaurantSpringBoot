package com.github.guiziin227.cozidosrestaurant.mapper;

import org.mapstruct.MappingTarget;

import java.util.List;

/**
 * Interface genérica para mapeamento usando MapStruct
 *
 * @param <E> Tipo da entidade
 * @param <REQ> Tipo do DTO de request
 * @param <RES> Tipo do DTO de response
 */
public interface GenericMapper<E, REQ, RES> {

    /**
     * Converte um DTO de request para uma entidade
     *
     * @param requestDTO DTO de request a ser convertido
     * @return Entidade correspondente
     */
    E toEntity(REQ requestDTO);

    /**
     * Converte uma entidade para um DTO de response
     *
     * @param entity Entidade a ser convertida
     * @return DTO de response correspondente
     */
    RES toResponseDTO(E entity);

    /**
     * Converte uma lista de entidades para uma lista de DTOs de response
     *
     * @param entities Lista de entidades a serem convertidas
     * @return Lista de DTOs de response correspondentes
     */
    List<RES> toResponseDTOList(List<E> entities);

    /**
     * Atualiza uma entidade existente com dados de um DTO de request
     * Usa @MappingTarget do MapStruct para atualizar a entidade existente
     *
     * @param requestDTO DTO com os novos dados
     * @param entity Entidade existente a ser atualizada
     */
    void updateEntityFromDTO(REQ requestDTO, @MappingTarget E entity);
}

