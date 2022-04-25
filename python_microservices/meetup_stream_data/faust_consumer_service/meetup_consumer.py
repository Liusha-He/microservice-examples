import sys
from datetime import datetime
from typing import List

import faust

from .models import Group, GroupTopic, Venue, Event, RSVP

sys.path.append("../")
from databases.db_connection import engine, db_session
from databases.db_models import Topics


# Base.metadata.drop_all(engine)
# Base.metadata.create_all(engine)

message_schema = faust.Schema(value_type=RSVP, value_serializer="json")
app = faust.App("meetup_consumer", broker="kafka://localhost:9092")
meetup_topic = app.topic("meetup_rsvps", schema=message_schema, partitions=1)


@app.agent(meetup_topic)
async def process_rsvp(messages):
    async for msg in messages:
        group: Group = msg.group
        event: Event = msg.event
        topics: List[GroupTopic] = group.group_topics

        city = group.group_city
        state = group.group_state
        country = group.group_country

        if msg.venue:
            venue: Venue = msg.venue
            location = f"{venue.venue_name}. {city}. {state}. {country}"
        else:
            location = f"{city}. {state}. {country}"

        location = location.replace(" None.", "")

        rsvp_time = datetime.fromtimestamp(msg.mtime / 1_000)
        event_time = datetime.fromtimestamp(event.time / 1_000)
        url = msg.event.event_url

        for topic in topics:
            tname = topic.topic_name

            with db_session(engine) as sess:
                sess.add(Topics(
                    topic=tname,
                    created_at=rsvp_time,
                    location=location,
                    event_time=event_time,
                    url=url,
                    insert_dt=datetime.now()
                ))
                sess.commit()
