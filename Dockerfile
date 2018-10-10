FROM openjdk:8-jre-alpine
MAINTAINER Neven Cvetkovic <nevenc@pivotal.io>
ARG JAR_FILE
ADD ./target/${JAR_FILE} /beer-service.jar
RUN sh -c 'touch /beer-service.jar'
ENTRYPOINT ["/usr/bin/java", "-jar", "/beer-service.jar"]
