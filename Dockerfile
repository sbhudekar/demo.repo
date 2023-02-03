#pull tomcat latest image from dockerhub
FROM tomcat:8.0.51-jre8-alpine
MAINTAINER sbhudekar1896@gmail.com
#Copy Jar file to container
COPY ./target/demo*.jar /usr/local/tomcat/webapps
EXPOSE 8080 80
USER demoapp
WORKDIR /usr/local/tomcat/webapps
CMD ["catalina.sh","run"]