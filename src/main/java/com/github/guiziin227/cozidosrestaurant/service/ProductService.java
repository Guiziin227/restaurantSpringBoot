package com.github.guiziin227.cozidosrestaurant.service;

import com.github.guiziin227.cozidosrestaurant.exceptions.UserExistsException;
import com.github.guiziin227.cozidosrestaurant.exceptions.UserNotFoundException;
import com.github.guiziin227.cozidosrestaurant.model.Product;
import com.github.guiziin227.cozidosrestaurant.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    Logger logger = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private ProductRepository productRepository;


    @Transactional
    public Product create(Product product) {
        if (productRepository.existsByName(product.getName())) {
            throw new UserExistsException("Product with NAME " + product.getName() + " already exists.");
        }

        logger.info("Creating product: {}", product.getName());
        return productRepository.save(product);
    }

    @Transactional(readOnly = true)
    public Product findByName(String name) {
        logger.info("Finding product: {}", name);
        return productRepository.findByName(name)
                .orElseThrow(() -> new UserNotFoundException("Product with NAME " + name + " not found."));
    }

    @Transactional(readOnly = true)
    public Product findById(Long id) {
        logger.info("Finding product: {}", id);
        return productRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Product with ID " + id + " not found."));
    }

    @Transactional(readOnly = true)
    public List<Product> findAll() {
        logger.info("Finding all products");
        return productRepository.findAll();
    }

    @Transactional
    public Product update(Long id, Product product) {
        Product existing = productRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Product with ID " + id + " not found."));

        existing.setName(product.getName());
        existing.setDescription(product.getDescription());
        existing.setPrice(product.getPrice());
        existing.setPrepared(product.getPrepared());

        logger.info("Updating product: {}", id);
        return productRepository.save(existing);
    }

}