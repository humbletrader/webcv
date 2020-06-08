#!/bin/sh

echo -e "\n\n*********************************************************"
echo "          adding a new user "
echo "*********************************************************"
curl -v http://localhost:8080/webcv/user/1/experience \
     --header "Content-Type: application/json" \
     --request POST \
     --data '{"title": "experience as team lead for a team of 5", "companyName" : "ibm"}'



