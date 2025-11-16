package pl.gatomek.radar.messaging.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class LogToFlightMessage {
    private Long logId;

    public static LogToFlightMessage of(Long logId) {
        return new LogToFlightMessage(logId);
    }
}
