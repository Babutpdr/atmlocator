# Atmlocator Spring Boot(version 2.4.5) Application
This is sample microservice to get list of ATM's in Netherlands and also can find ATM in within the city.
# Steps to run this application in our local
- First we need to clone this repositoy to in our local
Refer this document how to clone a git repo in our local https://docs.github.com/en/github/creating-cloning-and-archiving-repositories/cloning-a-repository.
## Prerequisite softwares
  - JDK 8 need to be installed in your system,your can refer here how to install JDK https://docs.oracle.com/javase/8/docs/technotes/guides/install/windows_jdk_install.html
  - We need to install maven version 3.8.1 or higher, you can refer here how to install maven https://maven.apache.org/install.html

- Navigate the folder where you cloned the project and you should be in root folder </br>example: <b> D:\workspace\GitHub\atmlocator</b>
- Open the command prompt, navigate to application directory using cd command </br>example: <b> cd D:\workspace\GitHub\atmlocator </b>
- Now build the application using maven example: mvn clean install ,this command will execute the junit test as well if you want to skip you can run this command(not recommended)
mvn clean install -DskipTests
- Now you can the the spring boot application using below command </br>
        <b> mvn spring-boot:run </b>
# Steps to executes the endpoints using postman
- We need to install postman in our local,you can refer here how to install postman https://learning.postman.com/docs/getting-started/installation-and-updates/
- Open the installed postman app and go the postman builder tab
- Enter below url and select http method as GET </br>
  <b>http://localhost:8080/api/v1/atmlocator/atms</b>  
  the above endpoint will give you all atm's
- if we need to find based on city you can give below url and http method should be GET</br>
  <b>http://localhost:8080/api/v1/atmlocator/atms?city=Vlagtwedde</b> </br>
  here are some cities <b>Leeuwarden,Enkhuizen,Amsterdam</b> you can replace and test.

