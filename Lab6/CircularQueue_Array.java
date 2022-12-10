package Lab6;

public class CircularQueue_Array {
    int[] queue;
    int firstIndex;
    int lastIndex;
    int length;

    CircularQueue_Array(int size) {
        queue = new int[size];
        firstIndex = -1;
        lastIndex = -1;
        length = 0;
    }

    public void enQueue(int value) {
        if(queue != null) {
            System.out.println((lastIndex + 1) % queue.length + " " + firstIndex);
            if((lastIndex + 1) % queue.length != firstIndex) {
                lastIndex = (lastIndex + 1) % queue.length;
                queue[lastIndex] = value;
                firstIndex = firstIndex == -1 ? 0 : firstIndex;
                length++;
                return;
            }
            System.out.println("Queue is full or it may have filled the rear.");
        }
    }

    public void deQueue() {
        if(firstIndex <= lastIndex) {
            firstIndex = (firstIndex + 1) % queue.length;
            length--;

        }
        if(firstIndex > lastIndex) {
            firstIndex = lastIndex = -1;
            length = 0;
        }
    }

    public int peekFirst() {
        if(isEmpty()) {
            return -1;
        }
        return queue[firstIndex];
    }

    public int peekLast() {
        if(isEmpty()) return -1;

        return queue[lastIndex];
    }

    public boolean isEmpty() {
        return firstIndex == -1 || queue == null;
    }

    public boolean isFull() {
        return lastIndex == length - 1 || queue == null;
    }

    public void deleteQueue() {
        queue = null;
        length = 0;
    }

    public void printQueue() {
        // try {
            System.out.println(firstIndex + " " + lastIndex);
            for(int i=0; i<length; i++) {
                int index = firstIndex;
                System.out.print(i + " ");
            }
            // System.out.println(queue[queue.length]);
        // } catch (Exception e) {
        //     System.out.println("Cannot read deleted Queue");
        // } finally {
        //     System.out.println();
        // }
    }
}
