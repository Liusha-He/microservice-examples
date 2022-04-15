FROM node:16.10-alpine as build-step

RUN mkdir -p /app
WORKDIR /app

COPY ./frontend/package.json /app
RUN npm install
COPY ./frontend /app

RUN npm run build --prod

FROM nginx:1.20.1

COPY --from=build-step /app/dist/angular-frontend /usr/share/nginx/html

EXPOSE 4200:80
