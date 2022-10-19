package marta.weiner.app.flightfinder.example.init.service;

import lombok.RequiredArgsConstructor;
import marta.weiner.app.flightfinder.example.init.entity.AirportEntity;
import marta.weiner.app.flightfinder.example.init.repository.AirportRepository;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.List;

@Service
@RequiredArgsConstructor

public class AirportService {
    private final AirportRepository repository;

    public void save(AirportEntity entity) {
        repository.save(entity);
    }

    public List<AirportEntity> getAll() {
        return repository.findAll();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public AirportEntity findById(Long id){
        return repository.findById(id).orElse(null);
    }
}
