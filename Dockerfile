FROM openjdk:8 as build
ARG JAR_FILE=build/target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8282
ENTRYPOINT ["java","-jar","/app.jar"]
