package com.hasagj.acts.service;

import com.hasagj.acts.model.Contractors;
import com.hasagj.acts.repository.ContractorsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ContractorsService {

    private final ContractorsRepository contractorsRepository;

    public List<Contractors> findAll() {
        log.info("Получение всех контрагентов");
        return contractorsRepository.findAll();
    }

    public Contractors findById(String id) {
        log.info("Получение контрагента по id: {}", id);
        return contractorsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Контрагент не найден: " + id));
    }

    public Contractors save(Contractors contractors) {
        log.info("Сохранение контрагента: {}", contractors.getName());
        return contractorsRepository.save(contractors);
    }

    public Contractors update(String id, Contractors contractors) {
        log.info("Обновление контрагента: {}", id);
        Contractors existing = findById(id);
        existing.setName(contractors.getName());
        existing.setInn(contractors.getInn());
        existing.setAddress(contractors.getAddress());
        existing.setBank(contractors.getBank());
        existing.setAccount(contractors.getAccount());
        return contractorsRepository.save(existing);
    }

    public void delete(String id) {
        log.info("Удаление контрагента: {}", id);
        contractorsRepository.deleteById(id);
    }
}