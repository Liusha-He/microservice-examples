import logging
import socket


SERVER_HOST: str = "127.0.1.1"  # host's IP address
PORT: int = 5050  # port
ADDR: tuple = (SERVER_HOST, PORT)  # combine the address with port
# make a socket
client: socket.socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
client.connect(ADDR)
HEADER: int = 64
FORMAT = "utf-8"

logging.basicConfig(level=logging.INFO)


def send(message: str):
    msg: bytes = message.encode(FORMAT)
    msg_length: int = len(msg)
    send_length: bytes = str(msg_length).encode(FORMAT)
    send_length += b" " * max(HEADER - len(send_length), 0)

    client.send(send_length)
    client.send(msg)
    logging.info(client.recv(2048).decode(FORMAT))


if __name__ == "__main__":
    send("!DISCONNECT")
