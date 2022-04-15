SHELL := /bin/bash


run-frontend:
	cd frontend/ && npm install && ng serve

run:
	docker-compose -f docker/local-compose.yaml up

down:
	docker-compose -f docker/local-compose.yaml down -v
