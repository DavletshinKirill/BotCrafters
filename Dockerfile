FROM maven:3.9.9-amazoncorretto-21-alpine AS build
COPY /storage/src /src
COPY /storage/pom.xml /
RUN mvn -f /pom.xml clean package -DskipTests

FROM eclipse-temurin
COPY --from=build /target/*.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]