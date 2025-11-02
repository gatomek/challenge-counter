package pl.gatomek.counter.task;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import pl.gatomek.counter.config.AdsbConfig;
import pl.gatomek.counter.dto.AircraftNotification;
import pl.gatomek.counter.service.IAircraftLogService;

import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@Component
public class QueryTask {
    private final IAircraftLogService aircraftService;
    private final RestClient restClient = RestClient.create();
    private final AdsbConfig adsbConfig;

    @Scheduled(fixedDelay = 1, timeUnit = TimeUnit.MINUTES)
    public void run() {
        AircraftNotification aircraftNotification = restClient.get()
                .uri(adsbConfig.getApi())
                .retrieve()
                .body(AircraftNotification.class);

        aircraftService.processNotification(aircraftNotification);
    }
}
