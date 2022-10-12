package LabHomeActivity4;

public class CircularDoublyLinkedList {
    int length;
    Node head;
    Node tail;
    
    CircularDoublyLinkedList() {
        this.length = 0;
    }

    public void insert(int value, int location) {
        Node node = new Node(value);

        if(this.head == null) {
            node.next = node;
            node.previous = node;
            this.head = node;
            this.tail = node;
            this.length++;
            return;
        }

        if(location <= 0) {
            node.next = this.head;
            node.previous = this.tail;
            this.tail.next = node;
            this.head.previous = node;
            this.head = node;
            length++;
            return;
        }
        
        if(location >= this.length) {
            node.previous = this.tail;
            node.next = this.head;
            this.head.previous = node;
            this.tail.next = node;
            this.tail = node;
            length++;
            return;
        }

        Node temp = this.head;
        for(int i=0; i<location-1; i++) {
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

        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while(temp != this.head);
        System.out.println("head");
    }

    public void printInverse() {
        Node temp = this.tail;

        if(temp == null) {
            System.out.println("This list is empty! ");
            return;
        }

        do {
            System.out.print(temp.data + " -> ");
            temp = temp.previous;
        } while(temp != this.tail);

        System.out.println("tail");
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
        int i=0;
        do {
            if(temp.data == value) {
                isFound = true;
                break;
            }
            temp = temp.next;
            i++;
        } while(temp != this.head);

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
            this.head.previous = this.tail;
            this.tail.next = this.head;
            return;
        }
        if(location == this.length - 1) {
            this.tail = this.tail.previous;
            this.tail.next = this.head;
            this.head.previous = this.tail;
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
        this.tail.next = this.head;
        this.head.previous = this.tail;
    }

    void deleteAtHead() {
        if(this.head == null) {
            System.out.println("List is empty...");
            return;
        }

        this.head = this.head.next;
        this.head.previous = this.tail;
        this.tail.next = this.head;
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
