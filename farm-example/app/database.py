from typing import Dict, Any, List

from app.models import Todo
from motor.motor_asyncio import AsyncIOMotorClient
from motor.core import Collection


client = AsyncIOMotorClient("mongodb//localhost:27017")
database = client.TodoList
collection: Collection = database.todo


async def fetch_one_todo(title: str) -> Dict[str: Any]:
    document = await collection.find_one({"title": title})
    return document


async def fetch_all_todos() -> List[Todo]:
    todos = []

    cursor = await collection.find({})

    async for document in cursor:
        todos.append(Todo(**document))

    return todos


async def create_todo(document: Dict[str: Any]) -> Any:
    result = await collection.insert_one(document)
    return result


async def update_todo(title: str, description: str):
    await collection.update_one(
        {"title": title},
        {"$set": {"description": description}}
    )
    document = await collection.find_one({"title": title})
    return document


async def remove_todo(title: str):
    await collection.delete_one({"title": title})
    return True
