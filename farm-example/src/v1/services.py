from typing import Dict, List, Any

from src.v1.database import todo_collection
from src.v1.models import Todo


async def fetch_one_todo(title: str) -> Todo:
    document = await todo_collection.find_one(
        {"title": title}
    )
    return Todo(**document)


async def fetch_all_todos() -> List[Todo]:
    todos = []

    cursor = todo_collection.find({})

    async for document in cursor:
        todos.append(Todo(**document))

    return todos


async def create_todo(document: dict) -> Any:
    result = await todo_collection.insert_one(document)
    return result


async def update_todo(title: str, description: str):
    await todo_collection.update_one(
        {"title": title},
        {"$set": {"description": description}}
    )
    document = await todo_collection.find_one({"title": title})
    return document


async def remove_todo(title: str):
    await todo_collection.delete_one({"title": title})
    return True