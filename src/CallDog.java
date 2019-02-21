public class CallDog {
   public static void main(String [] args) {

      Dog buddy = new Dog(10, 20);

      Dog uddy = new Dog(20, 10);

      int[] ageSize = buddy.getAgeAndSize();

      System.out.println("none weight: " + ageSize[0] + ageSize[1]);

      buddy.SetWeightAndAge(78, 4);
      System.out.print("Human years: " + buddy.getHumanYears());

      ageSize = buddy.getAgeAndSize();
      System.out.println("none weight: " + ageSize[0] + " " + ageSize[1]);

      ageSize = uddy.getAgeAndSize();
      System.out.println("none weight: " + ageSize[0] + " " + ageSize[1]);

      buddy.printThisThat();
   }
}