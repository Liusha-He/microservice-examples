import uvicorn
from fastapi import FastAPI
from fastapi.middleware.cors import CORSMiddleware

from src.v1.routes import router as TodoRouter

app = FastAPI()
origins = [
    "http://0.0.0.0:3000",
    "http://localhost:3000",
]
prefix = "/v1/api"

app.add_middleware(
    CORSMiddleware,
    allow_origins=origins,
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"]
)

app.include_router(router=TodoRouter,
                   prefix=prefix,
                   tags=["todo"])


@app.get("/", tags=["Root"])
def root():
    return {"Ping": "Pong"}


if __name__ == '__main__':
    uvicorn.run(app, debug=True, host="0.0.0.0", port=8080)
