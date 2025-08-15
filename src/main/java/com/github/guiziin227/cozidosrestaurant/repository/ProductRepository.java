package com.github.guiziin227.cozidosrestaurant.repository;

import com.github.guiziin227.cozidosrestaurant.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    boolean existsByName(String name);

    Optional<Product> findByName(String name);
}