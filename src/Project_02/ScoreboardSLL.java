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
//package dsaj.arrays;
package Project_02;

/** Class for storing high scores in an array in nondecreasing order. */
public class ScoreboardSLL {
  private int numEntries = 0;              // number of actual entries
  private int maxEntries = 10;
  private SinglyLinkedList<GameEntry> board;               // linked list of game entries (names & scores)
  /** Constructs an empty scoreboard with the given capacity for storing entries. */
  public ScoreboardSLL(int capacity) {
    board = new SinglyLinkedList<>();
    maxEntries = capacity;
  }

  /** Attempt to add a new score to the collection (if it is high enough) */
  public void add(GameEntry e) {
    int newScore = e.getScore();
    SinglyLinkedList<GameEntry> tempList = new SinglyLinkedList<>();
    // is the new entry e really a high score?
    if (numEntries < maxEntries || newScore > board.last().getScore()) {
      if (numEntries < maxEntries)        // no score drops from the board
      {
        numEntries++;
        if (board.isEmpty())
        	board.addFirst(e);
        //list is not maxed
        else if(board.first().getScore() < newScore)
            //add first
            board.addFirst(e);
        else if (board.last().getScore() > newScore)
            //add last
            board.addLast(e);
        else
        {
            //add in between
            while ( newScore < board.first().getScore())
            {
                tempList.addLast(board.removeFirst());
            }
            tempList.addLast(e);
            tempList.concatenate(board);
            board = tempList;
        }
      }
      else
      {
        // Add in between by moving to tempList all entries from board except the last one
        // First move to tempList all the entries with a score higher than newScore using tempList.addLast() method
        // Then, add the entry "e" to tempList using addLast() method
        // Finally, add to tempList the rest of board entries except the last one
        // To keep track when the last entries is reached, there needs to be a counter variable
        // The counter variable is incremented with each addLast()
        // To exclude the last entry from board the counter variable must be < maxEntries

        // --------- type your code here ----------------

      }
    }
  }

  /** Remove and return the high score at index i. */
  public GameEntry remove(int i) throws IndexOutOfBoundsException {
    if (i < 0 || i >= numEntries)
      throw new IndexOutOfBoundsException("Invalid index: " + i);
  // -------- type your code here using SinglyLinkedList instead of array ------------

  /*
    GameEntry temp = board[i];                 // save the object to be removed
    for (int j = i; j < numEntries - 1; j++)   // count up from i (not down)
      board[j] = board[j+1];                   // move one cell to the left
    board[numEntries -1 ] = null;              // null out the old last score
    numEntries--;
   */

    return temp;                               // return the removed object
  }

  /** Returns a string representation of the high scores list. */
  public String toString() {
    StringBuilder sb = new StringBuilder("[");
    /*for (int j = 0; j < numEntries; j++) {
      if (j > 0)
        sb.append(", ");                   // separate entries by commas
      sb.append(board[j]);
    }*/
    sb.append(board.toString());
    sb.append("]");
    return sb.toString();
  }

  public static void main(String[] args) {
    // The main method
    Scoreboard_1 highscores = new Scoreboard_1(5);
    String[] names = {"Rob", "Mike", "Rose", "Jill", "Jack", "Anna", "Paul", "Bob"};
    int[] scores = {750, 1105, 590, 740, 510, 660, 720, 400};

    for (int i=0; i < names.length; i++) {
      GameEntry gE = new GameEntry(names[i], scores[i]);
      System.out.println("Adding " + gE);
      highscores.add(gE);
      System.out.println(" Scoreboard: " + highscores);
    }
    /*
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
    */
  }
}
