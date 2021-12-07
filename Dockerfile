FROM openjdk:17-alpine
VOLUME /tmp
EXPOSE 5000
ARG JAR_FILE
COPY ${JAR_FILE} flemens-scores-0.0.1-SNAPSHOT.jar
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /flemens-scores-0.0.1-SNAPSHOT.jar" ]