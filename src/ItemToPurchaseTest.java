public class ItemToPurchaseTest {
   public static void main(String[] args) {
      ItemToPurchase testItem = new ItemToPurchase();

      String testName = "newy new";
      int testQuantity = 5;
      int testPrice = 3;

      testItem.setName(testName);
      testItem.setPrice(testPrice);
      testItem.setQuantity(testQuantity);

      assert testItem.getQuantity() == testQuantity;
      assert testItem.getPrice() == testPrice;
      assert testItem.getName() == testName;
   }
}
