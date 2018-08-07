#!/bin/bash
docker-compose down
#docker rm java-1
#docker rm mysql-1
docker rmi javatest/java:1.0
docker rmi javatest/mysql:1.0