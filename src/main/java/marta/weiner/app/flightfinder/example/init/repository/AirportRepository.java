package marta.weiner.app.flightfinder.example.init.repository;

import marta.weiner.app.flightfinder.example.init.entity.AirportEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirportRepository {
    void save(AirportEntity entity);

    List<AirportEntity> findAll();

    void deleteByName(String name);
}
