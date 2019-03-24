import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * class reads a text and stores each line in a string array. Input file should
 * have just 1 word per line. This will be used as the source for the secret
 * word of a Mastermind game
 *
 * @author Arthur Kharatian
 * @version 1.0
 */
public class MMWords {
   private String[] arrayWords;

   /**
    * default constructor uses uses 'words.txt' as the default path to file
    */
   public MMWords() {
      this.fileToArray("words.txt");
   }

   /**
    * constructor that  that allows for custom path to source file
    *
    * @param pathName path to file with words to be loaded into array words
    */
   public MMWords(String pathName) {
      fileToArray(pathName);
   }

   /**
    * method that reads file at pathName and adds each line to an ArrayList
    * which is then converted to a string array
    *
    * @param pathName path to file with words to be loaded into array words
    */
   private void fileToArray(String pathName){
      try {
         File file = new File(pathName);
         ArrayList<String> listWords = new ArrayList<>();
         Scanner scnrFile = new Scanner(file);

         while (scnrFile.hasNextLine()) {
            listWords.add(scnrFile.nextLine());
         }
         this.arrayWords = new String[listWords.size()];
         arrayWords = listWords.toArray(arrayWords);
      }
      catch (FileNotFoundException e) {
         System.out.println(e);
      }
   }

   /**
    * method for returning a random word from the member field arrayWords
    *
    * @return a String which is a randomly chosen element in arrayWords
    */
   public String getRandomWord(){
      Random rand = new Random();
      int randIndex = rand.nextInt(this.arrayWords.length);
      return this.arrayWords[randIndex];
   }
}