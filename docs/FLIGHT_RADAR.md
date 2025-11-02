

## Service config file localization:
`/etc/systemd/system/challenge-flightradar.service`

## Config file (challenge-flightradar.service) content:
```
[Unit]
Description=flightradar
After=syslog.target

[Service]
User=gatomek
ExecStart=/usr/bin/java -jar /home/gatomek/challenge-flightradar/counter-0.0.1.jar
WorkingDirectory=/home/gatomek/challenge-flightradar
StandardOutput=journal
StandardError=journal
SyslogIdentifier=challenge-flightradar
SuccessExitStatus=143
EnvironmentFile=/home/gatomek/challenge-flightradar/.env

[Install]
WantedBy=multi-user.target
```

## Command to run after adding new service config file
`sudo systemctl daemon-reload`

## Commands to change/check state of service
```
sudo systemctl status  challenge-flightradar.service
sudo systemctl start   challenge-flightradar.service
sudo systemctl stop    challenge-flightradar.service
sudo systemctl restart challenge-flightradar.service
```

## Service log preview
`sudo journalctl -u challenge-flightradar.service`
