
public class Dog {
   private int years;
   private int weight;
   private String size;
   private int humanYears;

   public Dog() {
      this(0, 0);
      System.out.println("and now this!");
   }

   public Dog(int dogWeight, int age) {

      this.weight = dogWeight;

      SetWeightAndAge(weight, age);
   }
//   public static void main(String[] args) {
//      int weight = -1;
//      String size = "nil";
//      int humanYears = -1;
//   }

   public int[] getAgeAndSize() {
      int[] ageAndSize = new int[2];

      ageAndSize[0] = humanYears;

      ageAndSize[1] = weight;

      return ageAndSize;
   }

   private void setHumanYears() {
      int factor;
      if (size == "small") { factor = 6;
      }
      else if (size == "medium") {
         factor = 7; }
      else { factor = 8;
      }

      this.humanYears = years * factor;
   }
   public int getHumanYears() {
      return this.humanYears;
   }

   public void printThisThat() {
      System.out.println("Printing age with this" + this.humanYears);

      System.out.println("\n\nPrinting age" + humanYears);
   }

   public void SetWeightAndAge(int weightToSet, int yearsToSet) {
      weight = weightToSet;
      if (this.weight <= 20) {
         this.size = "small";
      }
      else if (weight <= 45) {
         this.size = "medium";
      }
      else { this.size = "large";
      }

      this.years = yearsToSet;
      setHumanYears();
   }
}