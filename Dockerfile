FROM openjdk:17

EXPOSE 21000

ADD ./build/libs/*.jar app.jar
ADD ./ghostvillage-45d1b-firebase-adminsdk-ebow2-31025af5f4.json .

ENTRYPOINT ["java", "-jar", "-Duser.timezone=Asia/Seoul", "/app.jar"]

