package pl.gatomek.counter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AircraftLogRepository extends JpaRepository<AircraftLogEntity, Long> {
    @Override
    AircraftLogEntity save(AircraftLogEntity aircraftLogEntity);
}
