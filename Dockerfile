FROM java:8

ADD /liugeng-service.jar /liugeng-service.jar

EXPOSE 8080

ENV PROFILE=prod

VOLUME /root/deploy/service-docker-v

CMD java -Dspring.profiles.active=${PROFILE} -jar ./liugeng-service.jar