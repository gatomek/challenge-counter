## Docs
* https://www.postgresql.org/docs/current/sql-alterrole.html
* https://www.digitalocean.com/community/tutorials/how-to-install-postgresql-on-ubuntu-20-04-quickstart
* https://www.digitalocean.com/community/tutorials/how-to-install-and-use-postgresql-on-ubuntu-22-04

## Tworzenie nowej bazy danych
1. bieżący użytkownik przełącza się na użytkownika postgres
```
sudo -i -u postgres
```

2. dodajemy nowego użytkownika planowanej bazy danych z rolami administratora radartest
```
createuser --interactive
```

3. tworzymy nową rolę i ustawiamy jej hasło
```
psql
ALTER USER radartest WITH PASSWORD 'tester_password';
```

4. tworzymy nową bazę
```
CREATE DATABASE radartest OWNER radartest;
```

5. oddajemy nową bazę danych nowemu użytkownikowi
```
GRANT ALL PRIVILEGES ON DATABASE radartest TO radartest;
```

6. wywołujemy skrypty inicjujące:

## Postgres service workaround
1. restart usługi 
```
systemctl restart postgresql
```