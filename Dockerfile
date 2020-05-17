FROM openjdk:8-jre
EXPOSE 8080
ADD /target/notification-0.0.1-SNAPSHOT.jar notification.jar
ENTRYPOINT ["java", "-jar", "notification.jar"]
