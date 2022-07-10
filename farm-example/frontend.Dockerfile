FROM node:16-alpine as build-step

WORKDIR /app

ENV PATH /frontend/node_modules/.bin:$PATH

COPY ./frontend/package.json yarn.lock ./
COPY ./frontend/src ./src
COPY ./frontend/public ./public

EXPOSE 3000

RUN npm install -l

CMD ["npm", "start"]
