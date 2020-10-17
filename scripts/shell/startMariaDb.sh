#!/bin/sh

sudo docker run --name maria-container \
	-p 3306:3306 \
	-v /home/dragos.balan/data/mariadb:/var/lib/mysql \
	-e MYSQL_ROOT_PASSWORD=secret \
	-d mariadb:latest
