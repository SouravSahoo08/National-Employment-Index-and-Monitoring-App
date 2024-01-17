# Stage 1: Build the application
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /home/app
COPY src src
COPY pom.xml .
RUN mvn -e clean install -DskipTests

# Stage 2: Create a minimal runtime image
FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=build /home/app/target/neima-application.jar /app/neima-application.jar
ENTRYPOINT ["java", "-jar", "/app/neima-application.jar"]