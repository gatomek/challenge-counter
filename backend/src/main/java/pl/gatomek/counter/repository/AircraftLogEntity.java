package pl.gatomek.counter.repository;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "aircraftlog", schema = "radar")
public class AircraftLogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aircraftlog_seq")
    @SequenceGenerator(name = "aircraftlog_seq", sequenceName = "aircraftlog_id_seq", allocationSize = 1, schema = "radar")
    private Long id;

    private Instant timestamp;

    @Column(name = "icao", length = 20, nullable = false)
    private String icao;

    @Column(name = "flight", length = 20)
    private String flight;

    @Column(name = "latitude", precision = 9, scale = 6)
    private BigDecimal latitude;

    @Column(name = "longitude", precision = 9, scale = 6)
    private BigDecimal longitude;

    @Column(name = "description")
    private String desc;

    @Column(name = "alt_baro")
    private String barometricAltitude;
}
