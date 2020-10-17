#!/bin/sh

TOMCAT_PORT=8081

printf "\n\n*********************************************************"
printf "          adding experience to an existing user "
printf "*********************************************************"
curl -v http://localhost:$TOMCAT_PORT/webcv/users/1/experience \
     --header "Content-Type: application/json" \
     --request POST \
     --data '{"jobTitle": "experience as team lead for a team of 5", "companyName" : "ibm", "jobStart": "31/01/2010", "jobEnd":"31/12/2016"}'

printf "\n\n*********************************************************"
printf "          updating experience of an existing user "
printf "*********************************************************"
curl -v http://localhost:$TOMCAT_PORT/webcv/users/1/experience \
     --header "Content-Type: application/json" \
     --request PUT \
     --data '{"expId": "4", "jobTitle": "team lead for a team of 10 for a java project", "companyName" : "ibm", "jobStart": "31/01/2010", "jobEnd":"25/12/2016"}'

printf "\n\n*********************************************************"
printf "  adding experience to remove it later "
printf "*********************************************************"
curl -v http://localhost:$TOMCAT_PORT/webcv/users/1/experience \
     --header "Content-Type: application/json" \
     --request POST \
     --data '{"jobTitle": "this job will be deleted", "companyName" : "home", "jobStart": "31/01/2010", "jobEnd":"31/12/2016"}'

printf "\n\n*********************************************************"
printf "  adding experience to remove it later "
printf "*********************************************************"
curl -v http://localhost:$TOMCAT_PORT/webcv/users/1/experience/6 \
     --request DELETE

