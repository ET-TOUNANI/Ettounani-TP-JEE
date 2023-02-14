import socket

def receive_message(socket):
    data = socket.recv(1024).decode("utf-8")
    print("Received message: " + data)

def send_message(socket):
    message = input("Enter message: ")
    socket.sendall(message.encode("utf-8"))

def main():
    client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    client_socket.connect(("localhost", 2001))

    receive_thread = threading.Thread(target=receive_message, args=(client_socket,))
    receive_thread.start()

    while True:
        send_message(client_socket)

if __name__ == "__main__":
    main()
