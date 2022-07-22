from .binding_example import sum_as_string

__all__ = [
    "add",
    "sum_as_string",
]


def add(a: int, b: int) -> int:
    return a + b
