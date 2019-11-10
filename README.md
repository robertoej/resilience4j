# Resilience4j + Spring Boot
This project is based on [this sample from Resilience4j repository](https://github.com/resilience4j/resilience4j-spring-boot2-demo). It contains two APIs of two different services for retrieving the current date. The project uses `resilience4j` for `Circuit Breaker Pattern`, `Bulkhead Pattern`, and `Retry Pattern`. It also exports metrics via `Prometheus` and plots them on `Grafana`.
## Requirements
* Apache Maven 3.6.0
## Building the project
Firstly, we need to package our code by running the following command on the root of the project:
```
mvn clean package
```
Secondly, we run `docker-compose` to create the container images of our infrastructure: a Maven image with our application, a Prometheus image for metrics and Grafana for dashboard. The following command performs such actions:
```
docker-compose build
```
## Running the project
`docker-compose`should also be used for running the project via the following command:
```
docker-compose up
```
The app server runs on port 8080.
## Setting up metrics
Check step 2 and 3 from the [project I based this sample on](https://github.com/resilience4j/resilience4j-spring-boot2-demo).