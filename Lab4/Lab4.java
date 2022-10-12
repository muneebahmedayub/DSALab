package Lab4;

public class Lab4 {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insert(1, 0);
        list.insert(2, 0);
        list.insert(3, 0);
        list.insert(4, 0);
        list.insert(5, 0);
        list.insert(6, 0);
        list.insert(7, 0);

        list.printForward();
        list.printInverse();
        list.get(3);
        list.get(1);
        list.search(2);


        list.deleteNodeAt(2);
        list.printForward();
    }
}
