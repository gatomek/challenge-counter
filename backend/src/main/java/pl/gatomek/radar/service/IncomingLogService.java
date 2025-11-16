package pl.gatomek.radar.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import pl.gatomek.radar.dto.AircraftNotification;
import pl.gatomek.radar.messaging.dto.AircraftLogMessage;

import java.time.Duration;
import java.time.Instant;

@Slf4j
@RequiredArgsConstructor
@Service
class IncomingLogService implements IncomingLogUseCase {

    private static final String NO_ERROR = "No error";

    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void processNotification(AircraftNotification aircraftNotification, Instant beginTimestamp) {
        if (!NO_ERROR.equals(aircraftNotification.getStatus())) {
            return;
        }

        Instant apiTimestamp = Instant.ofEpochMilli(aircraftNotification.getTimestamp());
        Duration duration = Duration.between(apiTimestamp, beginTimestamp);

        log.info("{} | {} | {}ms | n:{}", beginTimestamp, apiTimestamp, duration.toMillis(), aircraftNotification.getTotal());

        aircraftNotification.getAircraftLogs().forEach(ac ->
                applicationEventPublisher.publishEvent(AircraftLogMessage.of(this, ac.withTimestamp(apiTimestamp)))
        );
    }
}

