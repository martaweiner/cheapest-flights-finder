package marta.weiner.app.flightfinder.example.init.service;

import lombok.RequiredArgsConstructor;
import marta.weiner.app.flightfinder.example.init.entity.AirportEntity;
import marta.weiner.app.flightfinder.example.init.mapper.CSVMapper;
import marta.weiner.app.flightfinder.example.init.repository.AirportRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Id;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor

public class AirportService {
    private final AirportRepository repository;
    private final CSVMapper csvMapper;

    public AirportEntity save(AirportEntity entity) {
        return repository.save(entity);
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

    public void saveFromCsv(MultipartFile file) throws IOException {
            List<AirportEntity> data = csvMapper.csvToEntities(file.getInputStream());
            repository.saveAll(data);
    }
}
