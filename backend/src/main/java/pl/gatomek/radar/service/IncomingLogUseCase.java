package pl.gatomek.radar.service;

import pl.gatomek.radar.dto.AircraftNotification;

import java.time.Instant;

public interface IncomingLogUseCase {
    void processNotification(AircraftNotification aircraftNotification, Instant beginTimestamp);
}
