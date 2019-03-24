public class SongEntry {
   private String uniqueID;
   private String songName;
   private String artistName;
   private int songLenght;
   private SongEntry nextNode;

   public SongEntry(){
      this.uniqueID = "none";
      this.songName = "none";
      this.artistName = "none";
      this.songLenght = 0;
      this.nextNode = null;
   }

   public SongEntry(String uniqueId, String songName, String artistName,
                    int songLength) {
      this.uniqueID = uniqueId;
      this.songName = songName;
      this.artistName = artistName;
      this.songLenght = songLength;
      this.nextNode = null;
   }

   public void insertAfter(SongEntry newNode) {
      newNode.setNext(this.nextNode);
      this.setNext(newNode);
   }

   public void setNext(SongEntry nextNode){
      this.nextNode = nextNode;
   }

   public String getID(){return this.uniqueID;}

   public String getSongName() {return this.songName;}

   public String getArtistName() {return this.artistName;}

   public int getSongLength() {return this.songLenght;}

   public SongEntry getNext() {return this.nextNode;}

   public void printPlaylistSongs() {
      String toPrint = String.format("Unique ID: %s\n" +
                                     "Song Name: %s\n" +
                                     "Artist Name: %s\n" +
                                     "Song Length (in seconds): %d\n",
                                     this.uniqueID, this.songName,
                                     this.artistName, this.songLenght);
      System.out.println(toPrint);
   }
}