package com.github.guiziin227.cozidosrestaurant.service;

import com.github.guiziin227.cozidosrestaurant.exceptions.UserExistsException;
import com.github.guiziin227.cozidosrestaurant.model.Tables;
import com.github.guiziin227.cozidosrestaurant.repository.TableRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TableService {

    Logger logger = LoggerFactory.getLogger(TableService.class);

    @Autowired
    private TableRepository tableRepository;

    @Transactional
    public Tables create(Tables table) {
        if (tableRepository.existsByNumber(table.getNumber())) {
            logger.warn("Table with ID {} already exists!", table.getId());
            throw new UserExistsException("Table with ID " + table.getId() + " already exists.");
        }
        logger.info("Creating table with ID {}", table.getId());
        return tableRepository.save(table);
    }



    @Transactional(readOnly = true)
    public Tables findById(Long id) {
        logger.info("Finding table with ID {}", id);
        return tableRepository.findById(id)
                .orElseThrow(() -> new UserExistsException("Table with ID " + id + " not found."));
    }

    @Transactional(readOnly = true)
    public Tables findByNumber(Integer number) {
        logger.info("Finding table with number {}", number);
        return tableRepository.findByNumber(number)
                .orElseThrow(() -> new UserExistsException("Table with ID " + number + " not found."));
    }

    @Transactional(readOnly = true)
    public List<Tables> findAll() {
        logger.info("Retrieving all tables");
        return tableRepository.findAll();
    }

}
