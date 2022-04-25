from typing import Optional, List

import faust


class Venue(faust.Record, serializer="json", validation=True):
    venue_name: Optional[str]
    lon: Optional[float]
    lat: Optional[float]
    venue_id: Optional[int]


class Member(faust.Record, serializer="json", validation=True):
    ember_id: Optional[int]
    photo: Optional[str]
    member_name: Optional[str]


class Event(faust.Record, serializer="json", validation=True):
    event_name: Optional[str]
    event_id: Optional[str]
    time: Optional[int]
    event_url: Optional[str]


class GroupTopic(faust.Record, serializer="json", validation=True):
    urlkey: Optional[str]
    topic_name: Optional[str]


class Group(faust.Record, serializer="json", validation=True):
    group_topics: Optional[List[GroupTopic]]
    group_city: Optional[str]
    group_country: Optional[str]
    group_id: Optional[int]
    group_name: Optional[str]
    group_lon: Optional[float]
    group_urlname: Optional[str]
    group_state: Optional[str]
    group_lat: Optional[float]


class RSVP(faust.Record, serializer="json", validation=True):
    venue: Optional[Venue]
    visibility: Optional[str]
    response: Optional[str]
    guests: Optional[int]
    member: Optional[Member]
    rsvp_id: Optional[int]
    mtime: Optional[int]
    event: Optional[Event]
    group: Optional[Group]