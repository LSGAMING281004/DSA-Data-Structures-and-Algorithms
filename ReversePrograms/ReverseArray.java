package ReversePrograms;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseArray {

    // Method to reverse the array in place
    public static void reverseArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            // Swap elements
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Input array size
            System.out.print("Enter the number of elements: ");
            int n = sc.nextInt();

            if (n < 0) {
                System.out.println("Array size cannot be negative.");
                return;
            }
            if (n == 0) {
                System.out.println("Empty array. Nothing to reverse.");
                return;
            }

            int[] arr = new int[n];

            // Input array elements
            System.out.println("Enter " + n + " integers:");
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            // Reverse the array
            reverseArray(arr);

            // Output reversed array
            System.out.println("Reversed array: " + Arrays.toString(arr));

        } catch (Exception e) {
            System.out.println("Invalid input. Please enter integers only.");
        } finally {
            sc.close();
        }
    }
}