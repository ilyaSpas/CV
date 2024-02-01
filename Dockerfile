FROM openjdk:17
COPY ./target/project_web_app-0.0.1-SNAPSHOT.jar dir/src/project/project_web_app.jar
WORKDIR dir/src/project
EXPOSE 8080
CMD ["java", "-jar", "project_web_app.jar"]