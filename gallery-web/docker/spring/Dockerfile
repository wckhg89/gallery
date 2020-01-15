FROM openjdk:8-jdk-alpine
VOLUME /tmp

# Timezone 보정
RUN apk add tzdata
RUN cp /usr/share/zoneinfo/Asia/Seoul /etc/localtime
RUN echo "Asia/Seoul" > /etc/timezone
ENV LANG=ko_KR.UTF-8

COPY /build/libs/*.jar /app/gallery.jar
ADD https://github.com/ufoscout/docker-compose-wait/releases/download/2.2.1/wait /wait
RUN chmod +x /wait
ENTRYPOINT ["sh", "-c", "/wait && java -Djava.security.egd=file:/dev/./urandom -Dspring.data.mongodb.host=${DB_HOST} -Dspring.data.mongodb.port=${DB_PORT} -Dspring.data.mongodb.database=${DB_NAME} -jar /app/gallery.jar"]