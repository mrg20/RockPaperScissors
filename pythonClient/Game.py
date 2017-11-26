# -*- coding: utf-8 -*-

from __future__ import print_function


class Game:
    def __init__(self):
        self.actions = {
            "Rock": "1",
            "Paper": "2",
            "Scissors": "3",
            "Roca": "1",
            "Paper": "2",
            "Tisores": "3",
            "Piedra": "1",
            "Papel": "2",
            "Tijeras": "3"
        }

    def instructions(self):
        print("This is the rock, paper, scissors game.")
        print("The server must be open if you want to play.")
        print("Just type the option that you want and have fun :)")

    def process_action(self, action):
        return self.actions[action]

    def notify_result(self, response):
        print ("The result is: ", response)
