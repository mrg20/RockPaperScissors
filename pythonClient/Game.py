# -*- coding: utf-8 -*-

import gettext

class Game:
    def __init__(self):
        self.actions = {
            "Rock": "1",
            "Paper": "2",
            "Scissors": "3",
            "Pedra": "1",
            "Tisores": "3",
            "Piedra": "1",
            "Papel": "2",
            "Tijeras": "3"
        }
        self.result = {
            "0": _("YOU WIN THIS TIME"),
            "1": _("DRAFT, USED THE SAME ACTIONS"),
            "2": _("YOU LOSE, THIS AI IS POWERFUL")
        }

    def instructions(self):
        print _("This is the rock, paper, scissors game.")
        print _("The server must be open if you want to play.")
        print _("Just type the option that you want and have fun :)")

    def process_action(self, action):
        return self.actions[action]

    def notify_result(self, server_response):
        print _("The result is: "), self.result[server_response]
