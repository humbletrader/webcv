#!/bin/bash

source ./local_env.sh

printf "\n\n*********************************************************"
printf "\n        adding two users on ${APP_HOST} "
printf "\n**********************************************************\n"
curl -v http://$APP_HOST:$APP_PORT/webcv/users \
     --header "Content-Type: application/json" \
     --request POST \
     --data '{"username": "the_first", "firstName": "The", "lastName": "First", "photoLink": "http://localhost/images/1"}'


curl -v http://$APP_HOST:$APP_PORT/webcv/users \
     --header "Content-Type: application/json" \
     --request POST \
     --data '{"username": "the_second", "firstName": "The", "lastName": "Second", "photoLink": "http://localhost/images/2"}'

printf "\n\n**********************************************************"
printf "\n             listing all users"
printf "\n**********************************************************\n"
curl -v $APP_HOST:$APP_PORT/webcv/users

printf "\n\n**********************************************************"
printf "\n             listing one single user"
printf "\n**********************************************************\n"
curl -v  $APP_HOST:$APP_PORT/webcv/users/1

printf "\n\n**********************************************************"
printf "\n              listing non existent user"
printf "\n**********************************************************\n"
curl -v $APP_HOST:$APP_PORT/webcv/users/123456789


printf "\n\n*********************************************************"
printf "\n          adding a new user "
printf "\n**********************************************************\n"
curl -v http://$APP_HOST:$APP_PORT/webcv/users \
     --header "Content-Type: application/json" \
     --request POST \
     --data '{"username": "the_third", "firstName": "The", "lastName": "Third", "photoLink": "http://internet/images/3}'

printf "\n\n*********************************************************"
printf "\n          modifying a user via PUT method "
printf "\n**********************************************************\n"
curl -v http://$APP_HOST:$APP_PORT/webcv/users \
     --header "Content-Type: application/json" \
     --request PUT \
     --data '{"id":"3", "username": "THE_THIRD"}'


printf "\n\n**********************************************************"
printf "\n             listing all users after update "
printf "\n**********************************************************\n"
curl -v $APP_HOST:$APP_PORT/webcv/users

printf "\n\n**********************************************************"
printf "\n             deleting a user on $APP_HOST"
printf "\n**********************************************************\n"
curl http//$APP_HOST:$APP_PORT/webcv/users/3 \
 --request DELETE


