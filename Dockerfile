# Use the official OpenJDK base image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy the built JAR file
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]

