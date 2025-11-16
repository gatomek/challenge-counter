package pl.gatomek.radar.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AircraftLog implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @With
    @JsonIgnore
    private Instant timestamp;

    @JsonProperty("hex")
    private String icao;

    private String flight;

    @JsonProperty("r")
    private String registerNumber;

    @JsonProperty("t")
    private String type;

    private String desc;

    @JsonProperty("lat")
    private BigDecimal latitude;

    @JsonProperty("lon")
    private BigDecimal longitude;

    @JsonProperty("alt_baro")
    private String barometricAltitude;

    @JsonProperty("alt_geom")
    private String geometricAltitude;

    private BigDecimal mach;

    @JsonProperty("category")
    private String emitterCategory;

    private String emergency;

    private Integer dbFlags;

    private Integer messages;

    public void setFlight(String flight) {
        this.flight = Optional.ofNullable(flight).map(String::trim).orElse(null);
    }
}
