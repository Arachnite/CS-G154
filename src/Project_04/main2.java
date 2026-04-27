
public class main2 {
    
    // Class to store the result pair
    static class PairResult {
        int first;
        int second;
        boolean found;
        
        PairResult(int first, int second, boolean found) {
            this.first = first;
            this.second = second;
            this.found = found;
        }
    }
    
    /**
     * Finds two distinct integers in sorted array A that sum to k.
     * Uses a recursive two-pointer approach.
     * 
     * @param A sorted array of distinct integers in increasing order
     * @param k the target sum
     * @return PairResult containing the pair (if found) and a boolean indicating success
     */
    public static PairResult findPairWithSum(int[] A, int k) {
        if (A == null || A.length < 2) {
            return new PairResult(0, 0, false);
        }
        return findPairRecursive(A, k, 0, A.length - 1);
    }
    
    /**
     * Recursive helper method to find a pair that sums to k.
     * 
     * @param A the sorted array
     * @param k the target sum
     * @param left left pointer index
     * @param right right pointer index
     * @return PairResult containing the pair (if found) and a boolean indicating success
     */
    private static PairResult findPairRecursive(int[] A, int k, int left, int right) {
        // Base case: pointers have crossed, no pair found
        if (left >= right) {
            return new PairResult(0, 0, false);
        }
        
        int sum = A[left] + A[right];
        
        // Case 1: Found the pair!
        if (sum == k) {
            return new PairResult(A[left], A[right], true);
        }
        
        // Case 2: Sum is too small, move left pointer right
        if (sum < k) {
            return findPairRecursive(A, k, left + 1, right);
        }
        
        // Case 3: Sum is too large, move right pointer left
        else {
            return findPairRecursive(A, k, left, right - 1);
        }
    }
    
    /**
     * Main method to test the recursive algorithm
     */
    public static void main(String[] args) {
        // Use the same sorted array from problem C-4.56
        // (Note: This needs to be sorted, so we'll create a sorted version)
        int[] originalArr = { 55, 9, 118, 220, 152, 200, 198, 319, 245, 315, 379, 99, 191, 343,
                394, 31, 3, 345, 274, 43, 52, 324, 283, 7, 65, 70, 56, 344, 18, 360, 104, 349, 309,
                149, 94, 160, 111, 370, 235, 8, 81, 379, 213, 379, 201, 399, 390, 160, 369, 113,
                340, 178, 281, 160, 232, 241, 348, 160, 29, 179, 65, 327, 7, 88, 305, 180, 334, 27,
                303, 281, 341, 260, 393, 105, 219, 170, 346, 380, 14, 134, 169, 336, 54, 178, 177,
                122, 21, 145, 398, 170, 201, 104, 161, 380, 332, 234, 48, 251, 105, 33 };
        
        // Make a copy for modification/display purposes
        int[] A = originalArr.clone();
        java.util.Arrays.sort(A);
        
        System.out.println("========== Find Two Integers That Sum to K (Recursive) ==========");
        System.out.println("\nArray BEFORE processing:");
        displayArray(originalArr);
        System.out.println("\nArray size: " + A.length);
        System.out.println("Array range: [0, 400]");

        System.out.println("\nArray AFTER Processing:");
        System.out.println("(Array remains unchanged - only READ during search)");
        displayArray(A);

        // Test multiple target sums
        int[] testValues = { 100, 200, 300, 400, 500, 600, 700 };
        
        System.out.println("\nTesting Various Target Sums:");
        
        for (int k : testValues) {
            System.out.println("\n--- Finding pair that sums to k = " + k + " ---");
            
            PairResult result = findPairWithSum(A, k);
            
            if (result.found) {
                System.out.println("✓ FOUND: " + result.first + " + " + result.second + " = " + k);
            } else {
                System.out.println("✗ NOT FOUND: No pair in array sums to " + k);
            }
        }
    }
    
    /**
     * Helper method to display the array
     */
    private static void displayArray(int[] arr) {
        System.out.print("[ ");
        for (int i = 0; i < arr.length - 2; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.print(arr.length + " ]");
    }
}
