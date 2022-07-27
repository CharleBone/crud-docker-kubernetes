FROM openjdk:17.0.2

WORKDIR /app/usuarios

COPY ./pom.xml /app
COPY ./usuarios/.mvn ./.mvn
COPY ./usuarios/mvnw .
COPY ./usuarios/pom.xml .

RUN ./mvnw clean package -Dmaven.test.Skip -Dmaven.main.Skip -Dspring-boot.repackage.skip && rm -r ./target/

COPY ./usuarios/src ./src

RUN ./mvnw clean package -DskipTest

EXPOSE 8001

ENTRYPOINT ["java", "-jar", "./target/usuarios-0.0.1-SNAPSHOT.jar"]