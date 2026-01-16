package ReversePrograms;

import java.util.Scanner;

public class ReverseString {

    // Method 1: Using StringBuilder (Efficient and simple)
    public static String reverseUsingStringBuilder(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    // Method 2: Manual reversal using a loop
    public static String reverseManually(String input) {
        char[] chars = input.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string to reverse: ");
        String input = scanner.nextLine();

        // Input validation: Check for null or empty string
        if (input == null || input.isEmpty()) {
            System.out.println("Error: String cannot be empty.");
            return;
        }

        // Using StringBuilder
        String reversed1 = reverseUsingStringBuilder(input);
        System.out.println("Reversed (StringBuilder): " + reversed1);

        // Using manual method
        String reversed2 = reverseManually(input);
        System.out.println("Reversed (Manual Loop): " + reversed2);

        scanner.close();
    }
}
