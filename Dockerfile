FROM openjdk:12-jdk-alpine

RUN apk add --no-cache bash

WORKDIR /f1mp

CMD ./gradlew run