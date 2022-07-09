FROM python:3.8-slim

WORKDIR /app

COPY ../app ./src
COPY ../pyproject.toml .
COPY ../poetry.lock .

RUN pip install poetry
RUN poetry install --no-dev

EXPOSE 8080

CMD ["poetry", "run", "python", "-m", "src.main"]
