FROM openjdk:8
ARG JAR_FILE=target/*.jar
ADD ${JAR_FILE} app.jar
EXPOSE 8282
ENTRYPOINT ["java","-jar","/app.jar"]
