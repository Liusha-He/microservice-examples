SHELL := /bin/bash

run-kafka:
	docker-compose -f docker/local-compose.yml up --force-recreate

stop-kafka:
	docker-compose -f docker/local-compose.yml down

run-producer:
	pipenv run python producer/meetup_producer.py

run-consumer:
	pipenv run faust -A faust_consumer_service worker -l info

init-db:
	docker-compose -f docker/postgres-compose.yml up --force-recreate

db-migrate:
	cd migrations && \
	PYTHONPATH=.. alembic revision --autogenerate --message "create topics"

db_down:
	docker-compose -f docker/postgres-compose.yml down
