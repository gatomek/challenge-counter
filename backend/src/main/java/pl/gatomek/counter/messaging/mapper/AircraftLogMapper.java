package pl.gatomek.counter.messaging.mapper;

import pl.gatomek.counter.dto.AircraftLog;
import pl.gatomek.counter.repository.AircraftLogEntity;

public class AircraftLogMapper {

    private AircraftLogMapper() {
    }

    public static AircraftLogEntity toEntity(AircraftLog log) {
        AircraftLogEntity entity = new AircraftLogEntity();
        entity.setIcao(log.getIcao());
        entity.setFlight(log.getFlight());
        entity.setLatitude(log.getLatitude());
        entity.setLongitude(log.getLongitude());
        entity.setDesc(log.getDesc());
        entity.setBarometricAltitude(log.getBarometricAltitude());
        return entity;
    }
}
