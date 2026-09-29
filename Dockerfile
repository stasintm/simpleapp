FROM openjdk:17.0.1-jdk-slim

WORKDIR /app

COPY target/*.jar simpleapp.jar

ENTRYPOINT ["java", "-jar", "simpleapp.jar"]