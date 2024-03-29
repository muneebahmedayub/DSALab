package Lab4;

public class DoublyLinkedList {
    int length;
    Node head;
    Node tail;
    
    DoublyLinkedList() {
        this.length = 0;
    }

    public void insert(int value, int location) {
        Node node = new Node(value);

        if(this.head == null) {
            this.head = node;
            this.tail = node;
            this.length++;
            return;
        }

        if(location <= 0) {
            node.next = this.head;
            this.head.previous = node;
            this.head = node;
            length++;
            return;
        }
        
        if(location > this.length) {
            node.previous = this.tail;
            this.tail.next = node;
            this.tail = node;
            length++;
            return;
        }

        Node temp = this.head;
        for(int i=0; i<length-1; i++) {
            temp = temp.next;
        }
        Node next = temp.next;
        next.previous = node;
        node.next = next;
        node.previous = temp;
        temp.next = node;
        length++;
    }

    public void printForward() {
        Node temp = this.head;

        if(temp == null) {
            System.out.println("This list is empty! ");
            return;
        }

        while(temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void printInverse() {
        Node temp = this.tail;

        if(temp == null) {
            System.out.println("This list is empty! ");
            return;
        }

        while(temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.previous;
        }

        System.out.println("null");
    }

    public void get(int index) {
        if(index < 0 || index > this.length) {
            System.out.println("Index out of bound...");

        }
        Node temp = this.head;
        for(int i=0; i<index; i++) {
            temp = temp.next;
        }

        System.out.println(temp.data);
    }

    public void search(int value) {
        Node temp = this.head;
        Boolean isFound = false; 
        int i;
        for(i=0; temp != null; i++) {
            if(temp.data == value) {
                isFound = true;
                break;
            }
            temp = temp.next;
        }

        if(isFound) {
            System.out.println("The value is found in index: " + i);
        } else {
            System.out.println("The value not found...");
        }
    }

    public void deleteEntireList() {
        this.head = this.tail = null;
    }

    public void deleteNodeAt(int location) {
        if(this.head == null) {
            System.out.println("The list is empty...");
            return;
        }

        if(location > this.length) {
            System.out.println("Node not found at index " + location);
            return;
        }
        
        if(location == 0) {
            this.head = this.head.next;
            this.head.previous = null;
            return;
        }
        if(location == this.length - 1) {
            this.tail = this.tail.previous;
            this.tail.next = null;
            return;
        }

        Node current = this.head;

        for(int i=0; i<location-1; i++) {
            current = current.next;
        }
        Node nextCurrent = current.next.next;
        current.next = nextCurrent;
        nextCurrent.previous =  current;
    }

    void deleteAtEnd() {
        if(this.tail == null) {
            System.out.println("List is empty...");
            return;
        }

        this.tail = this.tail.previous;
        this.tail.next = null;
    }

    void deleteAtHead() {
        if(this.head == null) {
            System.out.println("List is empty...");
            return;
        }

        this.head = this.head.next;
        this.head.previous = null;
    }
    
}

class Node {
    Node previous;
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}
