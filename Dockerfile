FROM maven:3.9.9-eclipse-temurin-17 AS build 
WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline -B

COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre-alpine 
WORKDIR /app

COPY --from=build /app/target/*.jar securiy-service.jar
EXPOSE 9000

ENV JAVA_OPTS=""
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar securiy-service.jar"]


