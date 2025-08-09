package com.github.guiziin227.cozidosrestaurant.repository;

import com.github.guiziin227.cozidosrestaurant.model.Waiter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WaiterRepository extends JpaRepository<Waiter, Long> {

    boolean existsByAccessCode(String accessCode);

    Optional<Waiter> findByAccessCode(String accessCode);
}
