FROM openjdk:8-jdk-slim
COPY ./target/RuralRegistry-1.0-SNAPSHOT.jar /opt/service.jar
ENV SPRING_DATASOURCE_URL=jdbc:postgresql://database:5432/postgres
ENV POSTGRES_USER=postgres
ENV POSTGRES_PASSWORD=postgres
EXPOSE 8080
CMD java -jar /opt/service.jar