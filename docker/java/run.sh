#!/bin/bash
while ! nc -z ${MYSQL_IP} ${MYSQL_PORT}; do sleep 3; done
#echo "${MYSQL_IP}:${MYSQL_PORT}"
echo 'start run app.jar'
java -jar app.jar