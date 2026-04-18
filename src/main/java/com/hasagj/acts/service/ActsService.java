package com.hasagj.acts.service;

import com.hasagj.acts.model.Acts;
import com.hasagj.acts.model.ActItems;
import com.hasagj.acts.repository.ActsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ActsService {

    private final ActsRepository actRepository;

    public List<Acts> findAll() {
        log.info("Получение всех актов");
        return actRepository.findAll();
    }

    public Acts findById(String id) {
        log.info("Получение акта по id: {}", id);
        return actRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Акт не найден: " + id));
    }

    public Acts save(Acts act) {
        log.info("Сохранение акта: {}", act.getNumber());
        calculateTotals(act);
        return actRepository.save(act);
    }

    public Acts update(String id, Acts act) {
        log.info("Обновление акта: {}", id);
        Acts existing = findById(id);
        existing.setNumber(act.getNumber());
        existing.setDate(act.getDate());
        existing.setContractorId(act.getContractorId());
        existing.setContractorName(act.getContractorName());
        existing.setClientId(act.getClientId());
        existing.setClientName(act.getClientName());
        existing.setItems(act.getItems());
        calculateTotals(existing);
        return actRepository.save(existing);
    }

    public void delete(String id) {
        log.info("Удаление акта: {}", id);
        actRepository.deleteById(id);
    }

    private void calculateTotals(Acts act) {
        if (act.getItems() == null) return;

        for (ActItems item : act.getItems()) {
            if (item.getQuantity() != null && item.getPrice() != null) {
                item.setTotal(item.getQuantity() * item.getPrice());
            }
        }

        double grandTotal = act.getItems().stream()
                .mapToDouble(item -> item.getTotal() != null ? item.getTotal() : 0)
                .sum();

        act.setGrandTotal(grandTotal);
    }
}