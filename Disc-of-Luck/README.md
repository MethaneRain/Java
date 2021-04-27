Welcome to my beginners Java knock-off of Wheel of Fortune!

It's a pretty simple, in the command line run:
```java WoF.java name1 name2 name3```

This will initiate the game in the terminal with 3 players. There will be crude instructions for each player as to what their choices are. The puzzles are different atmospheric phenomena, give it a try and hope you have some fun!

The game keeps track of the players purse values via ```updatePurse``` class. After a guess, the game displays the wheel value, response value (total earned from number of letters x wheel value), and the players purse.

There are plenty of bugs that are known:
<ul>
<li>A vowel can be called without buying it, cheating!</li>
<li>If all letters are guessed without solving, the puzzle automatically ends and that player wins</li>
<li>The game terminates when the puzzle is solved, need to have it keep generating a new game until player quits</li>
</ul>
