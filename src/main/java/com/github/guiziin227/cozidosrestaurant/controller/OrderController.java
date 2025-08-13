package com.github.guiziin227.cozidosrestaurant.controller;

import com.github.guiziin227.cozidosrestaurant.dto.request.OrderRequestDTO;
import com.github.guiziin227.cozidosrestaurant.dto.response.OrderResponseDTO;
import com.github.guiziin227.cozidosrestaurant.mapper.OrderMapper;
import com.github.guiziin227.cozidosrestaurant.model.Order;
import com.github.guiziin227.cozidosrestaurant.service.OrderService;
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
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderMapper orderMapper;

    @PostMapping
    public ResponseEntity<OrderResponseDTO> createOrder(@RequestBody OrderRequestDTO orderRequestDTO) {
        Order orderEntity = orderMapper.toEntity(orderRequestDTO);
        Order savedOrder = orderService.create(orderEntity);
        return ResponseEntity.ok(orderMapper.toResponseDTO(savedOrder));
    }

    @GetMapping
    public ResponseEntity<List<OrderResponseDTO>> getAllOrders() {
        List<Order> orders = orderService.findAll();
        List<OrderResponseDTO> responseDTOs = orderMapper.toResponseDTOList(orders);
        return ResponseEntity.ok(responseDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponseDTO> getOrderById(@PathVariable Long id) {
        Order order = orderService.findById(id);
        if (order == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(orderMapper.toResponseDTO(order));
    }

    @GetMapping("/table/{tableId}")
    public ResponseEntity<OrderResponseDTO> getOrdersByTableId(@PathVariable Long tableId) {
        Order order = orderService.findByTableId(tableId);
        if (order == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(orderMapper.toResponseDTO(order));
    }

}
