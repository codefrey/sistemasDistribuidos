FROM openjdk:8-jdk-alpine
COPY ./target/sd-0.0.1-SNAPSHOT.jar /usr/src/sd/
WORKDIR /usr/src/sd
EXPOSE 8082
CMD ["java", "-jar", "sd-0.0.1-SNAPSHOT.jar"]