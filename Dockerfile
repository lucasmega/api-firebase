FROM maven:3.8.4-openjdk-17-slim AS builder

FROM openjdk:17

RUN sudo apt-get update && sudo apt-get install -y maven

WORKDIR /app

COPY target/api-firebase-0.0.1-SNAPSHOT.jar /app

EXPOSE 8080

CMD ["java", "-jar", "api-firebase-0.0.1-SNAPSHOT.jar"]
