import java.util.ArrayList;

public class ShoppingCart {
   final private String DEFAULT_CUST_NAME = "none";
   final private String DEFAULT_CUR_DATE = "January 1, 2016";

   private String customerName;
   private String currentDate;
   private ArrayList<ItemToPurchase> cartItems = new ArrayList<>();

   public void ShoppingCardManager() {
      this.customerName = DEFAULT_CUST_NAME;
      this.currentDate = DEFAULT_CUR_DATE;
   }

   public void ShoppingCardManager(String customerName, String currentDate) {
      this.customerName = customerName;
      this.currentDate = currentDate;
   }

   // accessors
   public String getCustomerName() {
      return this.customerName;
   }

   public String getDate() {
      return this.currentDate;
   }

   // Adds an item to cartItems array.
   // @param ItemToPurchase.
   // Does not return anything.
   public void addItem(ItemToPurchase itemToAdd) {
      this.cartItems.add(itemToAdd);
   }

   // Removes item from cartItems array. Has a string (an item's name) parameter.
   // Does not return anything. If item name cannot be found, output this
   // message: Item not found in cart. Nothing removed.
   public void removeItem(String itemName) {
      boolean itemFound = false;
      int i = 0;

      while (!itemFound) {

         if (this.cartItems.get(i).getName().compareTo(itemName) == 0) {
            this.cartItems.remove(i);
            itemFound = true;
         }

         ++i;
      }

      if (!itemFound) {
         System.out.println("Item not found in cart. Nothing removed.");
      }
   }


   public void modifyItem(ItemToPurchase itemToChange) {
      boolean itemFound = false;
      String currentItemName;
      String toChangeItemName = itemToChange.getName();
      int i = 0;

      while (!itemFound) {
         currentItemName = this.cartItems.get(i).getName();
         if (currentItemName.compareTo(toChangeItemName) == 0) {
            if (itemToChange.getPrice() != 0) {
               this.cartItems.get(i).setPrice(itemToChange.getPrice());
            }
            if (itemToChange.getQuantity() != 0) {
               this.cartItems.get(i).setQuantity(itemToChange.getQuantity());
            }
            if (itemToChange.getDescription().compareToIgnoreCase("none") != 0) {
               this.cartItems.get(i).setDescription(itemToChange.getDescription());
            }
            itemFound = true;
         }
         ++i;
      }

      if (!itemFound) {
         System.out.println("Item not found in cart. Nothing modified.");
      }
   }

   public void printItemData(int itemNum) {
      ItemToPurchase itemToPrint = this.cartItems.get(itemNum);
      System.out.printf("Item %d:\n%s\n%s\n%d\n%d\n",
            itemNum,
            itemToPrint.getName(),
            itemToPrint.getDescription(),
            itemToPrint.getPrice(),
            itemToPrint.getQuantity());
   }

   // Returns quantity of all items in cart. Has no parameters
   // @return int
   public int getNumItemsInCart() {return this.cartItems.size();}

   // Determines and returns the total cost of items in cart. Has no parameters.
   // @return int
   public int getCostOfCart(){
      int totalCost = 0;

      for (ItemToPurchase itp: this.cartItems) {
         totalCost += itp.getPrice();
      }

      return totalCost;
   }

   // Outputs total of objects in cart.
   // If cart is empty, output this message: SHOPPING CART IS EMPTY
   public void printTotal() {

      String stringToPrint = String.format(
            "%s's Shopping Cart - %s\n" +
            "Number of Items: %d\n\n", this.customerName, this.currentDate,
            this.getNumItemsInCart());

      for (ItemToPurchase item: this.cartItems) {
         stringToPrint += String.format("%s %d @ %d = $%d\n", item.getName(),
                                                            item.getQuantity(),
                                                            item.getPrice(),
                                                            item.getTotal());
      }
      System.out.print(stringToPrint);
   }

   // Outputs each item's description.
   public void printDescriptions() {
      String stringToPrint = String.format(
            "%s's Shopping Cart - %s\n\n", this.customerName, this.currentDate);

      stringToPrint += "Item Descriptions\n";

      for (ItemToPurchase item : this.cartItems) {
         stringToPrint += String.format("%s\n", item.getDescription());
      }

      System.out.println(stringToPrint);
   }
}
