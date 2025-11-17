```sql
-- log entries count
select count(*) from radar.aircraft_log al ;

-- time range of logs
select min(a."timestamp" ), max(a."timestamp" ) from radar.aircraft_log al ;

-- select all log entries
select * from radar.aircraft_log al ;

-- select unique aircraft descriptions
select distinct(a.description) from radar.aircraft_log a order by a.description ;

-- Apache - aircraft activity identified by icao code 'ae6cbd'
select * from radar.aircraft_log a where a.icao = 'ae6cbd' order by a."timestamp" ;

-- Apache activities
select * from radar.aircraft_log a where a.description = 'MCDONNELL DOUGLAS AH-64 Apache' order by a."timestamp" asc;


select a.description, count(distinct( a.icao)) as count from radar.aircraft_log a group by a.description order by count desc;


select distinct( a.icao) from radar.aircraft_log a where a.description = 'Lockheed Martin C-130J-30 Hercules';

-- relation from aircraft_log to flight_evt
with last_event_per_flight as (
    select fe.uuid, max(fe.id) as id
    from radar.flight_evt fe
    where fe.icao = '4ca4ef'
    group by fe.uuid
)
select l.id as log_id, fe.id as flight_id, fe.startlogid , fe.endlogid , fe.comment
from last_event_per_flight as lef
         join radar.flight_evt fe on lef.id = fe.id
         join radar.aircraft_log l on fe.icao = l.icao
where l.id = 19783 and l.id >= fe.startlogid and (l.id <= fe.endlogid or fe.endlogid is null);

-- list of all flights
select fe.uuid, max(fe.id) as id
from radar.flight_evt fe
group by fe.uuid;

```