FROM openjdk:11-jre-slim
VOLUME /tmp
ARG JAR_FILE=build/libs/wm-testrestclient-0.1.0.jar
ADD ${JAR_FILE} wm-testrestclient.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/wm-testrestclient.jar"]