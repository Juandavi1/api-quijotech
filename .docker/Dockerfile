FROM openjdk:12-jdk-alpine AS start
WORKDIR /usr/src/api
COPY controllers/target/controllers-1.0-SNAPSHOT.jar .
EXPOSE 8080
ENTRYPOINT ["java","-jar","controllers-1.0-SNAPSHOT.jar"]
