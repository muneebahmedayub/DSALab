package LabHomeActivity7;

public class LabHomeActivity7 {
    public static void main(String[] args) {
        maxHeapLinkedList();
    }

    public static void maxHeap() {
        System.out.println("The Max Heap is ");
        MaxHeap maxHeap = new MaxHeap(15);
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);
        maxHeap.maxHeap();

        maxHeap.print();
        System.out.println("The max val is " + maxHeap.remove());
    }

    public static void maxHeapLinkedList() {
        MaxHeapLinkedList heap = new MaxHeapLinkedList();
        int list[] = { 99, 4, 34, 67, 23, 5, 34, 4, 322, 2 };
        for (int i = 0; i < list.length; i++) {
            heap.insert(list[i]);
        }
        heap.printLevelOrder();
    }
}
