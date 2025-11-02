package pl.gatomek.counter.service;

import pl.gatomek.counter.dto.AircraftNotification;

public interface IAircraftLogService {
    void processNotification(AircraftNotification aircraftNotification);
}
