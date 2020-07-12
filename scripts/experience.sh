#!/bin/sh

TOMCAT_PORT=8081

echo -e "\n\n*********************************************************"
echo "          adding experience to an existing user "
echo "*********************************************************"
curl -v http://localhost:$TOMCAT_PORT/webcv/users/1/experience \
     --header "Content-Type: application/json" \
     --request POST \
     --data '{"jobTitle": "experience as team lead for a team of 5", "companyId" : "1", "companyName" : "ibm"}'



