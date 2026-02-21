/*
 * Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 *
 * Developed for use with the book:
 *
 *    Data Structures and Algorithms in Java, Sixth Edition
 *    Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
 *    John Wiley & Sons, 2014
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package Lab_02;
//package dsaj.arrays;

/** Class for storing high scores in an array in nondecreasing order. */
public class Scoreboard {
  private int numEntries = 0;              // number of actual entries
  private GameEntry[] board;               // array of game entries (names & scores)
  /** Constructs an empty scoreboard with the given capacity for storing entries. */
  public Scoreboard(int capacity) {
    board = new GameEntry[capacity];
  }

  /** Attempt to add a new score to the collection (if it is high enough) */
  public void add(GameEntry e) {
    int newScore = e.getScore();
    // is the new entry e really a high score?
    if (numEntries < board.length || newScore > board[numEntries-1].getScore()) {
      if (numEntries < board.length)        // no score drops from the board
        numEntries++;                       // so overall number increases
      // shift any lower scores rightward to make room for the new entry
      int j = numEntries - 1;
      while (j > 0 && board[j-1].getScore() < newScore) {
        board[j] = board[j-1];              // shift entry from j-1 to j
        j--;                                // and decrement j
      }
      board[j] = e;                         // when done, add new entry
    }
  }

  /** Remove and return the high score at index i. */
  public GameEntry remove(int i) throws IndexOutOfBoundsException {
    if (i < 0 || i >= numEntries)
      throw new IndexOutOfBoundsException("Invalid index: " + i);
    GameEntry temp = board[i];                 // save the object to be removed
    for (int j = i; j < numEntries - 1; j++)   // count up from i (not down)
      board[j] = board[j+1];                   // move one cell to the left
    board[numEntries -1 ] = null;              // null out the old last score
    numEntries--;
    return temp;                               // return the removed object
  }

  /**
   * Add a new score to the collection ignoring order.
   * Adds the entry at the end of the array if there is room.
   */
  public void addIgnoreOrder(GameEntry e) {
    if (numEntries < board.length)             // check if there is room
      board[numEntries] = e;                   // add at the end
    numEntries++;                              // increment the count
  }

  /**
   * Remove and return the entry at index i without maintaining order.
   * Replaces the removed entry with the last entry in the array.
   */
  public GameEntry removeIgnoreOrder(int i) throws IndexOutOfBoundsException {
    if (i < 0 || i >= numEntries)
      throw new IndexOutOfBoundsException("Invalid index: " + i);
    GameEntry temp = board[i];                 // save the object to be removed
    board[i] = board[numEntries - 1];          // replace with last entry
    board[numEntries - 1] = null;              // null out the old last entry
    numEntries--;                              // decrement the count
    return temp;                               // return the removed object
  }

  /** Returns a string representation of the high scores list. */
  public String toString() {
    StringBuilder sb = new StringBuilder("[");
    for (int j = 0; j < numEntries; j++) {
      if (j > 0)
        sb.append(", ");                   // separate entries by commas
      sb.append(board[j]);
    }
    sb.append("]");
    return sb.toString();
  }

  public static void main(String[] args) {
    // The main method
    Scoreboard highscores = new Scoreboard(5);
    String[] names = {"Rob", "Mike", "Rose", "Jill", "Jack", "Anna", "Paul", "Bob"};
    int[] scores = {750, 1105, 590, 740, 510, 660, 720, 400};

    for (int i=0; i < names.length; i++) {
      GameEntry gE = new GameEntry(names[i], scores[i]);
      System.out.println("Adding " + gE);
      highscores.add(gE);
      System.out.println(" Scoreboard: " + highscores);
    }
    System.out.println("Removing score at index " + 3);
    highscores.remove(3);
    System.out.println(highscores);
    System.out.println("Removing score at index " + 0);
    highscores.remove(0);
    System.out.println(highscores);
    System.out.println("Removing score at index " + 1);
    highscores.remove(1);
    System.out.println(highscores);
    System.out.println("Removing score at index " + 1);
    highscores.remove(1);
    System.out.println(highscores);
    System.out.println("Removing score at index " + 0);
    highscores.remove(0);
    System.out.println(highscores);

    // Test the new addIgnoreOrder() and removeIgnoreOrder() methods
    System.out.println("\n--- Testing addIgnoreOrder() and removeIgnoreOrder() ---");
    Scoreboard unorderedScores = new Scoreboard(5);

    // Test addIgnoreOrder
    System.out.println("\nTesting addIgnoreOrder():");
    GameEntry e1 = new GameEntry("Alice", 850);
    System.out.println("Adding " + e1);
    unorderedScores.addIgnoreOrder(e1);
    System.out.println(" Scoreboard: " + unorderedScores);

    GameEntry e2 = new GameEntry("Bob", 500);
    System.out.println("Adding " + e2);
    unorderedScores.addIgnoreOrder(e2);
    System.out.println(" Scoreboard: " + unorderedScores);

    GameEntry e3 = new GameEntry("Carol", 1200);
    System.out.println("Adding " + e3);
    unorderedScores.addIgnoreOrder(e3);
    System.out.println(" Scoreboard: " + unorderedScores);

    GameEntry e4 = new GameEntry("Dave", 300);
    System.out.println("Adding " + e4);
    unorderedScores.addIgnoreOrder(e4);
    System.out.println(" Scoreboard: " + unorderedScores);

    // Test removeIgnoreOrder
    System.out.println("\nTesting removeIgnoreOrder():");
    System.out.println("Removing score at index 1");
    unorderedScores.removeIgnoreOrder(1);
    System.out.println(" Scoreboard: " + unorderedScores);

    System.out.println("Removing score at index 0");
    unorderedScores.removeIgnoreOrder(0);
    System.out.println(" Scoreboard: " + unorderedScores);

    System.out.println("Removing score at index 1 (last element)");
    unorderedScores.removeIgnoreOrder(1);
    System.out.println(" Scoreboard: " + unorderedScores);
  }
}
