package pl.gatomek.radar.task;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import pl.gatomek.radar.config.AdsbConfig;
import pl.gatomek.radar.dto.AircraftNotification;
import pl.gatomek.radar.service.IncomingLogUseCase;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.atomic.AtomicBoolean;

@Slf4j
@RequiredArgsConstructor
@Component
public class AdsbApiQueryTask {
    private final IncomingLogUseCase aircraftService;
    private final AdsbConfig adsbConfig;
    private final RestClient restClient;
    private final AtomicBoolean active = new AtomicBoolean(Boolean.FALSE);

    @Scheduled(cron = "0 * * * * *")
    public void run() {

        if (active.get()) {
            log.info("Overlapping Query Task");
            return;
        }

        try {
            active.set(Boolean.TRUE);
            Instant beginTimestamp = Instant.now().truncatedTo(ChronoUnit.MILLIS);
            AircraftNotification aircraftNotification = restClient
                    .get()
                    .uri(adsbConfig.getApi())
                    .retrieve()
                    .body(AircraftNotification.class);

            Instant endTimestamp = Instant.now().truncatedTo(ChronoUnit.MILLIS);
            log.info("API Query duration: {}ms", Duration.between(beginTimestamp, endTimestamp).toMillis());

            aircraftService.processNotification(aircraftNotification, beginTimestamp);
        } catch (Exception ex) {
            log.error("ADSB REST API Query failed", ex);
        } finally {
            active.set(Boolean.FALSE);
        }
    }
}
