# Use an official OpenJDK runtime as a parent image
FROM eclipse-temurin:17-jdk-jammy

# Set the working directory inside the container
WORKDIR /app

# Copy the packaged jar file into the container
COPY target/insurance-me-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8081 (or your app port)
EXPOSE 8081

# Run the jar file
ENTRYPOINT ["java","-jar","app.jar"]
