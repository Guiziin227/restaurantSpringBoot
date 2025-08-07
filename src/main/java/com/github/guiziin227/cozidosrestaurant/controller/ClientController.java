package com.github.guiziin227.cozidosrestaurant.controller;

import com.github.guiziin227.cozidosrestaurant.dto.request.ClientRequestDTO;
import com.github.guiziin227.cozidosrestaurant.dto.response.ClientResponseDTO;
import com.github.guiziin227.cozidosrestaurant.mapper.ClientMapper;
import com.github.guiziin227.cozidosrestaurant.model.Client;
import com.github.guiziin227.cozidosrestaurant.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private ClientMapper clientMapper;

    @PostMapping
    public ResponseEntity<ClientResponseDTO> save(@RequestBody @Valid ClientRequestDTO client) {
        Client toEntity = clientMapper.toEntity(client);
        Client savedClient = clientService.create(toEntity);
        ClientResponseDTO responseDTO = clientMapper.toResponseDTO(savedClient);
        return ResponseEntity.ok(responseDTO);
    }

    @PutMapping("/{cpf}")
    public ResponseEntity<ClientResponseDTO> update(@PathVariable String cpf,@RequestBody ClientRequestDTO client) {
        Client toEntity = clientMapper.toEntity(client);
        Client updatedClient = clientService.update(cpf, toEntity);
        ClientResponseDTO responseDTO = clientMapper.toResponseDTO(updatedClient);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<ClientResponseDTO> getByCpf(@PathVariable String cpf) {
        Client client = clientService.findByCpf(cpf);
        if (client == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clientMapper.toResponseDTO(client));
    }

    @GetMapping
    public ResponseEntity<List<ClientResponseDTO>> getAll() {
        List<Client> clients = clientService.findAll();
        return ResponseEntity.ok().body(clientMapper.toResponseDTOList(clients));
    }
}
