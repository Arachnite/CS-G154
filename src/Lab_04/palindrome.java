package Lab_04;

import java.util.Scanner;

public class palindrome {

    public boolean isPalindrome(String str) {
        if (str == null) {
            return false;
        }
        str = str.toLowerCase();
        if (str.length() <= 1) {
            return true;
        }
        if (str.charAt(0) != str.charAt(str.length() - 1)) {
            return false;
        }
        return isPalindrome(str.substring(1, str.length() - 1));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        palindrome checker = new palindrome();
        boolean result = checker.isPalindrome(input);

        System.out.println(result ? "yes, " + input + " is a palindrome" : "no, " + input + " is not a palindrome");
        scanner.close();
    }
}
