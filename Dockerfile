FROM openjdk:15
ADD target/docker-file.jar docker-file.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "docker-file.jar"]