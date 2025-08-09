package com.github.guiziin227.cozidosrestaurant.service;

import com.github.guiziin227.cozidosrestaurant.exceptions.UserExistsException;
import com.github.guiziin227.cozidosrestaurant.exceptions.UserNotFoundException;
import com.github.guiziin227.cozidosrestaurant.model.Waiter;
import com.github.guiziin227.cozidosrestaurant.repository.WaiterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WaiterService {

    Logger logger = LoggerFactory.getLogger(WaiterService.class);

    @Autowired
    private WaiterRepository waiterRepository;

    @Transactional
    public Waiter create(Waiter waiter) {
        if (waiterRepository.existsByAccessCode(waiter.getAccessCode()) ) {
            logger.warn("Cpf already exists!");
            throw new UserExistsException("Waiter with AccessCode " + waiter.getAccessCode() + " already exists.");
        }

        logger.info("Create waiter with AccessCode {}", waiter.getAccessCode());
        return waiterRepository.save(waiter);
    }


    @Transactional(readOnly = true)
    public Waiter findByAccessCode(String accessCode) {
        logger.info("Waiter with AccessCode {} found", accessCode);
        return waiterRepository.findByAccessCode(accessCode).orElseThrow(() -> new UserNotFoundException("Waiter with AccessCode " + accessCode + " not found."));
    }

    @Transactional(readOnly = true)
    public List<Waiter> findAll() {
        logger.info("Retrieving all waiters");
        return waiterRepository.findAll();
    }

}
