FROM openjdk:17-jdk-slim
WORKDIR /app
RUN ["mvn", "clear"]
RUN ["mvn" , "package"]
COPY target/vehicle-service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 5051
ENTRYPOINT ["java", "-jar", "app.jar"]