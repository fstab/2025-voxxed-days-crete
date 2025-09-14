#!/bin/sh

cd $(dirname $0)/..

kubectl delete -f ./deploy/load-generator.yaml
kubectl delete configmap load-generator
cp ./deploy/load-generator-high-load.js /tmp/load-generator.js
kubectl create configmap load-generator --from-file=/tmp/load-generator.js
kubectl apply -f ./deploy/load-generator.yaml
