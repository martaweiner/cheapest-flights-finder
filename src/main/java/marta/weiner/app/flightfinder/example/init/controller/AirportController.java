package marta.weiner.app.flightfinder.example.init.controller;

import lombok.RequiredArgsConstructor;
import marta.weiner.app.flightfinder.example.init.controller.dto.AirportDto;
import marta.weiner.app.flightfinder.example.init.entity.AirportEntity;
import marta.weiner.app.flightfinder.example.init.mapper.AirportMapper;
import marta.weiner.app.flightfinder.example.init.service.AirportService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@RestController(value = "/")
@RequiredArgsConstructor
@RequestMapping(value = "/{airport}", method = RequestMethod.GET)
public class AirportController {
    private final AirportMapper mapper;
    private final AirportService service;

    @PostMapping
    public AirportEntity add(@RequestBody AirportDto dto) throws Exception {
        return service.save(mapper.map(dto));
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAll() {
        service.deleteAll();
    }

    @GetMapping("/{id}")
    public AirportDto getById(@PathVariable Long id) {
        return mapper.map(service.findById(id));
    }

    @GetMapping("/")
    public List<AirportDto> getAll() {
        return service.getAll().stream().map(mapper::map).collect(Collectors.toList());
    }

    @PostMapping("/upload")
    public void uploadFile(@RequestParam("file") MultipartFile file) throws Exception {
        service.saveFromCsv(file);
    }
}

