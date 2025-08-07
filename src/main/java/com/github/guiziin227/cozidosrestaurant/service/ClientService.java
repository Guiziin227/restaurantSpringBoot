package com.github.guiziin227.cozidosrestaurant.service;

import com.github.guiziin227.cozidosrestaurant.exceptions.UserExistsException;
import com.github.guiziin227.cozidosrestaurant.exceptions.UserNotFoundException;
import com.github.guiziin227.cozidosrestaurant.model.Client;
import com.github.guiziin227.cozidosrestaurant.repository.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientService {

    Logger logger = LoggerFactory.getLogger(ClientService.class);

    @Autowired
    private ClientRepository clientRepository;

    @Transactional
    public Client create(Client client) {
        if (clientRepository.existsByCpf(client.getCpf())) {
            logger.warn("Cpf already exists!");
            throw new UserExistsException("Client with CPF " + client.getCpf() + " already exists.");
        }

        logger.info("Create client with CPF {}", client.getCpf());
        return clientRepository.save(client);
    }

    @Transactional(readOnly = true)
    public Client findByCpf(String cpf) {
        if (!clientRepository.existsByCpf(cpf)) {
            logger.warn("Client with CPF {} not found", cpf);
        }
        logger.info("Client with CPF {} found", cpf);
        return clientRepository.findByCpf(cpf).orElse(null);
    }

    @Transactional
    public Client update(String cpf, Client client) {
        Client existing = clientRepository.findByCpf(cpf)
                .orElseThrow(() -> new UserNotFoundException("Client with CPF " + cpf + " not found."));

        existing.setName(client.getName());
        existing.setAge(client.getAge());

        return clientRepository.save(existing);
    }

    @Transactional(readOnly = true)
    public List<Client> findAll() {
        return clientRepository.findAll();
    }
}
