import java.util.Scanner;

public class Playlist {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      System.out.println("Enter playlist's title:");
      String playlistTitle = scnr.nextLine();
      boolean isContinue = true;
      String menuChoice;
      SongEntry headerNode = new SongEntry();
      SongEntry tailNode = headerNode;

      while (isContinue) {
         menuChoice = printMenu(scnr, playlistTitle);
         switch (menuChoice){
            case "q":
               isContinue = false;
               break;
            case "a":
               tailNode = addSong(tailNode ,scnr);
               break;
            case "d":
               break;
            case "c":
               break;
            case "s":
               break;
            case "t":
               break;
            case "o":
               output(headerNode, playlistTitle);
               break;
         }
      }
   }

   private static void output(SongEntry headerNode, String title) {
      SongEntry currNode = headerNode.getNextNode();
      System.out.println(title + " - OUTPUT FULL PLAYLIST");
      if (currNode == null) {
         System.out.println("Playlist is empty");
         return;
      }
      int trackCounter = 1;
      while (currNode != null) {
         System.out.println(trackCounter + ".");
         currNode.printPlaylistSongs();
         ++trackCounter;
         currNode = currNode.getNextNode();
      }
   }

   private static String printMenu(Scanner scnr, String title) {
      String menuText = "\n" + title + " PLAYLIST MENU\n" +
                        "a - Add song\n" +
                        "d - Remove song\n" +
                        "c - Change position of song\n" +
                        "s - Output songs by specific artist\n" +
                        "t - Output total time of playlist (in seconds)\n" +
                        "o - Output full playlist\n" +
                        "q - Quit\n" +
                        "\n" +
                        "Choose an option:";

      System.out.println(menuText);
      String userChoice = scnr.nextLine();
      return userChoice;
   }

   private static SongEntry addSong(SongEntry tailNode, Scanner scnr) {
      System.out.println("ADD SONG");
      System.out.println("Enter song's unique ID:");
      String songID = scnr.nextLine();
      System.out.println("Enter song's name:");
      String songName = scnr.nextLine();
      System.out.println("Enter artist's name:");
      String artistName = scnr.nextLine();
      System.out.println("Enter song's length (in seconds):");
      int songLength = Integer.parseInt(scnr.nextLine());
      tailNode.insertAfter(new SongEntry(songID, songName, artistName, songLength));
      return tailNode.getNextNode();
   }
}