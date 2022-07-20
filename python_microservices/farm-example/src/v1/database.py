from motor.core import Collection
from motor.motor_asyncio import AsyncIOMotorClient

client = AsyncIOMotorClient("mongodb://root:secret@mongodb:27017/")
db = client["TodoList"]
todo_collection: Collection = db["todo"]
