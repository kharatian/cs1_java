import java.util.Scanner;

public class Playlist {
   private String playListTitle;
   private SongEntry headerNode;
   private SongEntry tailNode;

   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      System.out.println("Enter playlist's title:");
      String playlistTitle = scnr.nextLine();
      boolean isContinue = true;
      String menuChoice;
      Playlist playList = new Playlist(playlistTitle);
      System.out.println(""); // print a blank line for zybooks.

      while (isContinue) {
         menuChoice = playList.printMenu(scnr, playlistTitle);
         switch (menuChoice){
            case "q":
               isContinue = false;
               break;
            case "a":
               playList.addSong(scnr);
               break;
            case "d":
               playList.removeSong(scnr);
               break;
            case "c":
               playList.changePosition(scnr);
               break;
            case "s":
               playList.outputArtist(scnr);
               break;
            case "t":
               playList.outputTotalPlayListTime();
               break;
            case "o":
               playList.outputPlaylist(playlistTitle);
               break;
         }
      }
   }

   public Playlist(String playListTitle){
      this.playListTitle = playListTitle;
      this.headerNode = new SongEntry();
      this.tailNode = this.headerNode;
   }

   private String printMenu(Scanner scnr, String title) {
      String menuText = title + " PLAYLIST MENU\n" +
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

   private void outputTotalPlayListTime() {
      int totalTime = 0;
      SongEntry currNode = this.headerNode.getNext();
      while (currNode != null) {
         totalTime += currNode.getSongLength();
         currNode = currNode.getNext();
      }
      System.out.printf("OUTPUT TOTAL TIME OF PLAYLIST (IN SECONDS)\n" +
                        "Total time: %d seconds\n\n", totalTime);
   }

   private void outputArtist(Scanner scnr){
      System.out.println("OUTPUT SONGS BY SPECIFIC ARTIST\n" +
                         "Enter artist's name:");
      String artistName = scnr.nextLine();
      int i = 1;
      SongEntry nodeToCheck = this.headerNode.getNext();

      while (nodeToCheck != null) {
         if (nodeToCheck.getArtistName().equals(artistName)) {
            System.out.println(i + ".");
            nodeToCheck.printPlaylistSongs();
         }
         nodeToCheck = nodeToCheck.getNext();
         ++i;
      }
   }

   private void changePosition(Scanner scnr) {
      System.out.println("CHANGE POSITION OF SONG\n" +
                         "Enter song's current position:");
      int currPos = Integer.parseInt(scnr.nextLine());
      System.out.println("Enter new position for song:");
      int newPos = Integer.parseInt(scnr.nextLine());
      SongEntry nodeToMove; // always need to start at headnode
      SongEntry nodeBeforeNodeToMove = this.headerNode; //same as above

      // determine node before the node that will be moved so we can update its
      // next node when the move is made. Do this by looping for currPos - 1
      for (int i = 0; i < currPos - 1; ++i ){
         nodeBeforeNodeToMove = nodeBeforeNodeToMove.getNext();
      }

      // we know the node before the node we want to move so we use node's
      // getNext() method to get the actual nodeToMove
      nodeToMove = nodeBeforeNodeToMove.getNext();
      // nodeAtNewPosition to determine where the node will be moved to
      SongEntry nodeAtNewPosition = this.headerNode;

      // update newPos to newPos - 1 if it's less than currPos. newPos is in the
      // the position in the NEW playlist. The insertion point differs because
      // we need to insert node 1 later if currPos is less than newPos because
      // we lose 1 position before newPos when the node is moved
      if (newPos < currPos) {
         --newPos;
      }

      for (int i = 0; i < newPos; ++i) {
         nodeAtNewPosition = nodeAtNewPosition.getNext();
         // stop the loop is newPos is actually greater than number of nodes in
         // linked list. nodeAtNewPosition is tailNode at this point
         if (nodeAtNewPosition.getNext() == null) {
            break;
         }
      }
      // update all node's next nodes by updating
      // nodeBeforeNodeToMove first before updating nodeToMove's next node
      nodeBeforeNodeToMove.setNext(nodeToMove.getNext());
      nodeToMove.setNext(nodeAtNewPosition.getNext());
      nodeAtNewPosition.setNext(nodeToMove);

      // check if tailnode has getNext and update tailNode if the new tailNode
      if (this.tailNode.getNext() != null) {
         this.tailNode = this.tailNode.getNext();
      }
      System.out.printf("\"%s\" moved to position %s\n\n",
                        nodeToMove.getSongName(), newPos);
   }

   private SongEntry removeSong(Scanner scnr) {
      System.out.println("REMOVE SONG\n" +
                         "Enter song's unique ID:");
      String idToRemove = scnr.nextLine();
      SongEntry prevNode = this.headerNode;
      SongEntry currNode = this.headerNode.getNext();

      while (currNode != null) {
         if (currNode.getID().equals(idToRemove)) {
            prevNode.setNext(currNode.getNext());
            System.out.printf("\"%s\" removed.\n\n", currNode.getSongName());
            if (currNode == this.tailNode) {
               this.tailNode = prevNode;
            }
            break;
         }
         prevNode = currNode;
         currNode = currNode.getNext();
      }
      return tailNode;
   }

   private void outputPlaylist(String title) {
      SongEntry currNode = this.headerNode.getNext();
      System.out.println(title + " - OUTPUT FULL PLAYLIST");
      if (currNode == null) {
         System.out.println("Playlist is empty\n");
         return;
      }
      int trackCounter = 1;
      while (currNode != null) {
         System.out.println(trackCounter + ".");
         currNode.printPlaylistSongs();
         ++trackCounter;
         currNode = currNode.getNext();
      }
   }

   private void addSong(Scanner scnr) {
      System.out.println("ADD SONG");
      System.out.println("Enter song's unique ID:");
      String songID = scnr.nextLine();
      System.out.println("Enter song's name:");
      String songName = scnr.nextLine();
      System.out.println("Enter artist's name:");
      String artistName = scnr.nextLine();
      System.out.println("Enter song's length (in seconds):");
      int songLength = Integer.parseInt(scnr.nextLine());
      this.tailNode.insertAfter(new SongEntry(songID, songName, artistName,
                           songLength));
      this.tailNode = this.tailNode.getNext();
      System.out.println();
   }
}