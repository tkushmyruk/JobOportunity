FROM openjdk:20-jdk-slim
COPY target/test-1.0-SNAPSHOT.jar /home/PositionNotificationSystem-1.0-SNAPSHOT.jar
CMD ["java","-jar","/home/PositionNotificationSystem-1.0-SNAPSHOT.jar"]