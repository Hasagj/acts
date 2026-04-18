package com.hasagj.acts.controller;

import com.hasagj.acts.model.Contractors;
import com.hasagj.acts.service.ContractorsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contractors")
@RequiredArgsConstructor
public class ContractorsController {

    private final ContractorsService contractorsService;

    @GetMapping
    public ResponseEntity<List<Contractors>> findAll() {
        return ResponseEntity.ok(contractorsService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contractors> findById(@PathVariable String id) {
        return ResponseEntity.ok(contractorsService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Contractors> save(@RequestBody Contractors contractors) {
        return ResponseEntity.ok(contractorsService.save(contractors));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contractors> update(@PathVariable String id, @RequestBody Contractors contractors) {
        return ResponseEntity.ok(contractorsService.update(id, contractors));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        contractorsService.delete(id);
        return ResponseEntity.noContent().build();
    }
}