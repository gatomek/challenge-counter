package pl.gatomek.counter.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Optional;

@Data
public class AircraftLog implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @JsonAlias("hex")
    private String icao;

    private String flight;

    @JsonAlias("r")
    private String registerNumber;

    @JsonAlias("t")
    private String type;

    private String desc;

    @JsonAlias("lat")
    private BigDecimal latitude;

    @JsonAlias("lon")
    private BigDecimal longitude;

    @JsonAlias("alt_baro")
    private String barometricAltitude;

    @JsonAlias("alt_geom")
    private String geometricAltitude;

    private BigDecimal mach;

    @JsonAlias("category")
    private String emitterCategory;

    private String emergency;

    private Integer dbFlags;

    public void setFlight(String flight) {
        this.flight = Optional.ofNullable(flight).map(String::trim).orElse(null);
    }
}
