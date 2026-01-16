package ReversePrograms;

import java.util.Scanner;

public class ReverseInteger {

    // Method to reverse an integer safely
    public static int reverse(int num) {
        long reversed = 0; // Use long to detect overflow before casting

        int sign = (num < 0) ? -1 : 1;
        num = Math.abs(num);

        while (num != 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;

            // Check for overflow beyond int range
            if (reversed > Integer.MAX_VALUE) {
                throw new ArithmeticException("Reversed number exceeds integer range.");
            }

            num /= 10;
        }

        return (int) reversed * sign;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid integer.");
            return;
        }

        int number = scanner.nextInt();

        try {
            int reversedNumber = reverse(number);
            System.out.println("Reversed integer: " + reversedNumber);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}
