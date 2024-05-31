FROM maven:3.8.1-openjdk-17-slim AS build
RUN mkdir /home/bookstore
COPY . /home/bookstore
RUN cd /home/bookstore && mvn clean package
RUN cp /home/bookstore/target/*.jar bookstore.jar
ENTRYPOINT [ "java","-jar","bookstore.jar" ]
EXPOSE 8080