#!/bin/bash

while true; do
	time curl http://localhost:8080/clock_api & time curl http://localhost:8080/clock_api & time curl http://localhost:8080/clock_api
	time curl http://localhost:8080/time_api & time curl http://localhost:8080/time_api & time curl http://localhost:8080/time_api
	wait
done
