FROM adoptopenjdk/openjdk11:latest

EXPOSE 8081

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/app.jar"]

## set a directory for the app
#WORKDIR /usr/src/app
#
## copy all the files to the container
#COPY . .
#
## define the port number the container should expose
#EXPOSE 8081
#
## run the application
#RUN javac StocksComparatorApplication
#CMD StocksComparatorApplication