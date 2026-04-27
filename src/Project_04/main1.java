/*
 * O(n) Time Complexity
 *   - Initialization of count array: O(n)
 *   - Counting frequencies: O(n)
 *   - Finding maximum: O(n)
 *   - Total: O(n) + O(n) + O(n) = O(n)
 * 
 * O(n) Space Complexity
 *   - Count array requires O(4n) = O(n) space
 * 
 * Big O Time Complexity
 *   - O(n) time
 *
 * Big O Space Complexity
 *   - O(n) space
 */

public class main1 {
    
    /**
     * Finds the most frequently occurring integer in an array.
     * The array A contains n integers from the interval [0, 4n].
     * 
     * @param A array of n integers in range [0, 4n]
     * @return the integer k that occurs most often in A
     */
    public static int findMostFrequent(int[] A) {
        int n = A.length;
        
        // Create count array of size 4n+1
        // Index represents the value, value at index represents frequency
        int[] count = new int[4 * n + 1];
        
        // Count occurrences of each element
        for (int i = 0; i < n; i++) {
            count[A[i]]++;
        }
        
        // Find the value with maximum frequency
        int maxCount = 0;
        int mostFrequent = 0;
        
        for (int i = 0; i < count.length; i++) {
            if (count[i] > maxCount) {
                maxCount = count[i];
                mostFrequent = i;
            }
        }
        
        return mostFrequent;
    }
    
    /**
     * Main method to test the findMostFrequent algorithm
     */
    public static void main(String[] args) {
        // Test array: n = 100 integers from interval [0, 400]
        int[] arr = { 55, 9, 118, 220, 152, 200, 198, 319, 245, 315, 379, 99, 191, 343,
                394, 31, 3, 345, 274, 43, 52, 324, 283, 7, 65, 70, 56, 344, 18, 360, 104, 349, 309,
                149, 94, 160, 111, 370, 235, 8, 81, 379, 213, 379, 201, 399, 390, 160, 369, 113,
                340, 178, 281, 160, 232, 241, 348, 160, 29, 179, 65, 327, 7, 88, 305, 180, 334, 27,
                303, 281, 341, 260, 393, 105, 219, 170, 346, 380, 14, 134, 169, 336, 54, 178, 177,
                122, 21, 145, 398, 170, 201, 104, 161, 380, 332, 234, 48, 251, 105, 33 };
        
        System.out.println("========== Find Most Frequent Integer ==========");
        System.out.println("Array size (n): " + arr.length);
        System.out.println("Valid range: [0, " + (4 * arr.length) + "]");
        System.out.println();
        
        // Find and display the most frequent element
        int result = findMostFrequent(arr);
        System.out.println("Most frequently occurring integer: " + result);
        
        // Count and display actual frequency
        int frequency = 0;
        for (int val : arr) {
            if (val == result) {
                frequency++;
            }
        }
        System.out.println("Frequency: " + frequency + " occurrences");
        
        // Verify by showing all elements with their frequencies
        System.out.println("\nAll Elements and Their Frequencies:");
        int[] count = new int[4 * arr.length + 1];
        for (int val : arr) {
            count[val]++;
        }
        
        // Display elements that appear more than once, sorted by frequency
        System.out.println("Elements appearing more than once:");
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 1) {
                System.out.println("  Value " + i + ": " + count[i] + " times");
            }
        }
    }
}
