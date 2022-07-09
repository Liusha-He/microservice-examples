import uvicorn
from fastapi import FastAPI, HTTPException
from fastapi.middleware.cors import CORSMiddleware

from app.database import (create_todo,
                          update_todo,
                          remove_todo,
                          fetch_one_todo,
                          fetch_all_todos)
from app.models import Todo

app = FastAPI()
origins = ["http://localhost:3000"]

app.add_middleware(
    CORSMiddleware,
    allow_origins=origins,
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"]
)


@app.get("/")
def root():
    return {"Ping": "Pong"}


@app.get("/api/todo")
async def get_todo():
    return await fetch_all_todos()


@app.get("/api/todo/{title}", response_model=Todo)
async def get_todo_by_id(title: str):
    return await fetch_one_todo(title)


@app.post("/api/todo", response_model=Todo)
async def post_todo(todo: Todo):
    response = await create_todo(todo.dict())
    if response:
        return response
    raise HTTPException(400, "Something went wrong")


@app.put("/api/todo/{title}", response_model=Todo)
async def update_todo(title: str, description: str):
    response = await update_todo(title, description)

    if response:
        return response
    raise HTTPException(404, "Something went wrong")


@app.delete("/api/todo/{title}")
async def delete_todo(title: str):
    response = await remove_todo(title)
    if response:
        return "success"
    raise HTTPException(404, f"there is not item with title {title}")


if __name__ == '__main__':
    uvicorn.run(app, debug=True)
