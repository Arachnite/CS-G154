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

/**
 * Class for storing high scores in a singly linked list in nondecreasing order.
 * Maintains the top scores for a game application using the SinglyLinkedList from the textbook.
 */
public class ScoreboardSLL {
  private int maxEntries;                                  // maximum capacity for storing entries
  private SinglyLinkedList<GameEntry> board;               // linked list of game entries (names & scores)

  /**
   * Constructs an empty scoreboard with the given capacity for storing entries.
   * @param capacity the maximum number of entries to store
   */
  public ScoreboardSLL(int capacity) {
    board = new SinglyLinkedList<>();
    maxEntries = capacity;
  }


  /**
   * Attempt to add a new score to the collection (if it is high enough).
   * Entries are maintained in sorted order from highest to lowest score.
   * @param e the GameEntry to add
   */
  public void add(GameEntry e) {
    int newScore = e.getScore();

    // Check if the new entry should be added
    // Add if: list is not full OR new score is higher than the lowest score
    if (board.size() < maxEntries || newScore > board.last().getScore()) {

      // Handle empty list
      if (board.isEmpty()) {
        board.addFirst(e);
        return;
      }

      // Handle adding at the front (highest score)
      if (newScore > board.first().getScore()) {
        board.addFirst(e);
        // Remove last element if we exceeded capacity
        if (board.size() > maxEntries) {
          removeLast();
        }
        return;
      }

      // Handle adding at the end (lowest score, but list not full)
      if (board.size() < maxEntries && newScore <= board.last().getScore()) {
        board.addLast(e);
        return;
      }

      // Add in the middle: need to find the correct position
      SinglyLinkedList<GameEntry> tempList = new SinglyLinkedList<>();
      boolean inserted = false;

      // Move entries from board to tempList, inserting e at the correct position
      while (!board.isEmpty()) {
        GameEntry current = board.first();

        // If we haven't inserted yet and current score is less than new score
        if (!inserted && current.getScore() < newScore) {
          tempList.addLast(e);
          inserted = true;
        }

        // Move current entry to tempList (unless we're at capacity)
        if (tempList.size() < maxEntries) {
          tempList.addLast(board.removeFirst());
        } else {
          board.removeFirst(); // discard remaining entries
        }
      }

      // Restore the list
      board = tempList;
    }
  }

  /**
   * Helper method to remove the last element from the list.
   */
  private void removeLast() {
    if (board.isEmpty()) return;

    if (board.size() == 1) {
      board.removeFirst();
      return;
    }

    // Rebuild list without the last element
    SinglyLinkedList<GameEntry> tempList = new SinglyLinkedList<>();
    int count = board.size() - 1;

    for (int i = 0; i < count; i++) {
      tempList.addLast(board.removeFirst());
    }
    board.removeFirst(); // discard last element
    board = tempList;
  }


  /**
   * Remove and return the high score at index i.
   * @param i the index of the entry to remove (0-based)
   * @return the removed GameEntry
   * @throws IndexOutOfBoundsException if the index is invalid
   */
  public GameEntry remove(int i) throws IndexOutOfBoundsException {
    if (i < 0 || i >= board.size())
      throw new IndexOutOfBoundsException("Invalid index: " + i);

    // Special case: removing the first element
    if (i == 0) {
      return board.removeFirst();
    }

    // General case: traverse to find and remove the element at index i
    SinglyLinkedList<GameEntry> tempList = new SinglyLinkedList<>();
    GameEntry temp = null;

    // Move i elements from board to tempList
    for (int j = 0; j < i; j++) {
      tempList.addLast(board.removeFirst());
    }

    // Remove and save the element at index i
    temp = board.removeFirst();

    // Move remaining elements from board to tempList
    while (!board.isEmpty()) {
      tempList.addLast(board.removeFirst());
    }

    // Restore the list
    board = tempList;

    return temp;
  }


  /**
   * Returns a string representation of the high scores list.
   * @return a string showing all entries in the scoreboard
   */
  public String toString() {
    return board.toString();
  }

  /**
   * Main method to test the ScoreboardSLL class.
   */
  public static void main(String[] args) {
    // The main method
    ScoreboardSLL highscores = new ScoreboardSLL(10);
    String[] names = {"Rob", "Mike", "Rose", "Jill", "Jack", "Anna", "Paul", "Bob"};
    int[] scores = {750, 1105, 590, 740, 510, 660, 720, 400};

    for (int i = 0; i < names.length; i++) {
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
  }
}
