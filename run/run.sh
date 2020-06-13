#!/bin/sh

# running via maven 
# mvn clean spring-boot:run


# running via maven with external properties 


# running via maven with external profiles

# running as a jar
java -jar target/webcv-0.0.1-SNAPSHOT.jar

# running as a jar with external properties 
java -jar ../target/webcv-0.0.1-SNAPSHOT.jar --spring.config.location=./external.application.properties

# running as a jar with external defined profiles
java -jar ../target/webcv-0.0.1-SNAPSHOT.jar --spring.active.profiles=mock



