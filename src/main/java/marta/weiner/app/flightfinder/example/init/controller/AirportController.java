package marta.weiner.app.flightfinder.example.init.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.RequestDataValueProcessor;

import java.nio.file.Path;

@RestController

public class AirportController {
    @PutMapping ("/{name}")
    public <RequestData> String hello (@PathVariable String name, @RequestBody RequestData data){
        return "HEJ";
    }
}
