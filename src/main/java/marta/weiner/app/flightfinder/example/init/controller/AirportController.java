package marta.weiner.app.flightfinder.example.init.controller;

import lombok.RequiredArgsConstructor;
import marta.weiner.app.flightfinder.example.init.controller.dto.AirportDto;
import marta.weiner.app.flightfinder.example.init.entity.AirportEntity;
import marta.weiner.app.flightfinder.example.init.mapper.AirportMapper;
import marta.weiner.app.flightfinder.example.init.service.AirportService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController(value = "/")
@RequiredArgsConstructor
@RequestMapping(value = "/{airport}", method = RequestMethod.GET)
public class AirportController {
    private final AirportMapper mapper;
    private final AirportService service;

    @PostMapping
    public AirportEntity add(@RequestBody AirportDto dto) {
        return service.save(mapper.map(dto));

    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/{id}")
    public AirportDto getById(@PathVariable Long id){
        return mapper.map(service.findById(id));
    }

    @GetMapping("/")
    public List<AirportDto> getAll() {
        //List<AirportEntity> data = service.getAll();
        //stream
        return service.getAll().stream().map(mapper::map).collect(Collectors.toList());
    }


}
