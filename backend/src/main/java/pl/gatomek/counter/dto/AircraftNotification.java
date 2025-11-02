package pl.gatomek.counter.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import java.util.List;

@Data
public class AircraftNotification {

    @JsonAlias("ac")
    private List<AircraftLog> aircraftLogs;

    @JsonAlias("msg")
    private String status;

    @JsonAlias("now")
    private long timestamp;

    private int total;

    private long ctime;

    private long ptime;
}
