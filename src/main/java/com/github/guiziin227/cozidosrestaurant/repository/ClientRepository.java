package com.github.guiziin227.cozidosrestaurant.repository;

import com.github.guiziin227.cozidosrestaurant.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<Client, UUID> {
    boolean existsByCpf(String cpf);

    Optional<Client> findByCpf(String cpf);
}
