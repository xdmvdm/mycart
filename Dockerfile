FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 9090
ARG JAR_FILE=/target/democart-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} democart-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/democart-0.0.1-SNAPSHOT.jar"]

 
