package LabHomeActivity4;

public class LabHomeActivity4 {
    public static void main(String[] args) {
        CircularDoublyLinkedList list = new CircularDoublyLinkedList();
        list.insert(1, 0);
        list.insert(2, 0);
        list.insert(100, 3);
        System.out.println(list.length);
        list.insert(98, 3);
        list.insert(78, 9);
        list.insert(52, 0);
        list.insert(12, 0);
        list.insert(402, 0);
        list.insert(123, 0);
        list.insert(65, 0);

        list.printForward();
        list.printInverse();
        list.get(3);
        list.get(1);
        list.search(2);


        list.deleteNodeAt(2);
        list.printForward();
        list.deleteAtEnd();
        list.deleteAtHead();
        list.printForward();
    }
}
