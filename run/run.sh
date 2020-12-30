#!/bin/sh

# running via maven
export spring_profiles_active=dev
mvn clean spring-boot:run

# running via maven with external properties 


# running as a jar
java -jar target/webcv-0.0.1-SNAPSHOT.jar

# running as a jar with a specific profile
java -jar target/webcv-0.0.1-SNAPSHOT.jar -Dspring.profiles.active=dev

# running as a jar with external properties 
java -jar ../target/webcv-0.0.1-SNAPSHOT.jar --spring.config.location=./external.application.properties

# running as a jar with external defined profiles
java -jar ../target/webcv-0.0.1-SNAPSHOT.jar --spring.active.profiles=mock



