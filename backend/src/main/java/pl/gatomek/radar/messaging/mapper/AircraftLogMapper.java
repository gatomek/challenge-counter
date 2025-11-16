package pl.gatomek.radar.messaging.mapper;

import pl.gatomek.radar.dto.AircraftLog;
import pl.gatomek.radar.repository.entity.AircraftLogEntity;

public class AircraftLogMapper {

    private AircraftLogMapper() {
    }

    public static AircraftLogEntity toEntity(AircraftLog log) {
        AircraftLogEntity entity = new AircraftLogEntity();
        entity.setTimestamp(log.getTimestamp());
        entity.setIcao(log.getIcao());
        entity.setFlight(log.getFlight());
        entity.setLatitude(log.getLatitude());
        entity.setLongitude(log.getLongitude());
        entity.setDesc(log.getDesc());
        entity.setBarometricAltitude(log.getBarometricAltitude());
        entity.setType(log.getType());
        return entity;
    }
}
