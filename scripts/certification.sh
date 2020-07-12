#!/bin/bash

TOMCAT_PORT=8081

printf "\n\n*********************************************************"
printf "\n          adding a certification to user 1                 "
printf "\n**********************************************************\n"
curl -v http://localhost:$TOMCAT_PORT/webcv/users/1/certifications \
     --header "Content-Type: application/json" \
     --request POST \
     --data '{"certificationId": "1", "certificationName": "SCJP"}'