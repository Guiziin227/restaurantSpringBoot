package com.github.guiziin227.cozidosrestaurant.controller;

import com.github.guiziin227.cozidosrestaurant.model.Client;
import com.github.guiziin227.cozidosrestaurant.service.ClientService;
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

    @PostMapping
    public ResponseEntity<Client> save(@RequestBody Client client) {
        Client savedClient = clientService.create(client);
        return ResponseEntity.ok(savedClient);
    }

    @PutMapping("/{cpf}")
    public ResponseEntity<Client> update(@PathVariable String cpf,@RequestBody Client client) {
        Client updatedClient = clientService.update(cpf,client);
        return ResponseEntity.ok(updatedClient);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Client> getByCpf(@PathVariable String cpf) {
        Client client = clientService.findByCpf(cpf);
        if (client == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(client);
    }

    @GetMapping
    public ResponseEntity<List<Client>> getAll() {
        List<Client> clients = clientService.findAll();
        return ResponseEntity.ok().body(clients);
    }
}
