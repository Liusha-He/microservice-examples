from sqlalchemy import Column, String, DateTime, Integer, MetaData
from sqlalchemy.ext.declarative import declarative_base

db_metadata = MetaData({
    "ix": "ix_%(column_0_label)s",
    "uq": "uq_%(table_name)s_%(column_0_name)s",
    "ck": "ck_%(table_name)s_%(constraint_name)s",
    "fk": "fk_%(table_name)s_%(column_0_name)s_%(referred_table_name)s",
    "pk": "pk_%(table_name)s"
})
Base = declarative_base()


class Topics(Base):
    """Topic data model."""

    __tablename__ = "topic"

    id = Column("id", Integer, primary_key=True)
    topic = Column("topic", String(250), nullable=False)
    created_at = Column("created_at", DateTime, nullable=False)
    location = Column("location", String(100), nullable=False)
    event_time = Column("event_time", DateTime, nullable=False)
    url = Column("event_url", String(500), nullable=False)
    insert_dt = Column("insert_dt", DateTime, nullable=False)

    def __repr__(self):
        return f"topic - {self.topic}, location: {self.location}, event_time: {self.event_time}, url - {self.url}"
