package pl.gatomek.radar.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class AircraftNotification {

    @JsonProperty("ac")
    private List<AircraftLog> aircraftLogs;

    @JsonProperty("msg")
    private String status;

    @JsonProperty("now")
    private long timestamp;

    private int total;

    private long ctime;

    private long ptime;
}
