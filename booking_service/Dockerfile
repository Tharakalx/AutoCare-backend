# Stage 1: Build
FROM maven:3.9.2-eclipse-temurin-17 AS build
WORKDIR /app

# Copy pom first (for caching dependencies)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy source code
COPY src ./src

# Build the jar
RUN mvn clean package -DskipTests

# Stage 2: Run
FROM openjdk:21-jdk-slim
WORKDIR /app

# Copy jar from the build stage
COPY --from=build /app/target/booking_service-0.0.1-SNAPSHOT.jar app.jar

# Expose port
EXPOSE 5052

# Start the application
ENTRYPOINT ["java", "-jar", "app.jar"]
