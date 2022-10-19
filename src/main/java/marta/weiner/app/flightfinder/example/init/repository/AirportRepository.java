package marta.weiner.app.flightfinder.example.init.repository;

import marta.weiner.app.flightfinder.example.init.entity.AirportEntity;
import marta.weiner.app.flightfinder.example.init.service.AirportService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AirportRepository extends JpaRepository<AirportEntity, Long> {

    void deleteById(Long id);
}
