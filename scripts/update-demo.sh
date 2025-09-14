#!/bin/bash

cd $(dirname $0)/..

kind load docker-image voxxed-days-crete/frontend
kind load docker-image voxxed-days-crete/name-generator

kubectl delete \
	-f ./deploy/frontend.yaml \
	-f ./deploy/name-generator.yaml

kubectl apply \
	-f ./deploy/frontend.yaml \
	-f ./deploy/name-generator.yaml
