package Lab6;

public class Lab6 {
    public static void main(String[] args) {
        CircularQueue_Array lqa = new CircularQueue_Array(5);
        lqa.enQueue(10);
        lqa.enQueue(20);
        lqa.enQueue(30);
        lqa.enQueue(40);
        lqa.enQueue(50);
        lqa.enQueue(50);
        // lqa.enQueue(60);
        lqa.deQueue();
        // lqa.deQueue();
        // lqa.deQueue();
        // lqa.deQueue();
        // lqa.deQueue();
        // lqa.deQueue();
        // lqa.deQueue();
        // lqa.deQueue();
        // lqa.deleteQueue();
        // lqa.enQueue(10);
        lqa.enQueue(20);
        // lqa.enQueue(30);
        // lqa.enQueue(40);
        // lqa.enQueue(50);
        // System.out.println(lqa.lastIndex);
        lqa.printQueue();
        System.out.println(lqa.isFull());
    }
}
