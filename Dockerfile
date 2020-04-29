FROM openjdk:8
VOLUME /tmp
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8282
ENTRYPOINT ["java","-jar","/app.jar"]
