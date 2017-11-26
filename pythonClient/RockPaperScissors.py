# -*- coding: utf-8 -*-

from __future__ import print_function
import socket
import gettext
from Game import Game


class Client:
    def open_socket(self):
        self.service_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        self.service_socket.connect(('localhost', 9000))

    def send_action(self, data):
        self.service_socket.sendall(data + "\n")
        received_data = self.service_socket.recv(512)
        return received_data


if __name__ == '__main__':
    gettext.install(domain='RockPaperScissors', localedir='locales')

    client = Client()
    game = Game()
    game.instructions()
    client.open_socket()
    while (True):
        print _("Enter one option (Rock, Paper, or Scissors):")
        action = raw_input()
        info_to_send = game.process_action(action)
        response = client.send_action(info_to_send)
        game.notify_result(response)
