SHELL := /bin/bash

test:
	poetry run pytest -svv -m "not (integration)"

lint:
	poetry run flake8 src/

format:
	poetry run importanize src && pipenv run black src

ci-format:
	poetry run importanize src --ci && pipenv run black src --check
