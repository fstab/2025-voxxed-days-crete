FROM node:24-alpine

COPY package.json /
COPY static/ /static/
COPY frontend.js /
COPY k8s.env /.env
RUN npm install

USER node

EXPOSE 8080

ENTRYPOINT ["/usr/local/bin/node", "--env-file", ".env", "/frontend.js" ]
