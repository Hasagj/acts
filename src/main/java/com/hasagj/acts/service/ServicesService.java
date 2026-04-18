package com.hasagj.acts.service;

import com.hasagj.acts.model.Services;
import com.hasagj.acts.repository.ServicesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ServicesService {

    private final ServicesRepository servicesRepository;

    public List<Services> findAll() {
        log.info("Получение всех видов услуг");
        return servicesRepository.findAll();
    }

    public Services findById(String id) {
        log.info("Получение вида услуги измерения по id: {}", id);
        return servicesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Вид услуги не найден: " + id));
    }

    public Services save(Services services) {
        log.info("Сохранение вида услуги: {}", services.getName());
        return servicesRepository.save(services);
    }

    public Services update(String id, Services services) {
        log.info("Обновление вида услуги: {}", id);
        Services existing = findById(id);
        existing.setName(services.getName());
        existing.setPrice(services.getPrice());
        existing.setUnitId(services.getUnitId());
        existing.setUnitShortName(services.getUnitShortName());
        return servicesRepository.save(existing);
    }

    public void delete(String id) {
        log.info("Удаление вида услуги: {}", id);
        servicesRepository.deleteById(id);
    }
}