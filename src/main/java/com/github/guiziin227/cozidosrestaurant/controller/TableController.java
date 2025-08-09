package com.github.guiziin227.cozidosrestaurant.controller;

import com.github.guiziin227.cozidosrestaurant.dto.request.TableRequestDTO;
import com.github.guiziin227.cozidosrestaurant.dto.response.TableResponseDTO;
import com.github.guiziin227.cozidosrestaurant.mapper.GenericMapper;
import com.github.guiziin227.cozidosrestaurant.mapper.TableMapper;
import com.github.guiziin227.cozidosrestaurant.model.Tables;
import com.github.guiziin227.cozidosrestaurant.service.TableService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/tables")
public class TableController {

    @Autowired
    private TableService tableService;

    @Autowired
    private TableMapper mapper;

    @PostMapping
    public ResponseEntity<TableResponseDTO> createTable(@RequestBody TableRequestDTO requestDTO) {
        Tables table = mapper.toEntity(requestDTO);
        Tables savedTable = tableService.create(table);
        return ResponseEntity.ok(mapper.toResponseDTO(savedTable));
    }

    @GetMapping("/{number}")
    public ResponseEntity<TableResponseDTO> getTableByNumber(@PathVariable Integer number) {
        Tables table = tableService.findByNumber(number);
        if (table == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(mapper.toResponseDTO(table));
    }

    @GetMapping
    public ResponseEntity<List<TableResponseDTO>> getTables() {
        List<Tables> tables = tableService.findAll();
        List<TableResponseDTO> responseDTOs = mapper.toResponseDTOList(tables);
        return ResponseEntity.ok(responseDTOs);
    }

}
