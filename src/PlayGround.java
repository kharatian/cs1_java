import scala.Int;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayGround {
   private static int statInt = 1010;

   public static void main(String[] args) {
      ArrayList<Integer> listOne = new ArrayList<Integer>();
      ArrayList<Integer> listTwo = new ArrayList<Integer>();

      listOne.add(1);
      listOne.add(2);
      listOne.add(3);
      listOne.add(4);

      listTwo  = listOne;

      listTwo.add(2, 54321);

      System.out.println(listOne);
      arrChange(listOne, 9999);
      System.out.println(listOne);
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


