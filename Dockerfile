FROM maven:3.8.4-openjdk-17-slim AS builder

FROM openjdk:17

RUN apt-get update && sudo apt-get install -y maven

RUN mvn clean package

WORKDIR /app

COPY /target/api-firebase-0.0.1-SNAPSHOT.jar /app

EXPOSE 8080

CMD ["java", "-jar", "api-firebase-0.0.1-SNAPSHOT.jar"]
