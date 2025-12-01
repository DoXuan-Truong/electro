# Stage 1: Build the application
FROM maven:3.8.6-eclipse-temurin-11 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
# Copy lombok.config if it exists, otherwise this line might fail if not handled carefully. 
# Since I saw it in the file list, I will include it.
COPY lombok.config .
RUN mvn clean package -DskipTests

# Stage 2: Run the application
FROM eclipse-temurin:11-jdk
# Install curl for healthcheck
RUN apt-get update && apt-get install -y curl && rm -rf /var/lib/apt/lists/*
WORKDIR /electro-server
COPY --from=build /app/target/electro-0.0.1-SNAPSHOT.jar /electro-server/electro-0.0.1-SNAPSHOT.jar

# Mở cổng cho MySQL và Spring
EXPOSE 8085

# Đặt định dạng mã hóa Unicode
ENV LANG=C.UTF-8
ENV LC_ALL=C.UTF-8

# Chạy ứng dụng Spring
CMD ["java", "-jar", "electro-0.0.1-SNAPSHOT.jar"]
