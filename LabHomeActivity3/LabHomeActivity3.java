package LabHomeActivity3;

public class LabHomeActivity3 {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        list.insert(42, 0);
        list.insert(634, 0);
        list.insert(523, 0);
        list.insert(6675, 0);
    
        list.insert(312, 10);
        list.insert(431, 5);
        list.insert(39, 3);
        list.insert(505, 2);
        list.insert(502, 2);
        list.display();

        System.out.println("Reversing List:");
        list.reverse();
        list.display();

        System.out.println("Seggregating Even and Odd");
        list.segregateEvenOdd();
        list.display();

        System.out.println("Swapping Nodes");
        list.swapNodes(523, 634);
        list.display();
    }
}
