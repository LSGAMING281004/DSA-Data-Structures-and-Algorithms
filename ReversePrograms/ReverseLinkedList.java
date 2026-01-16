import java.util.Scanner;

class LinkedList {
    // Node class for linked list
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head; // Head of the list

    // Add node at the end
    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    // Print the linked list
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Iterative method to reverse the linked list
    public void reverseIterative() {
        Node prev = null;
        Node current = head;
        Node next;
        while (current != null) {
            next = current.next; // Store next node
            current.next = prev; // Reverse the link
            prev = current;      // Move prev forward
            current = next;      // Move current forward
        }
        head = prev; // Update head
    }

    // Recursive method to reverse the linked list
    public Node reverseRecursive(Node node) {
        if (node == null || node.next == null) {
            return node; // Base case
        }
        Node newHead = reverseRecursive(node.next);
        node.next.next = node;
        node.next = null;
        return newHead;
    }
}

public class ReverseLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList list = new LinkedList();

        // Input linked list elements
        System.out.print("Enter number of elements: ");
        int n;
        try {
            n = sc.nextInt();
            if (n < 0) {
                System.out.println("Number of elements cannot be negative.");
                return;
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter an integer.");
            return;
        }

        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            try {
                list.append(sc.nextInt());
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter integers only.");
                return;
            }
        }

        System.out.println("Original List:");
        list.printList();

        // Iterative reversal
        list.reverseIterative();
        System.out.println("Reversed List (Iterative):");
        list.printList();

        // Recursive reversal
        list.head = list.reverseRecursive(list.head);
        System.out.println("Reversed Back (Recursive):");
        list.printList();

        sc.close();
    }
}
