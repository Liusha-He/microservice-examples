import logging
import socket
import threading


HOST: str = socket.gethostbyname(socket.gethostname())  # host's IP address
PORT: int = 5050  # port
ADDR: tuple = (HOST, PORT)  # combine the address with port
# make a socket
my_socket: socket.socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
my_socket.bind(ADDR)
HEADER: int = 64
FORMAT = "utf-8"
DISCONNECT_MESSAGE = "!DISCONNECT"

logging.basicConfig(level=logging.INFO)


def handle_client(conn, addr):
    logging.info(f"[NEW CONNECTION] {addr} connected.")
    connected = True
    while connected:
        msg_length = conn.recv(HEADER).decode(FORMAT)
        if msg_length:
            msg = conn.recv(int(msg_length)).decode(FORMAT)
            if msg == DISCONNECT_MESSAGE:
                connected = False
            logging.info(f"[{addr}] {msg}")

            conn.send("received".encode(FORMAT))

    conn.close()


def start() -> None:
    my_socket.listen()
    logging.info(f"[LISTENING] Server is listening on {HOST}")
    while True:
        conn, addr = my_socket.accept()
        thread = threading.Thread(target=handle_client, args=(conn, addr))
        thread.start()
        logging.info(
            f"[ACTIVE CONNECTING] {threading.active_count() - 1}"
        )  # todo: use logging


if __name__ == "__main__":
    logging.info("[STARTING] server is starting...")
    start()
