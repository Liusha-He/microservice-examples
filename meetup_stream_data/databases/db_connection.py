from contextlib import contextmanager

from sqlalchemy import create_engine
from sqlalchemy.engine import Engine
from sqlalchemy.orm import sessionmaker, Session


POSTGRES_URI = "postgresql+psycopg2://admin:secret@localhost:5432/meetup"

engine = create_engine(POSTGRES_URI, pool_pre_ping=True)


@contextmanager
def db_session(engine: Engine):
    session: Session = sessionmaker(bind=engine, autocommit=False, autoflush=True)()
    try:
        yield session
    finally:
        session.close()
