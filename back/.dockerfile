#FROM gradle:8.10.2-jdk21
FROM eclipse-temurin:21-jdk


#RUN mkdir -p /var/home-storage/api
WORKDIR /var/home-storage/api

COPY ./ ./

RUN chmod +x gradlew
RUN ./gradlew_unix build
CMD ["./gradlew_unix bootRun"]
