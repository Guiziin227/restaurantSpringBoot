package com.github.guiziin227.cozidosrestaurant.repository;

import com.github.guiziin227.cozidosrestaurant.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByTableId(Long orderId);
}
