FROM gradle:8.10.1-jdk17-alpine AS BUILD
WORKDIR /usr/app/
COPY . .
RUN gradle build --no-daemon

FROM openjdk:17-alpine
ENV JAR_NAME=eletronicCommercer-0.0.1-SNAPSHOT.jar
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY --from=BUILD $APP_HOME .
EXPOSE 8080
ENTRYPOINT exec java -jar $APP_HOME/build/libs/$JAR_NAME