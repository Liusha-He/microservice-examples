from fastapi import APIRouter, HTTPException, Body
from fastapi.encoders import jsonable_encoder

from src.v1.models import Todo
from src.v1.services import (create_todo,
                             update_todo,
                             remove_todo,
                             fetch_one_todo,
                             fetch_all_todos)

router = APIRouter()


@router.post("/todo",
             response_model=Todo,
             response_description="Create a todo item")
async def create_todo(todo: Todo = Body(...)):
    todo_item = jsonable_encoder(todo)
    response = await create_todo(todo_item)
    if response:
        return response
    raise HTTPException(400, "Something went wrong")


@router.get("/todo",
            response_description="Get all todo items.")
async def get_todo():
    return await fetch_all_todos()


@router.get("/todo/{title}", response_model=Todo,
            response_description="Find todo items by id")
async def get_todo_by_id(title: str):
    return await fetch_one_todo(title)


@router.put("/todo/{title}", response_model=Todo,
            response_description="update a todo item")
async def update_todo(title: str, description: str):
    response = await update_todo(title, description)

    if response:
        return response
    raise HTTPException(404, "Something went wrong")


@router.delete("/todo/{title}",
               response_description="delete an item")
async def delete_todo(title: str):
    response = await remove_todo(title)
    if response:
        return "success"
    raise HTTPException(404, f"there is not item with title {title}")
