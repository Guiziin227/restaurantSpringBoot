package com.github.guiziin227.cozidosrestaurant.repository;

import com.github.guiziin227.cozidosrestaurant.model.Tables;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TableRepository extends JpaRepository<Tables, Long> {
    boolean existsByNumber(int number);

    Optional<Tables> findByNumber(int number);

}
