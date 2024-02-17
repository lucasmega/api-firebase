FROM maven:3.8.4-openjdk-17-slim AS builder
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
FROM openjdk:17
#COPY --from=build /home/app/target/Falcon-0.0.1.jar /usr/local/lib/falcon.jar
EXPOSE 8080