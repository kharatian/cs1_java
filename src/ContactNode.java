public class ContactNode {
   private String contactName;
   private String contactPhoneNumber;
   private ContactNode nextNodePtr;

   public ContactNode(String contactName, String contactPhoneNumber) {
      this.contactName = contactName;
      this.contactPhoneNumber = contactPhoneNumber;
   }

   public String getName() {return this.contactName;}

   public String getPhoneNumber() {return this.contactPhoneNumber;}

   public void insertAfter(ContactNode nodeToInsert) {
      nodeToInsert.nextNodePtr = this.nextNodePtr;
      this.nextNodePtr = nodeToInsert;
   }

   public ContactNode getNext() {return this.nextNodePtr;}

   public void printContactNode() {
      String toPrint = String.format("Name: %s\n" +
                                     "Phone number: %s\n", this.getName(),
                                                         this.getPhoneNumber());
      System.out.println(toPrint);
   }
}

/**
 Parameterized constructor. Parameters are name followed by phone number.

 Private fields

 String contactName

 String contactPhoneNumber

 ContactNode nextNodePtr

 Public member methods

 getName() - Accessor (1 pt)

 getPhoneNumber - Accessor (1 pt)

 insertAfter() (2 pts)

 getNext() - Accessor (1 pt)

 printContactNode()
 */