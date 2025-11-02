package pl.gatomek.counter.messaging.dto;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import pl.gatomek.counter.dto.AircraftLog;

import java.time.Instant;

@Getter
public class AircraftLogMessage extends ApplicationEvent {
    private final AircraftLog aircraftLog;
    private final Instant timeStamp;

    private AircraftLogMessage(Object source, AircraftLog aircraftLog, Instant timeStamp) {
        super(source);

        this.aircraftLog = aircraftLog;
        this.timeStamp = timeStamp;
    }

    public static AircraftLogMessage of(Object source, AircraftLog aircraftLog, Instant timeStamp) {
        return new AircraftLogMessage(source, aircraftLog, timeStamp);
    }
}
