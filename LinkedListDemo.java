// Node class
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;   
        this.next = null;
    }
}

// Linked List Operations 
class LLoperation {
    private Node head = null;
    private int size = 0;

    // get(int index) - get values based on index 
    public String get(int index) {
        if (index < 0 || index + 1 > size || head == null) return "Invalid Index";
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return String.valueOf(temp.data);
    }

    // set(int data, int index) - set or reasign data based on index
    public String set(int data, int index) {
        if (index < 0 || index + 1 > size || head == null) return "Invalid Index";

        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        temp.data = data;
        return "Successfully Updated";
    }

    // search(int data) - if data is exeist return index else return false
    public String search(int data) {
        Node temp = head;
        while (temp != null) {
            if(temp.data == data) {
                return String.valueOf("Yes! "+ data +" value is exsist");
            }
            temp = temp.next;
        }
        return "Not Found";
    }

    // insertIndex(int data, int index) - insert the value based on index 
    public String insertIndex(int data, int index) {
        if (index < 0 || index + 1 > size) return "Invalid Index";

        Node newNode = new Node(data);
        Node temp = head;
        size++;
        for (int i = 0; i < index-1; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        return "Successfully Inserted";
    }

    // insertAtBegining(int data) - insert the data at begining
    public String insertAtBegining(int data) {
        Node newNode = new Node(data);
        Node temp = head;
        size++;
        if (temp == null) {
            head = newNode;
            return "Inserted";
        }

        newNode.next = temp;
        head = newNode;
        return "Inserted";
    }

    // insertAtLast(int data) - insert the data at last
    public String insertAtLast(int data) {
        Node newNode = new Node(data);
        Node temp = head;
        size++;
        if (temp == null) {
            temp = newNode;
            head = temp;
            return "Inserted";
        }
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode; 
        return "Inserted";
    }

    // deleteAtValue(int data) - if data is exeist delete else return not found
    public String deleteAtValue(int data) {
        Node temp = head;
        if (head == null) return "Storage is empty!";
        size--;
        if (temp.next == null && temp.data == data) {
            head = null;
            return "Deleted Successfully";
        }
        else if (temp.data == data) {
            head = temp.next;
            return "Deleted Successfully";
        }
        while (temp.next != null && temp.next.next != null) {
            if (temp.next.data == data) {
                temp.next = temp.next.next;
                return "Deleted Successfully";
            }
            temp = temp.next;
        }

        if (temp.next.data == data) {
            temp.next = null;
            return "Deleted Successfully";
        }
        size++;
        return "Value Not Found";
    }

    // deleteIndex(int index) - delete a data based on index
    public String deleteIndex(int index) {
        Node temp = head;
        if (index < 0 || index + 1 > size || head == null) return "Invalid Index";
        if (index == 0) head = temp.next;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        size--;
        return "Deleted";
    }

    // deleteAll() - delete all data
    public String deleteAll() {
        head = null;
        return "All data is deleted";
    }
    // display() - print all elements 
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
    }    
}

// Main class
public class LinkedListDemo {
    public static void main(String[] args) {
        LLoperation lLoperation = new LLoperation();

        System.out.println(lLoperation.insertAtLast(801));
        System.out.println(lLoperation.insertAtBegining(333));
        System.out.println(lLoperation.get(4));
        System.out.println(lLoperation.set(24,1));
        System.out.println(lLoperation.get(1));
        System.out.println(lLoperation.search(33));
        System.out.println(lLoperation.insertIndex(100, 1));
        System.out.println(lLoperation.search(100));
        lLoperation.display();
        System.out.println(lLoperation.insertAtBegining(222));
        System.out.println(lLoperation.insertAtLast(108));
        // System.out.println(lLoperation.deleteAtValue(100));
        System.out.println(lLoperation.deleteAtValue(303));        
        System.out.println(lLoperation.deleteAll());  
        System.out.println(lLoperation.deleteIndex(3));    
        System.out.println(lLoperation.get(4));
        System.out.println(lLoperation.search(108));
        System.out.println(lLoperation.insertAtLast(801));
        System.out.println(lLoperation.insertAtBegining(333));
        System.out.println(lLoperation.insertIndex(100, 1));
        lLoperation.display();

        // get(int index) - get values based on index 
        // set(int data, int index) - set or reasign data based on index
        // search(int data) - if data is exeist return index else return false
        // insertIndex(int data, int index) - insert the value based on index 
        // insertAtBegining(int data) - insert the data at begining
        // insertAtLast(int data) - insert the data at last
        // deleteAtValue(int data) - if data is exeist delete else return not found
        // deleteIndex(int index) - delete a data based on index
        // deleteAll() - delete all data
        // display() - print all elements 

    }
    
}
