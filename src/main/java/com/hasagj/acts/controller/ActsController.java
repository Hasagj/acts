package com.hasagj.acts.controller;

import com.hasagj.acts.model.Acts;
import com.hasagj.acts.service.ActsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/acts")
@RequiredArgsConstructor
public class ActsController {

    private final ActsService actService;

    @GetMapping
    public ResponseEntity<List<Acts>> findAll() {
        return ResponseEntity.ok(actService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Acts> findById(@PathVariable String id) {
        return ResponseEntity.ok(actService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Acts> save(@RequestBody Acts act) {
        return ResponseEntity.ok(actService.save(act));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Acts> update(@PathVariable String id, @RequestBody Acts act) {
        return ResponseEntity.ok(actService.update(id, act));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        actService.delete(id);
        return ResponseEntity.noContent().build();
    }
}