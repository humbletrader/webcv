#!/bin/bash

source ./local_env.sh

echo "list all available links provided by the spring boot actuator (dependent on configuration - see yml files)"
curl http://$APP_HOST:$APP_PORT/actuator

echo "get application status"
curl http://$APP_HOST:$APP_PORT/actuator/health

echo "get all http mappings"
curl http://$APP_HOST:$APP_PORT/actuator/mappings

echo "get environment variables"
curl http://$APP_HOST:$APP_PORT/actuator/env
