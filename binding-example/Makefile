SHELL=/bin/bash

PACKAGE_NAME=binding_example

.PHONY: pre-commit test pip clean

clean:
	cargo clean

pre-commit: venv
	isort .
	black .
	blackdoc .
	mypy
	flake8
	make -C .. fmt_toml
	cargo fmt --all

test:
	maturin develop
	pytest tests

test-with-cov: venv
	pytest \
		--cov=polars \
		--cov-report xml \
		--cov-fail-under=85 \
		--import-mode=importlib

build-no-venv:
	maturin build -o wheels

build-no-venv-release:
	maturin build -o wheels --release

build-and-test-no-venv:
	maturin build -o wheels
	pip install --force-reinstall -U wheels/${PACKAGE_NAME}-*.whl
	pytest tests

install-no-venv: build-no-venv install-wheel
install-no-venv-release: build-no-venv-release install-wheel
