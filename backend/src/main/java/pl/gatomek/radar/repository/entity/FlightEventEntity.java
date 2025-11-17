package pl.gatomek.radar.repository.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "flight_evt", schema = "radar")
public class FlightEventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "flight_evt_seq")
    @SequenceGenerator(name = "flight_evt_seq", sequenceName = "flight_evt_id_seq", allocationSize = 1, schema = "radar")
    private Long id;

    @Column(name = "uuid")
    private UUID uuid;

    @Column(name = "icao", length = 20, nullable = false)
    private String icao;

    @Column(name = "startlogid")
    private Long startLogId;

    @Column(name = "endlogid")
    private Long endLogId;

    @Column(name = "comment")
    private String comment;

    @Column(name = "timestamp")
    private java.time.Instant timestamp;
}
