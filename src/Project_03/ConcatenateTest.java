
package Project_03;

public class ConcatenateTest {

    private static void printState(String label, LinkedQueue<Integer> q1, LinkedQueue<Integer> q2) {
        System.out.println(label);
        System.out.println("Q1 = " + q1 + "; size = " + q1.size());
        System.out.println("Q2 = " + q2 + "; size = " + q2.size());
        System.out.println();
    }

    private static void assertCondition(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }

    public static void main(String[] args) {
        LinkedQueue<Integer> q1 = new LinkedQueue<>();
        LinkedQueue<Integer> q2 = new LinkedQueue<>();

        q1.enqueue(1);
        q1.enqueue(2);
        q1.enqueue(3);
        q2.enqueue(4);
        q2.enqueue(5);

        printState("Before concatenate (both non-empty):", q1, q2);
        q1.concatenate(q2);
        printState("After q1.concatenate(q2):", q1, q2);

        assertCondition(q1.size() == 5, "Expected q1 size to be 5");
        assertCondition(q2.isEmpty(), "Expected q2 to be empty");
        assertCondition("(1, 2, 3, 4, 5)".equals(q1.toString()), "Expected queue order to be preserved");

        LinkedQueue<Integer> q3 = new LinkedQueue<>();
        LinkedQueue<Integer> q4 = new LinkedQueue<>();
        q4.enqueue(10);
        q4.enqueue(20);

        q3.concatenate(q4);
        assertCondition("(10, 20)".equals(q3.toString()), "Expected empty destination to adopt source elements");
        assertCondition(q4.isEmpty(), "Expected source to be empty after concatenate");

        LinkedQueue<Integer> q5 = new LinkedQueue<>();
        LinkedQueue<Integer> q6 = new LinkedQueue<>();
        q5.enqueue(7);
        q5.enqueue(8);

        q5.concatenate(q6);
        assertCondition("(7, 8)".equals(q5.toString()), "Expected destination unchanged when source is empty");
        assertCondition(q6.isEmpty(), "Expected source to remain empty");

        boolean selfConcatRejected = false;
        try {
            q5.concatenate(q5);
        } catch (IllegalArgumentException ex) {
            selfConcatRejected = true;
        }
        assertCondition(selfConcatRejected, "Expected self-concatenate to throw IllegalArgumentException");

        System.out.println("All concatenate tests passed.");
    }
}
