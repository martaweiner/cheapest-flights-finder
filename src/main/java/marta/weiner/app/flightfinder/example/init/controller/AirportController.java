package marta.weiner.app.flightfinder.example.init.controller;

import lombok.RequiredArgsConstructor;
import marta.weiner.app.flightfinder.example.init.entity.AirportEntity;
import marta.weiner.app.flightfinder.example.init.repository.AirportRepository;
import marta.weiner.app.flightfinder.example.init.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@RestController
@RequiredArgsConstructor

public class AirportController {
    @Autowired
    private final AirportService service;

    @PostMapping
    public String add(@RequestBody AirportEntity entity) {
        service.save(entity);
        return "Saved.. ";
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @Id
    @GetMapping("/")
    public AirportEntity getById(@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping("/result")
    public List<AirportEntity> getAll() {
        return service.getAll();
    }


}
