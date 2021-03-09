FROM gradle:jdk11 as builder

COPY . /tmp
WORKDIR /tmp
RUN gradle clean build


FROM openjdk:11-jre-slim as runtime
COPY --from=builder /tmp/build/libs/*.jar /app/app.jar
ENV SPRING_PROFILES_ACTIVE=dev
WORKDIR /app

EXPOSE 8080

CMD java -Dserver.port=$PORT -Xmx512m -jar app.jar
