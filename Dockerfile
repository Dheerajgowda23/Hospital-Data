FROM tomcat:10.1

COPY target/HospitalWebApp-1.0.war /usr/local/tomcat/webapps/

EXPOSE 8080
git push origin maingit rm --cached target/HospitalWebApp-1.0.war
CMD ["catalina.sh", "run"]