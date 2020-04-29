FROM openjdk:8
COPY ./target/*.jar app.jar
EXPOSE 8282
ENTRYPOINT ["java","-jar","/app.jar"]
