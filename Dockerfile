FROM java:8
EXPOSE 8080
ADD /target/exercise-0.0.1-SNAPSHOT.jar bundle-exercise-0.0.1.jar
ENTRYPOINT ["java", "-jar", "bundle-exercise-0.0.1.jar"]