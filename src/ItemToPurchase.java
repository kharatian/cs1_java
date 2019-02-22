public class ItemToPurchase {
   final private String DEFAULT_NAME = "none";
   final private String DEFAULT_DESCRIPTION = "none";

   final private int DEFAULT_P_Q = 0;
   private String itemName;
   private String itemDescription;
   private int itemPrice;
   private int itemQuantity;

   // Default constructor
   public ItemToPurchase(){
      itemName = DEFAULT_NAME;
      itemPrice = DEFAULT_P_Q;
      itemQuantity = DEFAULT_P_Q;
      itemDescription = DEFAULT_DESCRIPTION;
   }

   public ItemToPurchase(String itemName, String itemDescription,
                         int itemPrice, int itemQuantity) {
      this.itemName = itemName;
      this.itemDescription = itemDescription;
      this.itemPrice = itemPrice;
      this.itemQuantity = itemQuantity;
   }
   // getters
   public String getName() {
      return this.itemName;
   }

   public String getDescription() {
      return this.itemDescription;
   }

   public int getPrice() {
      return this.itemPrice;
   }

   public int getQuantity() {
      return this.itemQuantity;
   }

   public int getTotal() { return (this.itemPrice * this.itemQuantity);}

   // setters
   public void setName(String newName) {
      this.itemName = newName;
   }

   public void setDescription(String newDescription) {
      this.itemDescription = newDescription;
   }

   public void setPrice(int newPrice) {
      this.itemPrice = newPrice;
   }

   public void setQuantity(int newQuantity) {
      this.itemQuantity = newQuantity;
   }

   public void printItemCost() {
      int totalPrice = this.itemQuantity * this.itemPrice;
      System.out.printf("%s %d @ $%d = $%d\n", this.itemName, this.itemQuantity,
                        this.itemPrice, totalPrice);
   }

   public void printItemDescription() {
      System.out.printf("%s: %s\n", this.itemName, this.itemDescription);
   }
}