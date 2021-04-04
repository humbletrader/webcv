#!/bin/bash

source ./local_env.sh

printf "\n\n*********************************************************"
printf "\n          adding a certification to user 1                 "
printf "\n**********************************************************\n"
curl -v http://$APP_HOST:$APP_PORT/webcv/users/1/certifications \
     --header "Content-Type: application/json" \
     --request POST \
     --data '{"certificationId": "1", "certificationName": "SCJP"}'

curl -v http://$APP_HOST:$APP_PORT/webcv/users/1/certifications \
     --header "Content-Type: application/json" \
     --request POST \
     --data '{"certificationId": "2", "certificationName": "Oracle PL/SQL Certification"}'

curl -v http://$APP_HOST:$APP_PORT/webcv/users/1/certifications \
     --request GET
