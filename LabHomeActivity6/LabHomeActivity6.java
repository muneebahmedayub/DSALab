package LabHomeActivity6;

public class LabHomeActivity6 {
    public static void main(String[] args) {
        // circularQueue();
        dequeue();
    }
    public static void dequeue() {
        Dequeue deq = new Dequeue();
        deq.insertAtHead(0);
        deq.insertAtHead(5);
        deq.insertAtHead(10);
        deq.insertAtTail(20);
        deq.insertAtTail(30);
        deq.insertAtTail(40);
        deq.printQueue();
    }
    public static void circularQueue() {
        CircularQueue cq = new CircularQueue();
        cq.enqueue(10);
        cq.enqueue(12);
        cq.enqueue(45);
        cq.enqueue(67);
        cq.dequeue();
        cq.enqueue(90);
        cq.enqueue(44);
        cq.enqueue(12);
        cq.print();
    }
}
