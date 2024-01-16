

FROM maven:3.8.5-openjdk-17
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml -e clean install -DskipTests
ENTRYPOINT ["java","-jar","/home/app/target/neima-application.jar"]