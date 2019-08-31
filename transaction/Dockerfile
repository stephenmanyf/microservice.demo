FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8081
#ARG JAR_FILE
ARG JAR_FILE=target/microservices.transaction-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]