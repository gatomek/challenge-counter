package pl.gatomek.radar.messaging.listener;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import pl.gatomek.radar.messaging.dto.AircraftLogMessage;
import pl.gatomek.radar.service.SavingLogUseCase;

@RequiredArgsConstructor
@Component
public class AircraftMessageListener {

    private final SavingLogUseCase savingLogService;

    @Async
    @EventListener
    public void onApplicationEvent(AircraftLogMessage event) {
        savingLogService.save( event.getAircraftLog());
    }
}
