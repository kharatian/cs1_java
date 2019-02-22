import java.util.ArrayList;
import java.util.Scanner;

public class PlayGround {
   private static int statInt = 1010;

   public static void main(String[] args) {

      ShoppingCart shopCart = new ShoppingCart();

      ItemToPurchase it1 = new ItemToPurchase();
      ItemToPurchase it2 = new ItemToPurchase();
      ItemToPurchase it3 = new ItemToPurchase();
      ItemToPurchase it4 = new ItemToPurchase();
      ItemToPurchase it5 = new ItemToPurchase();

      it1.setName("Item 1 name");
      it2.setName("Item 2 name");
      it3.setName("Item 3 name");
      it4.setName("Item 4 name");
      it5.setName("Item 5 name");

      it1.setPrice(1);
      it2.setPrice(2);
      it3.setPrice(3);
      it4.setPrice(4);

      it1.setQuantity(1);
      it2.setQuantity(2);
      it3.setQuantity(3);
      it4.setQuantity(4);

      it1.setDescription("decriptive description of item 1");
      it2.setDescription("decriptive description of item 2");
      it3.setDescription("decriptive description of item 3");
      it4.setDescription("decriptive description of item 4");

      shopCart.addItem(it1);
      shopCart.addItem(it2);
      shopCart.addItem(it3);
      shopCart.addItem(it4);
      shopCart.addItem(it5);

      it2.setName(it1.getName());

      it5.setName(it1.getName());

      System.out.printf("Item 1 before changing:\n");
      shopCart.printItemData(0);
      shopCart.modifyItem(it5);
      System.out.println("\nAfter Changing: \n");
      shopCart.printItemData(0);

      System.out.println(shopCart.getNumItemsInCart());
      System.out.println(shopCart.getCostOfCart());
      shopCart.printTotal();
      shopCart.printDescriptions();

   }
   public static void arrChange(ArrayList<Integer> arr, int toAdd) {
      arr.add(toAdd);
      statInt++;
   }

   public String parser(String toParse, String s) {
      return "returned stuff!";
   }

   public static void print(String toPrint){
      System.out.println(toPrint);
   }
}


