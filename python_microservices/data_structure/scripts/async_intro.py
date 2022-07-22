import asyncio
import time
from concurrent.futures import as_completed
from concurrent.futures.thread import ThreadPoolExecutor
from types import SimpleNamespace
from typing import Callable, List

import aiohttp
import requests


durations = []


def timed(func: Callable):
    """
    records approximate durations of function calls
    """

    def wrapper(*args, **kwargs):
        start = time.time()
        print(f"{func.__name__:<30} started")
        result = func(*args, **kwargs)
        duration = f"{func.__name__:<30} finished in {time.time() - start:.2f} seconds"
        print(duration)
        durations.append(duration)
        return result

    return wrapper


async def fetch(url: str, session: aiohttp.ClientSession):
    """
    asynchronous get request
    """
    async with session.get(url) as response:
        response_json = await response.json()
        return SimpleNamespace(**response_json)


async def fetch_many(loop: asyncio.AbstractEventLoop, urls: List[str]):
    """
    many asynchronous get requests, gathered
    """
    async with aiohttp.ClientSession() as session:
        tasks = [loop.create_task(fetch(url, session)) for url in urls]
        return await asyncio.gather(*tasks)


@timed
def sync_requests_get_all(urls: List[str]):
    """
    performs synchronous get requests
    """
    # use session to reduce network overhead
    session = requests.Session()
    return [SimpleNamespace(**session.get(url).json()) for url in urls]


@timed
def sync_threads_get_all(urls: List[str]):
    session = requests.Session()

    def featch(url: str) -> requests.Response:
        return session.get(url)

    with ThreadPoolExecutor() as executor:
        futures = []
        for url in urls:
            futures.append(executor.submit(featch, url))

        return [
            SimpleNamespace(**task.result().json()) for task in as_completed(futures)
        ]


@timed
def async_requests_get_all(urls: List[str]):
    """
    asynchronous wrapper around synchronous requests
    """
    loop = asyncio.get_event_loop()
    # use session to reduce network overhead
    session = requests.Session()

    async def async_get(url):
        return session.get(url)

    async_tasks = [loop.create_task(async_get(url)) for url in urls]
    return loop.run_until_complete(asyncio.gather(*async_tasks))


@timed
def asnyc_aiohttp_get_all(urls: List[str]):
    """
    performs asynchronous get requests
    """
    loop = asyncio.get_event_loop()
    return loop.run_until_complete(fetch_many(loop, urls))


if __name__ == "__main__":
    urls = ["https://postman-echo.com/delay/3"] * 10

    sync_requests_get_all(urls)
    sync_threads_get_all(urls)
    async_requests_get_all(urls)
    asnyc_aiohttp_get_all(urls)
    print("----------------------")
    [print(duration) for duration in durations]

    print(SimpleNamespace(**{"a": 1, "b": 2}))
