package pl.gatomek.counter.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import pl.gatomek.counter.dto.AircraftNotification;
import pl.gatomek.counter.messaging.dto.AircraftLogMessage;

import java.time.Instant;

@RequiredArgsConstructor
@Service
class AircraftLogService implements IAircraftLogService {

    private static final String NO_ERROR = "No error";

    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void processNotification(AircraftNotification aircraftNotification) {
        if (!NO_ERROR.equals(aircraftNotification.getStatus())) {
            return;
        }

        Instant timestamp = Instant.ofEpochMilli(aircraftNotification.getTimestamp());
        System.out.println(timestamp + ": " + aircraftNotification.getTotal());

        aircraftNotification.getAircraftLogs().forEach(ac ->
                applicationEventPublisher.publishEvent(AircraftLogMessage.of(this, ac, timestamp))
        );
    }
}
