
package Lab_03;

/**
 * Application class to find the missing number in an array of consecutive integers.
 * Uses the arithmetic series formula to calculate the expected sum.
 */
public class application {

    /**
     * Finds the missing number in an array of consecutive integers.
     * Uses O(n) time complexity with a single loop.
     *
     * @param arr the array with one missing number
     * @return the missing number
     */
    public static int findMissingNumber(int[] arr) {
        // Step 1: Calculate the actual sum of all elements in the array using one loop
        int actualSum = 0;
        for (int i: arr) {
            actualSum += i;
        }

        // Step 2: Calculate the theoretical sum using the arithmetic series formula
        // Formula: Sum = (n * (n + 1)) / 2
        // where n is the size of the complete array (arr.length + 1)
        int n = arr.length + 1;
        int theoreticalSum = n * (n + 1) / 2;

        // Step 3: Return the missing number (difference between theoretical and actual sum)
        return theoreticalSum - actualSum;
    }

    /**
     * Main method to test the findMissingNumber method with different test cases.
     */
    public static void main(String[] args) {
        // Test case 1: Array from 1 to 10 with missing number 5
        int[] testArray1 = {1, 2, 3, 4, 6, 7, 8, 9, 10};
        System.out.println("Test Case 1:");
        System.out.print("Array: ");
        printArray(testArray1);
        int missing1 = findMissingNumber(testArray1);
        System.out.println("Missing number: " + missing1);
        System.out.println();

        // Test case 2: Array from 1 to 15 with missing number 12
        int[] testArray2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 14, 15};
        System.out.println("Test Case 2:");
        System.out.print("Array: ");
        printArray(testArray2);
        int missing2 = findMissingNumber(testArray2);
        System.out.println("Missing number: " + missing2);
        System.out.println();

        // Test case 3: Array from 1 to 20 with missing number 1
        int[] testArray3 = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        System.out.println("Test Case 3:");
        System.out.print("Array: ");
        printArray(testArray3);
        int missing3 = findMissingNumber(testArray3);
        System.out.println("Missing number: " + missing3);
        System.out.println();

        // Test case 4: Array from 1 to 8 with missing number 8
        int[] testArray4 = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("Test Case 4:");
        System.out.print("Array: ");
        printArray(testArray4);
        int missing4 = findMissingNumber(testArray4);
        System.out.println("Missing number: " + missing4);
    }

    /**
     * Helper method to print an array.
     *
     * @param arr the array to print
     */
    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
