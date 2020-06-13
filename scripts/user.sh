#!/bin/sh

printf "\n\n*********************************************************"
printf "\n          adding two users "
printf "\n**********************************************************\n"
curl -v http://localhost:8080/webcv/user \
     --header "Content-Type: application/json" \
     --request POST \
     --data '{"username": "the_first"}'

curl -v http://localhost:8080/webcv/user \
     --header "Content-Type: application/json" \
     --request POST \
     --data '{"username": "the_second"}'

printf "\n\n**********************************************************"
printf "\n             listing all users"
printf "\n**********************************************************\n"
curl -v localhost:8080/webcv/users

printf "\n\n**********************************************************"
printf "\n             listing one single user"
printf "\n**********************************************************\n"
curl -v  localhost:8080/webcv/user/1

printf "\n\n**********************************************************"
printf "\n              listing non existent user"
printf "\n**********************************************************\n"
curl -v localhost:8080/webcv/user/123456789


printf "\n\n*********************************************************"
printf "\n          adding a new user "
printf "\n**********************************************************\n"
curl -v http://localhost:8080/webcv/user \
     --header "Content-Type: application/json" \
     --request POST \
     --data '{"username": "third"}'

printf "\n\n*********************************************************"
printf "\n          modifying a user via PUT method "
printf "\n**********************************************************\n"
curl -v http://localhost:8080/webcv/user \
     --header "Content-Type: application/json" \
     --request PUT \
     --data '{"id":"3", "username": "THE_THIRD"}'


printf "\n\n**********************************************************"
printf "\n             listing all users after update "
printf "\n**********************************************************\n"
curl -v localhost:8080/webcv/users

printf "\n\n**********************************************************"
printf "\n             deleting a user "
printf "\n**********************************************************\n"
curl http://localhost:8080/webcv/user/3 \
 --request DELETE


