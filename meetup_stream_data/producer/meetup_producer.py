import json
from datetime import datetime
import logging

from kafka import KafkaProducer
from requests import Session

rsvp_stream_api_url = "https://stream.meetup.com/2/rsvps"
kafka_topic = "meetup_rsvps"
kafka_server = "localhost"

logger = logging.getLogger()


def run_meetup_producer():
    logger.info("Messaging producer started...")

    producer = KafkaProducer(
        bootstrap_servers=kafka_server,
        value_serializer=lambda x: json.dumps(x).encode("utf-8")
    )

    with Session() as sess:
        stream_response = sess.get(rsvp_stream_api_url, stream=True)

        while True:
            try:
                if stream_response.status_code == 200:
                    for msg in stream_response.iter_lines():
                        msg = json.loads(msg)

                        print(f"[{datetime.now()}]: Message '{msg}' has been sent successfully...")
                        producer.send(kafka_topic, msg)
            except:
                logger.error("connection to meetup could not be established...")
                break

        logger.info("Messaging service is terminated...")


if __name__ == '__main__':
    run_meetup_producer()
