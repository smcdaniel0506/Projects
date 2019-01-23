"""

RPS GAME WITH BEST OF THREE, SCORE REMINDER, AND REMATCH OPTION

"""

import random


moves = ["Rock", "Paper", "Scissors"]


"""
THE GAME LOOP
FIXME: THERE COULD BE A BETTER WAY TO CUT DOWN ON CODE USAGE
"""

ai_win_count = 0
player_win_count = 0

"""
THE GAME STARTS WITH BOTH SCORES AT 0.
Bo5 SET, FIRST TO 3 WINS
"""
while player_win_count <= 3 and ai_win_count <= 3:

    if player_win_count == 3 or ai_win_count == 3:

        if player_win_count == 3:
            print("You've won the Best of Five!")
            rematch_str = input("Rematch? (Y / N)\n").title()

            if rematch_str == "Y" or rematch_str == "y":
                ai_win_count = 0
                player_win_count = 0
                continue

            else:
                print("Thanks for playing!")
                break

        elif ai_win_count == 3:
            print("Better luck next time.")
            rematch_str = input("Rematch? (Y / N)\n").title()

            if rematch_str == "Y" or rematch_str == "y":
                ai_win_count = 0
                player_win_count = 0
                continue

            else:
                print("Thanks for playing!")
                break

    elif player_win_count < 3 and ai_win_count < 3:
        player_move = input("Best of Three! Rock, Paper, Scissors!\n").title()
        print()
        print("You chose:", player_move)
        print()

        if player_move == "Rock":
            ai_choice = random.choice(moves)

            if ai_choice == moves[0]:
                print("I chose:", ai_choice)
                print()
                print("It's a Draw")
                print()

            elif ai_choice == moves[1]:
                print("I chose:", ai_choice)
                print()
                print("You Lose this round")
                print()
                ai_win_count += 1

            elif ai_choice == moves[2]:
                print("I chose:", ai_choice)
                print()
                print("You Win this round")
                print()
                player_win_count += 1

            print("Score is:\nYou:", player_win_count, "\nRPS King:", ai_win_count)
            print()

        if player_move == "Paper":
            ai_choice = random.choice(moves)

            if ai_choice == moves[0]:
                print("I chose:", ai_choice)
                print()
                print("You Win this round")
                print()
                player_win_count += 1

            elif ai_choice == moves[1]:
                print("I chose:", ai_choice)
                print()
                print("It's a Draw")
                print()

            elif ai_choice == moves[2]:
                print("I chose:", ai_choice)
                print()
                print("You Lose this round")
                print()
                ai_win_count += 1

            print("Score is:\nYou:", player_win_count, "\nRPS King:", ai_win_count)
            print()

        if player_move == "Scissors":
            ai_choice = random.choice(moves)

            if ai_choice == moves[1]:
                print("I chose:", ai_choice)
                print()
                print("You Win this round")
                print()
                player_win_count += 1

            elif ai_choice == moves[0]:
                print("I chose:", ai_choice)
                print()
                print("You Lose this round.")
                print()
                ai_win_count += 1

            elif ai_choice == moves[2]:
                print("I chose:", ai_choice)
                print()
                print("It's a Draw")
                print()

            print("Score is:\nYou:", player_win_count, "\nRPS King:", ai_win_count)
            print()
