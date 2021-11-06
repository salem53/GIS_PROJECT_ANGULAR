###############################################################
# gis : Spring stage build                                 #
###############################################################
FROM maven:3.6.0-jdk-11-slim AS gis_build


COPY back/src /home/app/src
COPY back/pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

###############################################################
# gis : Spring stage deploy                                #
###############################################################
FROM openjdk:11-jre-slim AS gis
COPY --from=gis_build /home/app/target/gis-0.0.1-SNAPSHOT.jar /usr/local/lib/demo.jar

EXPOSE ${SERVER_PORT_WS}
ENTRYPOINT ["java","-jar","/usr/local/lib/demo.jar"]
