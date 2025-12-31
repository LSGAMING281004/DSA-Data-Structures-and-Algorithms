
class Node {
    int data;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head = null;

    void insertBegining(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    void insertLast(int data){

        if(head == null){
            insertBegining(data);
        }
        Node newNode = new Node(data);
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }

        temp.next = newNode;
    }

    void insertIndex(int index, int data){
        if(index < 0){
            System.out.println("Invalid Index");
            return;
        }
        Node temp = head;
        for(int i=0;i < index-1;i++){
            temp = temp.next; 
        }
        Node newNode = new Node(data); // 3 2 1 4  -ind = 2, val = 5
        newNode.next = temp.next;
        temp.next = newNode;
    }

    void delete(int data){
        Node temp = head;
        if(head.data == data){
            head = head.next;
            return;
        }
        while(temp.next != null && temp.next.data != data){
            temp = temp.next;
        }
        if(temp.next == null){
            System.out.println("Invalid Index");
            return;
        }
        temp.next = temp.next.next;
    }

    void deleteIndex(int index){
        if(index < 0){
            System.out.println("Invalid Index");
            return;
        }
        if(index == 0){
            head = head.next;
            return;
        }
        Node temp = head;
        for(int i=0;i < index-1;i++){
            temp = temp.next; 
        }

        temp.next = temp.next.next;
       
    }

    void search(int data){
        Node temp = head;
        while (temp != null) {
            if(temp.data == data){
                System.out.println("True");
                return;
            }
            temp = temp.next;
        }
        System.out.println("False");
    }

    void display(){
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("Null");
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertBegining(1); // 1
        list.insertBegining(2); // 2 1
        list.insertBegining(3); // 3 2 1

        list.insertLast(4);  // 3 2 1 4

        list.delete(2);  // 3 1 4

        list.deleteIndex(0); // 1 4

        
        list.display();

        list.search(3); // false
    }

}