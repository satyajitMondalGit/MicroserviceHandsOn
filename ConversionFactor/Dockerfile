FROM openjdk:8
ADD target/conversion-factor.jar conversion-factor.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "conversion-factor.jar"]