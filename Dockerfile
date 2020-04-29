FROM openjdk:8
WORKDIR /home/devopsjenkins
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8282
ENTRYPOINT ["java","-jar","/app.jar"]
