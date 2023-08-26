package lab6;
public class LinearQueue_Array {
    int[] queue;
    int lastIndex;
    int firstIndex;
    public LinearQueue_Array(int size) {
        queue = new int[size];
        lastIndex = -1;
        firstIndex = -1;
    }
    public void enQueue(int value) {
        if (lastIndex < queue.length - 1) {
            queue[++lastIndex] = value;
            firstIndex = (firstIndex == -1)?0:firstIndex;
            return;
        }
        System.out.println("Queue is Full or it may have filled once but not emptied. To use again, empty first!");
    }

    public void deQueue() {
        if (firstIndex <= lastIndex) {
            firstIndex++;
        }
        if (firstIndex > lastIndex) {
            firstIndex = lastIndex = -1;
        }
    }
    public int peekFirst() {
        if (isEmpty()) {
            return -1;
        }
        return queue[firstIndex];
    }
    public int peekLast() {
        if (isEmpty()) {
            return -1;
        }
        return queue[lastIndex];
    }
    public boolean isEmpty() {
        return firstIndex == -1 || queue == null;
    }
    public boolean isFull() {
        return lastIndex == queue.length - 1 
        		|| queue == null;
    }
    public void deleteQueue() {
        queue = null;
    }

    public void printQueue() {
        try {
            for (int i = firstIndex; i <= lastIndex; i++) {
                System.out.print(queue[i] + " ");
            }
        } catch (Exception ex) {
            System.out.println("Cannot read deleted Queue!!!");
        }
        System.out.println();
    }
    public static void main (String args[]){
    	LinearQueue_Array lqa=new LinearQueue_Array(5);
    	lqa.enQueue(10);
    	lqa.enQueue(20);
    	lqa.enQueue(5);
    	lqa.printQueue();
    	lqa.deQueue();
    	lqa.printQueue();
    }
}
