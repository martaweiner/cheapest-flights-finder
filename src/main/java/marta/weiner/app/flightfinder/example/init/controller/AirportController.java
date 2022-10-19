package marta.weiner.app.flightfinder.example.init.controller;

import lombok.RequiredArgsConstructor;
import marta.weiner.app.flightfinder.example.init.controller.dto.AirportDto;
import marta.weiner.app.flightfinder.example.init.entity.AirportEntity;
import marta.weiner.app.flightfinder.example.init.mapper.AirportMapper;
import marta.weiner.app.flightfinder.example.init.repository.AirportRepository;
import marta.weiner.app.flightfinder.example.init.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/{airport}", method = RequestMethod.GET)
public class AirportController {
    private final AirportMapper mapper;
    private final AirportService service;

    @PostMapping
    public void add(@RequestBody AirportDto dto) {
        service.save(mapper.map(dto));
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/{id}")
    public AirportEntity getById(@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping("/")
    public List<AirportEntity> getAll() {
        return service.getAll();
    }


}
