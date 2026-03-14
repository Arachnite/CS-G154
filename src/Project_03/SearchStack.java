
package Project_03;

import java.util.Objects;

public class SearchStack {

    /**
     * Scans stack S for an element x using one queue, then restores S to its original order.
     *
     * @return true if x exists, false otherwise
     */
    public static <E> boolean searchStack(Stack<E> s, E x) {
        if (s == null) {
            throw new IllegalArgumentException("Stack cannot be null");
        }

        int n = s.size();
        ArrayQueue<E> q = new ArrayQueue<>(Math.max(1, n));
        boolean found = false;

        // 1. move S -> Q while searching.
        for (int i = 0; i < n; i++) {
            E value = s.pop();
            if (Objects.equals(value, x)) {
                found = true;
            }
            q.enqueue(value);
        }

        // 2. move Q -> S (stack becomes reversed relative to original).
        for (int i = 0; i < n; i++) {
            s.push(q.dequeue());
        }

        // 3. move S -> Q.
        for (int i = 0; i < n; i++) {
            q.enqueue(s.pop());
        }

        // 4. move Q -> S to restore original order.
        for (int i = 0; i < n; i++) {
            s.push(q.dequeue());
        }

        return found;
    }

    public static void main(String[] args) {
        Stack<Integer> s = new ArrayStack<>();
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);

        System.out.println("Before search: " + s); // top-to-bottom: (40, 30, 20, 10)
        boolean found30 = searchStack(s, 30);
        System.out.println("Found 30? " + found30);
        System.out.println("After searching 30: " + s);

        boolean found99 = searchStack(s, 99);
        System.out.println("Found 99? " + found99);
        System.out.println("After searching 99: " + s);
    }
}
