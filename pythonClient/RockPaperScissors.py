


def main():
    instructions()
    openSocket()
    while(True):
        print "Enter an action:",
        action = raw_input()
        response = sendAction()
        print response

if __name__ == '__main__':
    main()