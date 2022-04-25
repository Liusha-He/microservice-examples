from typing import List

from pydantic import BaseModel


class APIRequest(BaseModel):
    query_string: str


class APIResponse(BaseModel):
    entities: List[str]
