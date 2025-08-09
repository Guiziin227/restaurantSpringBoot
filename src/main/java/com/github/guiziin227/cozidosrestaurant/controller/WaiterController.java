package com.github.guiziin227.cozidosrestaurant.controller;

import com.github.guiziin227.cozidosrestaurant.dto.request.WaiterRequestDTO;
import com.github.guiziin227.cozidosrestaurant.dto.response.WaiterResponseDTO;
import com.github.guiziin227.cozidosrestaurant.mapper.WaiterMapper;
import com.github.guiziin227.cozidosrestaurant.model.Waiter;
import com.github.guiziin227.cozidosrestaurant.service.WaiterService;
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
@RequestMapping("/api/waiters")
public class WaiterController {

    @Autowired
    private WaiterService waiterService;

    @Autowired
    private WaiterMapper mapper;

    @PostMapping
    public ResponseEntity<WaiterResponseDTO> createWaiter(@RequestBody WaiterRequestDTO requestDTO) {
        Waiter waiter = mapper.toEntity(requestDTO);
        Waiter savedWaiter = waiterService.create(waiter);
        return ResponseEntity.ok(mapper.toResponseDTO(savedWaiter));
    }


    @GetMapping("/{accessCode}")
    public ResponseEntity<WaiterResponseDTO> getWaiterByAccessCode(@PathVariable String accessCode) {
        Waiter waiter = waiterService.findByAccessCode(accessCode);
        if (waiter == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(mapper.toResponseDTO(waiter));
    }

    @GetMapping
    public ResponseEntity<List<WaiterResponseDTO>> getWaiters() {
        List<Waiter> waiters = waiterService.findAll();
        List<WaiterResponseDTO> responseDTOs = mapper.toResponseDTOList(waiters);
        return ResponseEntity.ok(responseDTOs);
    }
}
