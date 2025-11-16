package pl.gatomek.radar.service;

import pl.gatomek.radar.dto.AircraftLog;

public interface SavingLogUseCase {
    void save(AircraftLog log);
}
