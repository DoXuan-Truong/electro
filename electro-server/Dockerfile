# Stage 1: Build the application
FROM maven:3.8.6-eclipse-temurin-11 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
COPY lombok.config .
RUN mvn clean package -DskipTests

# Stage 2: Run the application
FROM eclipse-temurin:11-jdk
RUN apt-get update && apt-get install -y curl && rm -rf /var/lib/apt/lists/*
WORKDIR /electro-server
COPY --from=build /app/target/electro-0.0.1.jar /electro-server/electro-0.0.1.jar

# Open port MySQL and Spring
EXPOSE 8085

# Default config Unicode
ENV LANG=C.UTF-8
ENV LC_ALL=C.UTF-8

# Run application Spring
CMD ["java", "-jar", "electro-0.0.1.jar"]
