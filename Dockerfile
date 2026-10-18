#
# Mvn Build
#
FROM maven:3.9-eclipse-temurin-21-noble AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Jar Package
#
FROM eclipse-temurin:21-jre-noble
COPY --from=build /home/app/target/*-SNAPSHOT.jar /usr/local/lib/bookstorecrudsecuritydb.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/usr/local/lib/bookstorecrudsecuritydb.jar"]