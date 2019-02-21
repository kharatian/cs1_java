import java.util.ArrayList;

public class ShoppingCardManager {
   final private String DEFAULT_CUST_NAME = "none";
   final private String DEFAULT_CUR_DATE = "January 1, 2016";

   private String customerName; - Initialized in default constructor to "none"
   private String currentDate; tialized in default constructor to "January 1, 2016"
   private ArrayList<ItemToPurchase> cartItems;

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
   // Adds an item to cartItems array. Has parameter ItemToPurchase.
   // Does not return anything.
   public void addItem(ItemToPurchase toPurchase) {
      this.cartItems.add(toPurchase);
   }
   // Removes item from cartItems array. Has a string (an item's name) parameter.
   // Does not return anything. If item name cannot be found, output this
   // message: Item not found in cart. Nothing removed.
   public void removeItem(String itemName) {
      boolean itemFound = false;
      int i = 0;

      while (!itemFound) {
         String str = "";

         if (cartItems.get(i).getName().compareTo(itemName){
            cartItems.remove(i);
            itemFound = true;
         }

         ++i;
      }

      if (!itemFound) {
         System.out.println("Item not found in cart. Nothing removed.");
      }
   }


   // modifyItem()


   /**
 * Public member methods
 *
 * addItem()
 *
 * Adds an item to cartItems array. Has parameter ItemToPurchase. Does not return anything.
 * removeItem()
 *
 * Removes item from cartItems array. Has a string (an item's name) parameter. Does not return anything.
 * If item name cannot be found, output this message: Item not found in cart. Nothing removed.
 * modifyItem()
 *
 * Modifies an item's description, price, and/or quantity. Has parameter ItemToPurchase. Does not return anything.
 * If item can be found (by name) in cart, check if parameter has default values for description, price, and quantity. If not, modify item in cart.
 * If item cannot be found (by name) in cart, output this message: Item not found in cart. Nothing modified.
 * getNumItemsInCart() (2 pts)
 *
 * Returns quantity of all items in cart. Has no parameters.
 * getCostOfCart() (2 pts)
 *
 * Determines and returns the total cost of items in cart. Has no parameters.
 * printTotal()
 *
 * Outputs total of objects in cart.
 * If cart is empty, output this message: SHOPPING CART IS EMPTY
 * printDescriptions()
 *
 * Outputs each item's description.
 */

}
