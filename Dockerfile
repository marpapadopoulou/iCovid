# Use an official Java runtime as the base image
FROM openjdk:11-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy your application code to the container
COPY . .

# Expose the port Render uses
ENV PORT 8080
EXPOSE 8080

# Build the application (if necessary)
RUN ./mvnw clean package

# Run the application
CMD ["java", "-jar", "target/iCovid.war"]
