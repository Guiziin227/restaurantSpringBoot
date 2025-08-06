package com.github.guiziin227.cozidosrestaurant.controller;

import com.github.guiziin227.cozidosrestaurant.model.Client;
import com.github.guiziin227.cozidosrestaurant.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping
    public ResponseEntity<Client> getAll() {
        List<Client> clients = clientService.findAll();
        return ResponseEntity.ok().body((Client) clients);
    }
}
