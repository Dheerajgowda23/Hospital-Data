FROM tomcat:10.1

COPY target/HospitalWebApp-1.0.war /usr/local/tomcat/webapps/

EXPOSE 8080
CMD ["catalina.sh", "run"]