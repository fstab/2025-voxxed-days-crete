#!/bin/bash

./mvnw package
docker build -t voxxed-days-crete/name-generator .
