FROM node as npmbuilder
COPY . /build/
WORKDIR /build/src/main/resources/static
RUN npm install


FROM maven:3.3-jdk-8 as mavbuilder
COPY --from=npmbuilder /build /build/
WORKDIR /build
RUN mvn clean package -DskipTests


FROM openjdk:8-jdk
COPY --from=mavbuilder /build/target/demo-0.0.1-SNAPSHOT.jar /opt/
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/opt/demo-0.0.1-SNAPSHOT.jar"]
