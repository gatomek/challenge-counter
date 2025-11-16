package pl.gatomek.radar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.gatomek.radar.repository.entity.AircraftLogEntity;

@Repository
public interface AircraftLogRepository extends JpaRepository<AircraftLogEntity, Long> {
}
