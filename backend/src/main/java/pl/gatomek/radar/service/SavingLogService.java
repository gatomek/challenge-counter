package pl.gatomek.radar.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import pl.gatomek.radar.dto.AircraftLog;
import pl.gatomek.radar.messaging.dto.LogToFlightMessage;
import pl.gatomek.radar.messaging.mapper.AircraftLogMapper;
import pl.gatomek.radar.repository.AircraftLogRepository;
import pl.gatomek.radar.repository.entity.AircraftLogEntity;

@RequiredArgsConstructor
@Service
class SavingLogService implements SavingLogUseCase {

    private final AircraftLogRepository aircraftLogRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void save(AircraftLog log) {
        AircraftLogEntity entity = aircraftLogRepository.save(AircraftLogMapper.toEntity(log));

        applicationEventPublisher.publishEvent(LogToFlightMessage.of(entity.getId()));
    }
}
