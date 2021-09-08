FROM openjdk:18-jdk-alpine3.13
# VOLUME /tmp
COPY target/*.jar /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]