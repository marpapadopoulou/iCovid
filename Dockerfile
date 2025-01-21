# Use a Tomcat base image
FROM tomcat:9.0-jdk11-openjdk-slim

# Remove default webapps
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy your WAR file into the webapps directory
COPY iCovid.war /usr/local/tomcat/webapps/ROOT.war

# Expose the port Render uses
ENV PORT 8080
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]
