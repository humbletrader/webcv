#!/bin/sh


echo -e "\n\n**********************************************************"
echo "             listing all users"
echo "**********************************************************"
curl -v localhost:8080/webcv/users

echo -e "\n\n**********************************************************"
echo "             listing one single user"
echo "**********************************************************"
curl -v  localhost:8080/webcv/user/1

echo -e "\n\n**********************************************************"
echo "              listing non existent user"
echo "**********************************************************"
curl -v localhost:8080/webcv/user/123456789


echo -e "\n\n*********************************************************"
echo "          adding a new user "
echo "*********************************************************"
curl -v http://localhost:8080/webcv/user \
     --header "Content-Type: application/json" \
     --request POST \
     --data '{"id" : 3, "username": "thethird"}'

echo -e "\n\n**********************************************************"
echo "             listing all users after insert "
echo "**********************************************************"
curl -v localhost:8080/webcv/users


