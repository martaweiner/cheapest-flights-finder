package marta.weiner.app.flightfinder.example.init.mapper;

import marta.weiner.app.flightfinder.example.init.controller.dto.AirportDto;
import marta.weiner.app.flightfinder.example.init.entity.AirportEntity;
import org.springframework.stereotype.Component;

@Component
public class AirportMapper {

    public AirportEntity map(AirportDto dto){
        AirportEntity entity = new AirportEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setShortname(dto.getShortname());
        return entity;
    }

    public AirportDto map(AirportEntity entity){
        AirportDto dto = new AirportDto();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setShortname(entity.getShortname());
        return dto;
    }
}
