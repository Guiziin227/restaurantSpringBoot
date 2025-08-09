package com.github.guiziin227.cozidosrestaurant.service;

import com.github.guiziin227.cozidosrestaurant.exceptions.UserExistsException;
import com.github.guiziin227.cozidosrestaurant.model.Tables;
import com.github.guiziin227.cozidosrestaurant.repository.TableRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableService {

    Logger logger = LoggerFactory.getLogger(TableService.class);

    @Autowired
    private TableRepository tableRepository;

    public Tables create(Tables table) {
        if (tableRepository.existsByNumber(table.getNumber())) {
            logger.warn("Table with ID {} already exists!", table.getId());
            throw new UserExistsException("Table with ID " + table.getId() + " already exists.");
        }
        logger.info("Creating table with ID {}", table.getId());
        return tableRepository.save(table);
    }

    public Tables findByNumber(Integer number) {
        logger.info("Finding table with number {}", number);
        return tableRepository.findByNumber(number)
                .orElseThrow(() -> new UserExistsException("Table with ID " + number + " not found."));
    }

    public List<Tables> findAll() {
        logger.info("Retrieving all tables");
        return tableRepository.findAll();
    }

}
