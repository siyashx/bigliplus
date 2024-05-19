FROM openjdk:17-jdk
EXPOSE 9292
ADD target/bigliplus-0.0.1-SNAPSHOT.jar bigliplus.jar
HEALTHCHECK --interval=30s --timeout=10s --retries=3 \
  CMD curl --fail http://localhost:9292/ || exit 1
ENTRYPOINT ["java", "-jar", "bigliplus.jar"]
