package pl.gatomek.radar.messaging.listener;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import pl.gatomek.radar.messaging.dto.LogToFlightMessage;
import pl.gatomek.radar.service.LogToFlightUseCase;

@RequiredArgsConstructor
@Component
public class LogToFlightMessageListener {
    private final LogToFlightUseCase logToFlightService;

    @Async
    @EventListener
    public void onApplicationEvent(LogToFlightMessage message) {
        logToFlightService.match( message.getLogId());
    }
}
