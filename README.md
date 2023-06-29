# 21 Dice Game 🎲
Another *burdensome* homework from OOP Theory class (the sigh is real). Hopefully I'll learn something useful.

## 📄 Description
Design a game as following:
* Number of players: 4 (always). If < 4 players are playing, the program will automatically added a number of players so that there are 4 of them.
* There are 4 dices. Each dice has the probability of a face of 20%, and the remaining outcomes are 16%: For dice number 1-4, the face with 1-4 dots is the one with 20% possibility.
* Each player has:
  * Name
  * Total accumulated points
  * *For virtual players*: Have different ways of expressing game over (say something nice, leave game, silently do something bad...)
* There is 1 game master who:
  * Decide who will go next;
  * Calculate the points for players:
    * If `previous turn's accumulated point` + `this turn's point` = 21: Winner. End game.
    * If `previous turn's accumulated point` + `this turn's point` > 21: Point = 0;
    * Otherwise: add points as normal
  * Announce the winner. Virtual players express their disappointment differently.
* At each player's turn, they will receive at random a dice and roll it.