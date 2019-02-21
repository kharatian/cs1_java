import java.util.Scanner;

public class ShoppingCartPrinter {
   public static void main(String[] args){
      Scanner scnr = new Scanner(System.in);
      ItemToPurchase firstItem = new ItemToPurchase();
      ItemToPurchase secondItem = new ItemToPurchase();
      int totalForCart = 0;
      int totalForItem;

      ItemToPurchase[] arrayOfITP = {firstItem, secondItem};

      for(int i = 0; i < arrayOfITP.length; ++i) {
         System.out.println("Item " + (i+1));
         System.out.println("Enter the item name:");
         arrayOfITP[i].setName(scnr.nextLine());
         System.out.println("Enter the item price:");
         arrayOfITP[i].setPrice(scnr.nextInt());
         System.out.println("Enter the item quantity:");
         arrayOfITP[i].setQuantity(scnr.nextInt());
         if(scnr.hasNextLine()) scnr.nextLine();
         System.out.println();
      }

      System.out.println("TOTAL COST");
      for(int i = 0; i < arrayOfITP.length; ++i) {
         totalForItem = arrayOfITP[i].getPrice() * arrayOfITP[i].getQuantity();
         totalForCart += totalForItem;
         System.out.printf("%s %d @ $%d = $%d\n", arrayOfITP[i].getName(),
                                                    arrayOfITP[i].getQuantity(),
                                                    arrayOfITP[i].getPrice(),
                                                    totalForItem);
      }
      System.out.println();
      System.out.printf("Total: $%d\n", totalForCart);

      firstItem.setDescription("newly minted description describing the descriptive item");

      firstItem.printItemCost();
      firstItem.printItemDescription();
   }
}