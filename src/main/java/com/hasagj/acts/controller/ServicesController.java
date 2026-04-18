package com.hasagj.acts.controller;

import com.hasagj.acts.model.Services;
import com.hasagj.acts.service.ServicesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
@RequiredArgsConstructor
public class ServicesController {

    private final ServicesService servicesService;

    @GetMapping
    public ResponseEntity<List<Services>> findAll() {
        return ResponseEntity.ok(servicesService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Services> findById(@PathVariable String id) {
        return ResponseEntity.ok(servicesService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Services> save(@RequestBody Services services) {
        return ResponseEntity.ok(servicesService.save(services));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Services> update(@PathVariable String id, @RequestBody Services services) {
        return ResponseEntity.ok(servicesService.update(id, services));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        servicesService.delete(id);
        return ResponseEntity.noContent().build();
    }
}