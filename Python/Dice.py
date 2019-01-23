import random

print("~~Welcome to Dice Simulator.~~\n" + (' '*4),"(Type \"Q\" to quit.)\n")
die = ""
sides = None
face_up = None

while die != "Q":
    die = input("Choose a die:\n|||D6, D10, D20|||\n").title()
    print()
      
    if die == "D6" or die == "6":
        sides = list(range(1,7))
        face_up = random.choice(sides)
        print("Rolled a %s." % face_up)
        print()
            
    elif die == "D10" or die == "10":
        sides = list(range(1,11))
        face_up = random.choice(sides)
        print("Rolled a %s." % face_up)
        print()
            
    elif die == "D20" or die == "20":
        sides = list(range(1,21))
        face_up = random.choice(sides)
        print("Rolled a %s." % face_up)
        print()

    

