FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY build/libs /app
ADD https://github.com/ufoscout/docker-compose-wait/releases/download/2.2.1/wait /wait
RUN chmod +x /wait
ENTRYPOINT ["sh", "-c", "/wait && java -Djava.security.egd=file:/dev/./urandom -Dspring.data.mongodb.host=${DB_HOST} -Dspring.data.mongodb.port=${DB_PORT} -Dspring.data.mongodb.database=${DB_NAME} -jar /app/gallery.jar"]