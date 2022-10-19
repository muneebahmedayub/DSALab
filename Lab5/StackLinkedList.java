package Lab5;

public class StackLinkedList {
    Node head;
    Node tail;

    StackLinkedList() {
    }

    public void push(int value) {
        Node node = new Node(value);

        if(this.head == null) {
            node.next = null;
            this.head = node;
            return;
        }

        Node current = this.head;
        while(current.next != null) {
            current = current.next;
        }

        current.next = node;

    }

    public void pop() {
        if(this.head == null) {
            System.out.println("Stack is Empty...");
            return;
        }

        this.head = this.head.next;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int peek() {
        if(isEmpty()) { 
            System.out.println("The Stack is empty!!! (Will return -1)");
            return -1;
        }
        return head.data;
    }
}

class Node {
    int data;
    Node next;
    Node(int value) {
        this.data = value;
    }
}
