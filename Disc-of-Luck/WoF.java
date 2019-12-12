import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import wofPlayer.wofPlayer; // My external package for Player objects
import updatePurse.updatePurse; // My external package for Purse Update objects

public class WoF {

    ///////////////////////     Spin the Wheel    //////////////////////////////////

	public int spinWheel() {
		 int r = (int) (Math.random()*21);
	   int wheelVal = new int [] {0,100,100,100,200,200,200,300,300,300,400,400,500,500,600,700,800,900,1000,2000,4000}[r];
	   return wheelVal;
		 }

	///////////////////////     Update Next Player    //////////////////////////////////
	// Not implemented yet...
	String Player;
	public String updatePlayer(int PlayerNum, String [] Playerz, String Player) {
		PlayerNum = PlayerNum+1;
		if (PlayerNum == 3) {
			PlayerNum = 0;
		}

		Player = Playerz[PlayerNum];
		return Player;
		}

	///////////////////////     Main    //////////////////////////////////

	public static void main(String[] args) {

		///////////////////////     declares and initialize array of words to guess    //////////////////////////////////
	    String[] words = {"chinook","hurricane","snowstorm","tornado","clipper","vorticity","geostrophic",
				"instability"};

	    ///////////////   chooses random word from the word array and creates a array of letters   ///////////////////////////
	    String word[] = (words[(int) (Math.random() * words.length)]).split("");

	    ///////////////   Makes array of size length of word (for setting dashes)   ///////////////////////////
	    String[] marks = new String[word.length];

	    //System.out.println(word);

			String puzzleWord = ""; // initialize puzzleWord

			///////////////   Changing [Ljava.lang.String into an actual string value   ///////////////////////////
			for(String str:word){
				puzzleWord += str;
			}

	    Arrays.fill(marks,"-"); // creates and fills an array with dashes
	    Scanner in  = new Scanner(System.in);

	    String letter = ""; // initialize character
	    String choice = ""; // initialize character
	    String solve;
			String Player;
	    int purseTotal1 = 0;
	    int purseTotal2 = 0;
	    int purseTotal3 = 0;
	    int thisVal;
	    int wheelVal;
	    int purseVal = 0;
	    int PlayerNum = 0;

			// -----     Initializing Player Names      -----//
			// -----   Currently based off CMD args     -----//
			String user1;
			String user2;
			String user3;

			user1 = args[0];
			user2 = args[1];
			user3 = args[2];
			// ----------------------------------------------//


			// -----   Setting up Array to take guessed letters     -----//
	    List<String> chosenLetters = new ArrayList<>();



			// -----    Create new instance of our class(?)    -----//
			// -----   This will be for spinning the wheel     -----//
			WoF spin = new WoF();
			// -----------------------------------------------------//


			// -----   Create instances from wofPlayer class (imported)    -----//
	    wofPlayer player1 = new wofPlayer(user1,0);
	    wofPlayer player2 = new wofPlayer(user2,0);
	    wofPlayer player3 = new wofPlayer(user3,0);


			// -----   Create instances from updatePurse class (imported)    -----//
	    updatePurse player1Purse = new updatePurse();
	    updatePurse player2Purse = new updatePurse();
	    updatePurse player3Purse = new updatePurse();

			// -----   Retreive their names     -----//
	    String Player1 = player1.getName();
	    String Player2 = player2.getName();
	    String Player3 = player3.getName();
			String [] Playerz = {Player1,Player2,Player3};

			// -----   Grab names of players and let player 1 (default round 1) spin first   -----//
	    System.out.println("\nLet's welcome our three players:");
    	System.out.println(Player1+ ", " + Player2 + ", and " + Player3);
    	Player = Player1;

			// -----   Start the game (round) and    -----//
			// -----   keep iterating until all the dashes (-) are flipped    -----//
	    while(Arrays.toString(marks).contains("-")) {

	    	////////////////////////////   Host's comments about who the player is     //////////////////////////////////////
	    	////////////////////////////   and give option to spin or solve     //////////////////////////////////////
	    	System.out.println("\n-------------------\n"+Player+", you're up!");
	    	wheelVal = spin.spinWheel();
				System.out.println("\nThis is your word!: " + String.join("", marks));

				System.out.println("Would you like to spin the (w)heel or (s)olve the puzzle?");

				// -----   Set character to player's choice   -----//
				choice = String.valueOf(in.next(".").charAt(0)); // need to understand better what is happening here...

				////////////////////////////    Choose to solve puzzle option    //////////////////////////////////////
				if (choice.contentEquals("s")) {
					System.out.println("Go ahead and try and solve:");

					solve = String.valueOf(in.next());

				if (solve.equals(puzzleWord)) {
					break;}
				if (!solve.equals(puzzleWord)) {
					System.out.println("Sorry, not the correct word! Next player...");

					PlayerNum = PlayerNum+1;
					if (PlayerNum == 3) {
						PlayerNum = 0;
					}
					Player = Playerz[PlayerNum];
				}
			}

			////////////////////////////  Spin the wheel option for player    //////////////////////////////////////
				if (choice.contentEquals("w")) {
					System.out.println("Wheel value: $"+wheelVal);

				// -----   Bankrupt wheel value (0)   -----//
				if (wheelVal == 0) {
					System.out.println("Lose a turn and all your cash! Next player...");

					if (PlayerNum == 0) {
						purseVal = player1Purse.updatePurse(0, 0,Player);
					}
					if (PlayerNum == 1) {
						purseVal = player2Purse.updatePurse(0, 0,Player);
					}
					if (PlayerNum == 2) {
						purseVal = player3Purse.updatePurse(0, 0,Player);
					}

					PlayerNum = PlayerNum+1;
					if (PlayerNum == 3) {
						PlayerNum = 0;
					}

					Player = Playerz[PlayerNum];
				}

				// -----   Any other wheel value other than Bankrupt   -----//
				if (wheelVal !=0) {
		        System.out.print("Guess a letter ");

		        letter = String.valueOf(in.next(".").charAt(0));

		        ////////////////////////////   If letter was already chosen    //////////////////////////////////////
		        if (chosenLetters.contains(letter) == true) {
		        	System.out.print("You must've fallen asleep, that letter has been used. Next player!\n");
		        	thisVal = 0;
		        	System.out.println("Response value: $"+thisVal);
		        	if (PlayerNum == 0) {
		        		purseVal = player1Purse.updatePurse(0, purseTotal1,Player);
					}
					if (PlayerNum == 1) {
						purseVal = player2Purse.updatePurse(0, purseTotal2,Player);
					}
					if (PlayerNum == 2) {
						purseVal = player3Purse.updatePurse(0, purseTotal3,Player);
					}
		        }

		        ////////////////////////////   If letter not already chosen    //////////////////////////////////////
				if (chosenLetters.contains(letter) == false){
					chosenLetters.add(letter);

					// -----   Check to see how many times the letter occurs and change dashes   -----//
					int j = 0; // j will hold number of times letter shows up in word (see below)
			        for (int i = 0; i < word.length; i++) {

			            if(word[i].equals(letter)){
			            	j++;
			                marks[i] = word[i]; // replace dashes with letters
			            }
			        }
			        // -----   Multiply the wheel value by number of letters in word   -----//
			        thisVal = j*wheelVal;

				// -----   This just prints out what value was recorded after the multiplier    -----//
				// -----   Can comment out/delete    -----//
				System.out.println("Response value: $"+thisVal);
				// -----   Update purse for current player if letter is in word   -----//
				if (PlayerNum == 0) {
						purseVal = player1Purse.updatePurse(thisVal, purseTotal1,Player);
						purseTotal1 = purseVal;
					}
				if (PlayerNum == 1) {
						purseVal = player2Purse.updatePurse(thisVal, purseTotal2,Player);
						purseTotal2 = purseVal;
					}
				if (PlayerNum == 2) {
						purseVal = player3Purse.updatePurse(thisVal, purseTotal3,Player);
						purseTotal3 = purseVal;
					}

				// -----   Move to next player when letter guess is not in puzzle word   -----//
				if (!puzzleWord.contains(letter)){
						System.out.println("Sorry" + Player + ", your guess isn't in the word! Next player...");
						PlayerNum = PlayerNum+1;
						if (PlayerNum == 3) {
							PlayerNum = 0;
						} // end if PlayerNum == 3 if-statement

						Player = Playerz[PlayerNum];
					} // end if letter guess isn't in puzzle word
					//-----------------------------------------------------------------------//

////////////////////////////   Show which letters have been guessed    //////////////////////////////////////

				System.out.println(chosenLetters);

		    } // end if letter hasn't been chosen already statement
		  } // if wheel value isn't zero statement
		} // end if choose to spin wheel statement
	 } // end while-loop


	    System.out.print("\nPuzzle word: "+puzzleWord);

	    System.out.println("\nCongrats "+Player+"! You nailed it!\n");


////////////////////////////    Clear the purses of the players who didn't solve the puzzle    //////////////////////////////////////

	  if (PlayerNum == 0) {
			player1Purse.updatePurse(0, purseTotal1,Player);
			player2Purse.updatePurse(0, 0,Player2);
			player3Purse.updatePurse(0, 0,Player3);
		}
		if (PlayerNum == 1) {
			player2Purse.updatePurse(0, purseTotal2,Player);
			player1Purse.updatePurse(0, 0,Player1);
			player3Purse.updatePurse(0, 0,Player3);
		}
		if (PlayerNum == 2) {
			player3Purse.updatePurse(0, purseTotal3,Player);
			player1Purse.updatePurse(0, 0,Player1);
			player2Purse.updatePurse(0, 0,Player2);
		}


	} // end main
} // end WoF class
