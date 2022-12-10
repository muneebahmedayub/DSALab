package Lab6;

public class QueueLinkedList<T> {
    Node<T> head;
    Node<T> tail;
    int length;

    public void pop() {

    }

    public void push(T value) {
        Node<T> newNode = new Node<T>(value);
        if(this.head == null) {
            this.head = this.tail = newNode;
        }
    }
}
