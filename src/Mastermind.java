import java.util.Scanner;


/**
 * class for playing a game of Mastermind! This will initialize a Player object
 * as player 1 with the secret word so player 2 can try to guess the word.
 *
 * @author Arhtur Kharatian
 * @version 1.0
 */
public class Mastermind {

   public static void main(String[] args) {
      String introPrompt = "Computer: * means one of the letters is right and" +
            " in the right place\n" +
            "Computer: - means one of the letters is right and in the wrong " +
            "place\n" +
            "Computer: -\n";
      String userGuess;
      String guessResult;
      Scanner scnr = new Scanner(System.in);
      Player p1 = new Player();

      System.out.println(introPrompt);
      while (true) {
         System.out.print("Player, what's your guess (q to quit): ");
         userGuess = scnr.nextLine();
         if (userGuess.compareTo("q") == 0){
            System.out.println("You give up so easy! Till next time :)");
            break;
         }
         if (userGuess.length() != 4) {
            System.out.println("Your guess has to be 4 chars long. Try again.");
            continue;
         }
         guessResult = p1.checkGuess(userGuess);
         if (guessResult.compareTo("****") == 0){
            System.out.printf("Computer: You got it! %d tries.\n\n",
                              p1.getNumGuesses());
            System.out.println("Player another game? y/n ");
            char playNewGame = scnr.nextLine().charAt(0);
            if (playNewGame == 'y') {
               p1.resetPlayer();
            }
            else {
               System.out.println("gg/gl");
               break;
            }
            continue;
         }
         System.out.println("Computer: " + guessResult);
      }
   }
}
