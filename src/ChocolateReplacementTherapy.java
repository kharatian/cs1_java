import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ChocolateReplacementTherapy {
   public static void main(String[] args) {
      final String PROMPT_MESSAGE= "Enter a clever noun or phrase (quit to exit): ";

      String[] chocQuotes = {"A little chocolate a day keeps the doctor at bay. - Marcia Carrington",
            "All you need is love. But a little chocolate now and then doesn't hurt. - Charles M. Schulz",
            "Anything is good if it's made of chocolate. - Jo Brand",
            "Caramels are only a fad. Chocolate is a permanent thing. - Milton Snavely Hershey",
            "Chemically speaking, chocolate really is the world's perfect food. Michael Levine",
            "Chocolate is a perfect food, as wholesome as it is delicious, a beneficent restorer of exhausted power. It is the best friend of those engaged in literary pursuits. - Justus Liebig",
            "Chocolate is medicinal. I just did another study that confirms it. - Michelle M. Pillow",
            "Chocolate is the only aromatherapy I need. - Jasmine Heiler",
            "Chocolate remedies adversity. - Jareb Teague",
            "Chocolate says 'I'm sorry' so much better than words. - Rachel Vincent",
            "Chocolate: The poor mans' champagne. - Daniel Worona",
            "Coffee and chocolate'the inventor of mocha should be sainted. - Cherise Sinclair",
            "I never met a chocolate I didn't like. - Deanna Troi",
            "If I die eating chocolate, I'll die happy. - Cailey Sims",
            "If there's no chocolate in Heaven, I'm not going. - Jane Seabrook",
            "It's strengthening, restorative, and apt to repair decayed strength and make people strong. - Louis Lemery",
            "Look, there's no metaphysics on earth like chocolates. - Fernando Pessoa",
            "My therapist told me the way to achieve true inner peace is to finish what I start. So far today, I have finished 2 bags of M&M's and a chocolate cake. I feel better already. - Dave Barry",
            "Nine out of ten people like chocolate. The tenth person always lies. - John Q. Tullius",
            "Other things are just food. But chocolate's chocolate. - Patrick Skene Catling",
            "Remember the days when you let your child have some chocolate if he finished his cereal? Now, chocolate is one of the cereals. - Robert Orben",
            "Strength is the capacity to break a Hershey bar into four pieces with your bare hands, and then eat just one of the pieces. - Judith Viorst",
            "The greatest tragedies were written by the Greeks and Shakespeare. Neither knew chocolate. - Sandra Boynton",
            "The superiority of chocolate, both for health and nourishment, will soon give it the same preference over tea and coffee in America which it has in Spain. - Thomas Jefferson",
            "There is nothing better than a friend, unless it is a friend with chocolate. - Linda Grayson",
            "What use are cartridges in battle? I always carry chocolate instead. - George Bernard Shaw",
            "What you see before you, my friend, is the result of a lifetime of chocolate. - Katharine Hepburn",
            "When we don't have the words chocolate can speak volumes. - Joan Bauer",
            "Who cares about falling in love. I'd rather fall in chocolate. - Tori Mason",
            "Your hand and your mouth agreed many years ago that, as far as chocolate is concerned, there is no need to involve your brain. - Dave Barry",
            "A little chocolate a day keeps the doctor at bay. - Marcia Carrington"};
      Scanner scnr = new Scanner(System.in);
      String outputString;
      Random random = new Random();
      int randomIndex;
      String userInput;
      boolean isQuit = false;

      while (!isQuit){
         outputString = "";
         System.out.print(PROMPT_MESSAGE);
         userInput = scnr.nextLine();

         if (userInput.compareToIgnoreCase("quit") == 0){
            isQuit = true
            continue;
         }
         randomIndex = random.nextInt(chocQuotes.length);

         outputString = String.format("\t%s\n", chocQuotes[randomIndex].replaceAll("chocolate", userInput));

         System.out.println(outputString);
      }
   }
}
