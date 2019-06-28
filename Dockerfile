FROM java:8

ADD ./target/liugeng-service.jar liugeng-service.jar
ADD ./scripts/liugeng-service.sh liugeng-service.sh

RUN

EXPOSE 8080

