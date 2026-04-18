package com.hasagj.acts.controller;

import com.hasagj.acts.model.Units;
import com.hasagj.acts.service.UnitsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/units")
@RequiredArgsConstructor
public class UnitsController {

    private final UnitsService unitsService;

    @GetMapping
    public ResponseEntity<List<Units>> findAll() {
        return ResponseEntity.ok(unitsService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Units> findById(@PathVariable String id) {
        return ResponseEntity.ok(unitsService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Units> save(@RequestBody Units units) {
        return ResponseEntity.ok(unitsService.save(units));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Units> update(@PathVariable String id, @RequestBody Units units) {
        return ResponseEntity.ok(unitsService.update(id, units));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        unitsService.delete(id);
        return ResponseEntity.noContent().build();
    }
}