# GameWord
## The Task
Create a single player “Guess the word” game against the computer 

* At the start of the game the computer should pick a random word from a predetermined list. The word should be shown to the user but with all letters blanked out with an asterix 

* The user should be prompted to enter a letter (don’t worry too much about capturing the user input - think about how this can be generalised) 
* The user gets feedback if they have correctly guessed a letter from the word 
* If they have then the word is shown with all letters correctly guessed so far, all other letters are blanked out with an asterix 
* If they get it wrong then they lose a life 
* The game then continues with the user continuing to guess letters until ○ They guess the entire word and win the game 
* They run out of lives and the computer wins the game. The number of lives can be hard coded 

#### Possible Example Output:**
- Word list:
- [apple,dog,cat,book]
- User interaction:
- Guess the word: ****
- z
- Incorrect 1 life lost. 4 remaining. The current word is ****
- o
- Correct. *oo*
- k
- Correct. *ook
- z
- You have already tried this letter
- b
- You have won the game. The word was ‘book’.
- Guess the word *****
