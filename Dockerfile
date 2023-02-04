FROM openjdk:17

ARG PROFILE
ARG ADDITIONAL_OPTS

ENV PROFILE=${PROFILE}
ENV ADDITIONAL_OPTS=${ADDITIONAL_OPTS}

WORKDIR /app

COPY /target/*.jar shortener.jar

EXPOSE 8080

CMD java -jar shortener.jar --spring.profiles.active=${PROFILE}
