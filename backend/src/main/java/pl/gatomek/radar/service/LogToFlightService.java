package pl.gatomek.radar.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.gatomek.radar.repository.AircraftLogRepository;

@RequiredArgsConstructor
@Service
class LogToFlightService implements LogToFlightUseCase {

    private final AircraftLogRepository aircraftLogRepository;

    @Override
    public void match(Long logId) {
    }
}
