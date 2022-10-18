package marta.weiner.app.flightfinder.example.init.repository;

import marta.weiner.app.flightfinder.example.init.entity.AirportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AirportRepository extends JpaRepository<AirportEntity, Long> {
    void deleteById(Long id);
}
