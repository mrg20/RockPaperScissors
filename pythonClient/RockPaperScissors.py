
def open_socket():
    service_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    service_socket.connect(('localhost', 9000))

def main():
    instructions()
    open_socket()
    while(True):
        print "Enter an action:",
        action = raw_input()
        response = send_action()
        print response

if __name__ == '__main__':
    main()
