package Lab6;

public class LinearQueue_Array {
    int[] queue;
    int firstIndex;
    int lastIndex;

    LinearQueue_Array(int size) {
        queue = new int[size];
        firstIndex = -1;
        lastIndex = -1;
    }

    public void enQueue(int value) {
        if(queue != null) {
            if(lastIndex < queue.length-1) {
                queue[++lastIndex] = value;
                firstIndex = firstIndex == -1 ? 0 : firstIndex;
                return;
            }
            System.out.println("Queue is full or it may have filled the rear.");
        }
    }

    public void deQueue() {
        if(firstIndex <= lastIndex) {
            firstIndex++;
        }
        if(firstIndex > lastIndex) {
            firstIndex = lastIndex = -1;
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
        return lastIndex == queue.length - 1 || queue == null;
    }

    public void deleteQueue() {
        queue = null;
    }

    public void printQueue() {
        try {
            for(int i= firstIndex; i<=lastIndex; i++) {
                System.out.print(queue[i] + " ");
            }
        } catch (Exception e) {
            System.out.println("Cannot read deleted Queue");
        } finally {
            System.out.println();
        }
    }
}
