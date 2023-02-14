FROM openjdk:8
EXPOSE 8080
ADD target/SsnCheckingApp.jar SsnCheckingApp.jar
ENTRYPOINT [ "java","-jar","/SsnCheckingApp.jar" ]