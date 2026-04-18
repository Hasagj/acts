package com.hasagj.acts.service;

import com.hasagj.acts.model.Units;
import com.hasagj.acts.repository.UnitsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UnitsService {

    private final UnitsRepository unitsRepository;

    public List<Units> findAll() {
        log.info("Получение всех единиц измерения");
        return unitsRepository.findAll();
    }

    public Units findById(String id) {
        log.info("Получение единицы измерения по id: {}", id);
        return unitsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Единица измерения не найдена: " + id));
    }

    public Units save(Units units) {
        log.info("Сохранение единицы измерения: {}", units.getShortName());
        return unitsRepository.save(units);
    }

    public Units update(String id, Units units) {
        log.info("Обновление единицы измерения: {}", id);
        Units existing = findById(id);
        existing.setShortName(units.getShortName());
        existing.setFullName(units.getFullName());
        return unitsRepository.save(existing);
    }

    public void delete(String id) {
        log.info("Удаление единицы измерения: {}", id);
        unitsRepository.deleteById(id);
    }
}