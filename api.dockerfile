FROM openjdk:13-jdk-alpine

ENV DIR=/Users/davidalmeida/Documents/Desenvolvimento/MBA/Hackaton/api-covid-19/

WORKDIR $DIR

COPY ./target/apicovid.jar $DIR/app.jar

CMD ["java", "-Duser.timezone=GMT-03:00", "-Xms256m", "-Xmx512m", "-jar", "app.jar"]

EXPOSE 8080
