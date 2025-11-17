create user ${SQL_DB_USER} with password ${SQL_DB_PASSWORD};

CREATE SCHEMA IF NOT EXISTS radar AUTHORIZATION ${SQL_DB_USER};

create table radar.aircraft_log
(
    id          bigserial primary key,
    timestamp   timestamp not null,
    icao        text      not null,
    flight      text,
    latitude    numeric(9, 6),
    longitude   numeric(9, 6),
    description text,
    alt_baro    text,
    type        text
);

create index aircraftlog_timestamp_idx on radar.aircraft_log (timestamp);
create index aircraftlog_icao_idx on radar.aircraft_log (icao);

create table radar.flight_evt
(
    id         bigserial primary key,
    uuid       uuid not null,
    icao       text not null,
    startlogid bigint,
    endlogid   bigint,
    comment    text,
    timestamp  timestamp,
    FOREIGN KEY (startlogid) REFERENCES radar.aircraft_log (id),
    FOREIGN KEY (endlogid) REFERENCES radar.aircraft_log (id)
);

create index flight_evt_icao_idx on radar.flight_evt (icao);
create index flight_evt_startlogid_idx on radar.flight_evt (startlogid);
create index flight_evt_endlogid_idx on radar.flight_evt (endlogid);

GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA radar TO ${SQL_DB_USER};
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA radar TO ${SQL_DB_USER};
