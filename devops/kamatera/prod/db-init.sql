create user dispatcher with password '3bbPslCbpgbiwSg1RLAp';

CREATE SCHEMA IF NOT EXISTS radar AUTHORIZATION dispatcher;

create table radar.aircraftlog (
   id bigserial primary key,
   timestamp timestamp not null,
   icao text not null,
   flight text,
   latitude numeric(9,6),
   longitude numeric(9,6),
   description text,
   alt_baro text
);

GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA radar TO dispatcher;

GRANT USAGE, SELECT ON SEQUENCE radar.aircraftlog_id_seq TO dispatcher;
