package com.github.guiziin227.cozidosrestaurant.service;

import com.github.guiziin227.cozidosrestaurant.model.Order;
import com.github.guiziin227.cozidosrestaurant.model.Tables;
import com.github.guiziin227.cozidosrestaurant.model.Waiter;
import com.github.guiziin227.cozidosrestaurant.model.enums.StatusOrder;
import com.github.guiziin227.cozidosrestaurant.model.enums.StatusTable;
import com.github.guiziin227.cozidosrestaurant.repository.OrderRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService {

    Logger logger = org.slf4j.LoggerFactory.getLogger(OrderService.class);

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private TableService tableService;

    @Autowired
    private WaiterService waiterService;


    @Transactional
    public Order create(Order order) {

        Waiter waiter = waiterService.findById(order.getWaiter().getId());
        Tables table = tableService.findById(order.getTable().getId());

        if (table.getStatus() != StatusTable.AVAILABLE) {
            logger.warn("Table {} is already occupied", table.getNumber());
            throw new IllegalStateException("Table " + table.getNumber() + " is already occupied.");
        }

        if (waiter == null) {
            logger.warn("Waiter with ID {} not found", order.getWaiter().getId());
            throw new IllegalStateException("Waiter with ID " + order.getWaiter().getId() + " not found.");
        }

        if (order.getStatus() == null) {
            order.setStatus(StatusOrder.IN_PROGRESS);
        }

        order.setWaiter(waiter);
        order.setTable(table);

        logger.info("Order created: {}", order);
        return orderRepository.save(order);
    }

    @Transactional(readOnly = true)
    public Order findById(Long id) {
        logger.info("Finding order with ID {}", id);
        return orderRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Order with ID " + id + " not found."));
    }

    @Transactional(readOnly = true)
    public Order findByTableId(Long tableId) {
        logger.info("Finding order for table with ID {}", tableId);
        return orderRepository.findByTableId(tableId)
                .orElseThrow(() -> new IllegalStateException("No order found for table with ID " + tableId));
    }

    @Transactional(readOnly = true)
    public List<Order> findAll(){
        logger.info("Retrieving all orders");
        return orderRepository.findAll();
    }

}
