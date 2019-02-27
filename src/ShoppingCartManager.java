import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingCartManager {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      String userMenuChoice = ""; //set empty string to use for first while loop
      String customerName = getUserInputString(scnr, "Enter Customer's Name:");
      String currDate = getUserInputString(scnr, "Enter Today's Date:");
      ShoppingCart shoppingCart = new ShoppingCart(customerName, currDate);
      System.out.printf("\nCustomer Name: %s\n" +
                         "Today's Date: %s\n", shoppingCart.getCustomerName(),
                         shoppingCart.getDate());

      while (userMenuChoice.compareTo("q") != 0) {
         userMenuChoice = printMenu(scnr);

      switch (userMenuChoice) {
         case "q":
            break;
         case "a":
            System.out.println("ADD ITEM TO CART");
            String name = getUserInputString(scnr, "Enter the item name:");
            String description = getUserInputString(scnr, "Enter the item description:");
            int price = getUserInputInt(scnr, "Enter the item price:");
            int quantity = getUserInputInt(scnr, "Enter the item quantity:");
            ItemToPurchase newItem = new ItemToPurchase(name, description, price, quantity);
            shoppingCart.addItem(newItem);
            break;
         case "d":
            System.out.println("REMOVE ITEM FROM CART");
            name = getUserInputString(scnr, "Enter name of item to remove:");
            shoppingCart.removeItem(name);
            break;
         case "c":
            System.out.println("CHANGE ITEM QUANTITY");
            ItemToPurchase newITP = new ItemToPurchase();
            name = getUserInputString(scnr, "Enter the item name:");
            quantity = getUserInputInt(scnr, "Enter the new quantity:");
            newITP.setName(name);
            newITP.setQuantity(quantity);
            shoppingCart.modifyItem(newITP);
            break;
         case "o":
            System.out.println("OUTPUT SHOPPING CART");
            shoppingCart.printTotal();
            break;
         case "i":
            System.out.println("OUTPUT ITEMS' DESCRIPTIONS");
            shoppingCart.printDescriptions();
            break;
         }
      }
   }

   private static String getUserInputString(Scanner scnr, String promptMessage){
      String retString;
      System.out.println(promptMessage);
      retString = scnr.nextLine();

      return retString;
   }

   private static int getUserInputInt(Scanner scnr, String promptMessage){
      int retInt;
      String inputString;
      System.out.println(promptMessage);
      inputString = scnr.nextLine();
      retInt = Integer.parseInt(inputString);

      return retInt;
   }

   private static boolean isValidMenuChoice(String strToCheck) {
      boolean isValid;
      String legalChars = "adcioq";

      strToCheck = strToCheck.toLowerCase();

      isValid = legalChars.contains(strToCheck);

      return isValid;
   }

   // print a menu of possible operations and get users input
   public static String printMenu(Scanner scnr) {
      String userChoice = "-";
      String menuText = "\nMENU\n" +
            "a - Add item to cart\n" +
            "d - Remove item from cart\n" +
            "c - Change item quantity\n" +
            "i - Output items' descriptions\n" +
            "o - Output shopping cart\n" +
            "q - Quit\n";

      System.out.println(menuText);

      while (!isValidMenuChoice(userChoice)){
         userChoice = "";
         System.out.println("Choose an option:");
         userChoice += scnr.nextLine().charAt(0);
      }

      return userChoice;
   }
}