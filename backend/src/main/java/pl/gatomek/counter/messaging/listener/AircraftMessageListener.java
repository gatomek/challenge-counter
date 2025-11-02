package pl.gatomek.counter.messaging.listener;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import pl.gatomek.counter.messaging.dto.AircraftLogMessage;
import pl.gatomek.counter.messaging.mapper.AircraftLogMapper;
import pl.gatomek.counter.repository.AircraftLogEntity;
import pl.gatomek.counter.repository.AircraftLogRepository;

@RequiredArgsConstructor
@Component
public class AircraftMessageListener {

    private final AircraftLogRepository aircraftLogRepository;

    @Async
    @EventListener
    public void onApplicationEvent(AircraftLogMessage event) {
        AircraftLogEntity entity = AircraftLogMapper.toEntity(event.getAircraftLog());
        entity.setTimestamp(event.getTimeStamp());
        aircraftLogRepository.save(entity);
    }
}
