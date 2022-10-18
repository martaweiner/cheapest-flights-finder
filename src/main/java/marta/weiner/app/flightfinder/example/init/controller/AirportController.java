package marta.weiner.app.flightfinder.example.init.controller;

import lombok.RequiredArgsConstructor;
import marta.weiner.app.flightfinder.example.init.entity.AirportEntity;
import marta.weiner.app.flightfinder.example.init.service.AirportService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor

public class AirportController {
    private final AirportService service;

    @PostMapping
    public void add(@RequestBody AirportEntity entity) {
        service.save(entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping
    public List<AirportEntity> getAll() {
        return service.getAll();
    }

}
