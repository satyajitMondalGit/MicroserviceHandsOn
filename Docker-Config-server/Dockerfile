FROM openjdk:8
ADD target/config-server.jar config-server.jar
EXPOSE 9091
ENTRYPOINT ["java", "-jar", "config-server.jar"]