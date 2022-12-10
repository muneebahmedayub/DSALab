package LabHomeActivity6;

public class CircularQueue {

    Node head;
    Node tail;

    class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = tail.next;
        newNode.next = head;
    }

    public void dequeue() {
        head = head.next;
        tail.next = head;
    }

    public void print() {
        Node temp = head;
        while (temp.next != head) {
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
        System.out.println(temp.data);
    }
}