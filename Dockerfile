FROM openjdk:17
ADD target/demo-0.0.1-SNAPSHOT.jar trythisimage.jar
ENTRYPOINT ["java", "-jar", "trythisimage.jar"]
EXPOSE 8080