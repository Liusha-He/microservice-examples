SHELL := /bin/sh

run-with-container:
	docker compose -f local-compose.yml up

migrate:
	export DATABASE_URL="postgres://admin:secret@localhost/postgres"
	diesel migration run

down:
	docker compose -f local-compose.yml down
