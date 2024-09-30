FROM maven:3-amazoncorretto-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src

RUN mvn package -DskipTests

FROM amazoncorretto:17
WORKDIR /app
COPY --from=build /app/target/*jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]


