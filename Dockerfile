# #
# # Build stage
# #
# FROM maven:3.6.3-jdk-8-slim AS build
# COPY ./sisvendas-backend/src /home/sisvendas-backend/src 
# COPY ./sisvendas-backend/pom.xml /home/sisvendas-backend
# RUN mvn -f /home/sisvendas-backend/pom.xml clean install

# FROM openjdk:8-jdk-alpine
# COPY --from=build /home/sisvendas-backend/target/sisvendas-backend-0.0.1-SNAPSHOT.jar app.jar
# EXPOSE 8081
# ENTRYPOINT ["java","-jar","/app.jar"]