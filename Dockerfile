FROM openjdk:17

EXPOSE 21000

ADD ./build/libs/*.jar app.jar

ENTRYPOINT ["java", "-jar", "-Duser.timezone=Asia/Seoul", "/app.jar"]

