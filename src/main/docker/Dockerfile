FROM adoptopenjdk:17
ARG JAR_FILE=*.jar
ADD src/docker/demo-0.0.1-SNAPSHOT.jar spring-jpa-project.jar
ENTRYPOINT ["java", "-jar", "spring-jpa-project.jar"]