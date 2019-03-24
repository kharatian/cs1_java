import java.util.Scanner;
import java.util.Random;

/**
 * Player class for mastermind game. This class sets the secret word from a
 * MMWords object and allows players to guess the secret word while giving
 * feedback on potentially correct character guesses and keeping track of
 * number of guesses
 *
 * @author Arthur Kharatian
 * @version 1.0
 */

public class Player {
   private String secretWord;
   private int numGuesses;
   private MMWords words;

   /**
    * Default constructor calls method resetPlayer which will reset numGuesses
    * and secret word
    */
   public Player() {
      words = new MMWords();
      this.resetPlayer();
   }

   public int getNumGuesses() {
      return this.numGuesses;
   }

   /**
    * This resets the player and in order to begin a new game
    *
    * reset numGuesses to 0
    * get random secretWord from MMWords instance words and store in all lower
    * case
    */
   public void resetPlayer(){
      this.numGuesses = 0;
      this.secretWord = words.getRandomWord().toLowerCase();
   }

   public void incrementNumGuesses() {
      ++numGuesses;
   }

   /**
    * Method for verifying user guess of member field secretWord is correct
    *
    * @param userGuess the guess that needs to be checked against member field
    *                  secret word
    * @return a String representation of the how correct the guess was:
    *          - * for each correct character in the correct position
    *          - - for each correct character in wrong position
    *          - otherwise space. If none of the characters are in secretWord
    *            then return "You got nothing. Sorry."
    */
   public String checkGuess(String userGuess) {
      String guessStatus = "";
      String stars = "";
      String dash = "";
      String space = "";

      // the game is not case sensitive
      userGuess = userGuess.toLowerCase();
      char[] secretWordArray = this.secretWord.toCharArray();
      char[] guessArray = userGuess.toCharArray();

      for (int i = 0; i < this.secretWord.length(); ++i) {
         if (secretWordArray[i] == guessArray[i]){
               stars += "*";
         }
         else if (this.secretWord.contains("" + guessArray[i])) {
            dash += "-";
         }
         else {
            space += " ";
         }
      }

      guessStatus = stars + dash + space;
      if (guessStatus.compareTo("    ") == 0) {
         guessStatus = "You got nothing. Sorry.";
      }
      this.incrementNumGuesses();
      return guessStatus;
   }

}
