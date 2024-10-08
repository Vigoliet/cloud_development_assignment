# Use an official Java runtime as a parent image
FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /app

# Copy the application JAR file into the container
COPY target/songify-0.0.1-SNAPSHOT.jar /app/songify.jar

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Run the JAR file
ENTRYPOINT ["java", "-jar", "/app/songify.jar"]