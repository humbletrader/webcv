#!/bin/sh

# running via maven
export spring_profiles_active=dev

# running with simple GC logs
# java -XX:+PrintGC -jar target/webcv-0.0.1-SNAPSHOT.jar

# running with detailed GC logs
java -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+PrintGCTimeStamps -Xloggc:gc.log -jar target/webcv-0.0.1-SNAPSHOT.jar
