FROM tomcat:10.1-jdk21-temurin
COPY FeedLink.war /usr/local/tomcat/webapps/ROOT.war
EXPOSE 8080
CMD ["catalina.sh", "run"]
