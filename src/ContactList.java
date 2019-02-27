import java.util.Scanner;

public class ContactList {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      String contactName;
      String contactNumber;
      ContactNode headNode = new ContactNode("header", "header");
      ContactNode nextNode;

      for (int i = 1; i < 4; ++i) {
         System.out.println("Person " + i);
         System.out.println("Enter name:");
         contactName = scnr.nextLine();
         System.out.println("Enter phone number:");
         contactNumber = scnr.nextLine();
         System.out.printf("You entered: %s, %s\n\n", contactName, contactNumber);
         headNode.insertAfter(new ContactNode(contactName, contactNumber));
      }

      nextNode = headNode.getNext();
      System.out.println("CONTACT LIST");
      while (nextNode != null) {
         nextNode.printContactNode();
         nextNode = nextNode.getNext();
      }
   }
}

