FROM maven:3.6.3-openjdk-11-slim AS builder
RUN mkdir -p /build
WORKDIR /build
COPY pom.xml /build
RUN mvn -B dependency:resolve dependency:resolve-plugins
COPY src /build/src
RUN mvn clean package

FROM openjdk:11.0-slim AS runtime
VOLUME /tmp
EXPOSE 8080
COPY --from=builder /build/target/*.jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]