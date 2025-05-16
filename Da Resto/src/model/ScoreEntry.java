package model;

public class ScoreEntry {

	 private final String name;
     private final int score;

     public ScoreEntry(String name, int score) {
         this.name = name;
         this.score = score;
     }

     public String getName() {
         return name;
     }

     public int getScore() {
         return score;
     }
}
