package marta.weiner.app.flightfinder.example.init.service;

import lombok.RequiredArgsConstructor;
import marta.weiner.app.flightfinder.example.init.entity.AirportEntity;
import marta.weiner.app.flightfinder.example.init.mapper.CSVMapper;
import marta.weiner.app.flightfinder.example.init.repository.AirportRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import javax.validation.Constraint;
import javax.validation.Payload;

import javax.persistence.Id;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor

public class AirportService {
    private final AirportRepository repository;
    private final CSVMapper csvMapper;


    public AirportEntity save(AirportEntity entity) throws Exception {
        validateShortname(entity);
        validateName(entity);
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

    public void saveFromCsv(MultipartFile file) throws Exception {
            List<AirportEntity> data = csvMapper.csvToEntities(file.getInputStream());
        for (AirportEntity airport : data) {
            save(airport);
        }
    }

    public void deleteAll(){
        repository.deleteAll();
    }


    private void validateShortname(AirportEntity entity) throws Exception {
        if (entity.getShortname().length() != 3){
            throw new Exception("Shortname must be 3 letters");
        }
        if (!entity.getShortname().chars().allMatch(Character::isLetter)){
            throw new Exception("Shortname must be only letters");
        }
        if (repository.findByShortname(entity.getShortname())!=null){
            throw new Exception("Shortname must be unique");
        }
    }

    private void validateName(AirportEntity entity) throws Exception{
        if (entity.getName().length() < 3){
            throw new Exception("Name cannot be shorter than 3 letters");
        }
        if(!entity.getName().chars().allMatch((Character::isLetter))){
            throw new Exception("Name must be only letters");
        }
        if (repository.findByName(entity.getName())!=null){
            throw new Exception("Name must be unique");
        }
    }
}
