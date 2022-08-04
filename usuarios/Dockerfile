ARG NAME=usuarios

FROM openjdk:17-jdk-alpine as builder

ARG NAME

WORKDIR /app/$NAME

COPY ./pom.xml /app
COPY ./$NAME/.mvn ./.mvn
COPY ./$NAME/mvnw .
COPY ./$NAME/pom.xml .

RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/
#RUN ./mvnw dependency:go-offline
COPY ./$NAME/src ./src

RUN ./mvnw clean package -DskipTests

FROM openjdk:17-jdk-alpine

ARG NAME

WORKDIR /app

RUN mkdir ./logs

ARG TARGET_FOLDER=/app/$NAME/target
COPY --from=builder $TARGET_FOLDER/usuarios-0.0.1-SNAPSHOT.jar .
ARG PORT_APP=8001
ENV PORT $PORT_APP
EXPOSE $PORT

CMD ["java", "-jar", "usuarios-0.0.1-SNAPSHOT.jar"]