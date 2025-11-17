package pl.gatomek.radar.messaging.dto;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;
import pl.gatomek.radar.dto.AircraftLog;

@Getter
public class AircraftLogMessage extends ApplicationEvent {
    private final AircraftLog aircraftLog;

    private AircraftLogMessage(Object source, AircraftLog aircraftLog) {
        super(source);

        this.aircraftLog = aircraftLog;
    }

    public static AircraftLogMessage of(Object source, AircraftLog aircraftLog) {
        return new AircraftLogMessage(source, aircraftLog);
    }
}
