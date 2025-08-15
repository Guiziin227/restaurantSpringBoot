package com.github.guiziin227.cozidosrestaurant.controller;

import com.github.guiziin227.cozidosrestaurant.dto.request.ProductRequestDTO;
import com.github.guiziin227.cozidosrestaurant.dto.response.ProductResponseDTO;
import com.github.guiziin227.cozidosrestaurant.mapper.ProductMapper;
import com.github.guiziin227.cozidosrestaurant.model.Product;
import com.github.guiziin227.cozidosrestaurant.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductMapper productMapper;

    @PostMapping
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductRequestDTO productRequestDTO) {
        var product = productMapper.toEntity(productRequestDTO);
        var createdProduct = productService.create(product);
        return ResponseEntity.ok(productMapper.toResponseDTO(createdProduct));
    }

    @GetMapping("/{name}")
    public ResponseEntity<ProductResponseDTO> getProductByName(@PathVariable String name) {
        var product = productService.findByName(name);
        return ResponseEntity.ok(productMapper.toResponseDTO(product));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable Long id) {
        var product = productService.findById(id);
        return ResponseEntity.ok(productMapper.toResponseDTO(product));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts() {
        List<Product> products = productService.findAll();
        return ResponseEntity.ok(productMapper.toResponseDTOList(products));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> updateProduct(@PathVariable Long id, @RequestBody ProductRequestDTO productRequestDTO) {
        var product = productMapper.toEntity(productRequestDTO);
        var updatedProduct = productService.update(id, product);
        return ResponseEntity.ok(productMapper.toResponseDTO(updatedProduct));
    }
}