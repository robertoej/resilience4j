FROM maven:3.6.0-jdk-8-alpine

COPY ./target/resilience4j-*.jar resilience4j-app.jar

CMD java -jar resilience4j-app.jar