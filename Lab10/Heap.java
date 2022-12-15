package Lab10;

public class Heap {
    private int[] headData;
    private int sizeOfHeap;
    private int heapMaxSize;
    private static final int FRONT = 1;

    public Heap(int maxSize) {
        this.heapMaxSize = maxSize;
        this.sizeOfHeap = 0;
        headData = new int[this.heapMaxSize + 1];
        headData[0] = Integer.MAX_VALUE;
    }

    private int parent(int pos) {
        return pos / 2;
    }

    private int leftChild(int pos) {
        return (2 * pos);
    }

    private int rightChild(int pos) {
        return (2 * pos) + 1;
    }

    private boolean isLeaf(int pos) {
        if (pos >= (sizeOfHeap / 2) && pos <= sizeOfHeap) {
            return true;
        }
        return false;
    }

    private void swap(int fpos, int spos) {
        int tmp;
        tmp = headData[fpos];
        headData[fpos] = headData[spos];
        headData[spos] = tmp;
    }

    private void minHeapify(int pos) {
        if (!isLeaf(pos)) {
            if (headData[pos] > headData[leftChild(pos)] || headData[pos] > headData[rightChild(pos)]) {
                if (headData[leftChild(pos)] < headData[rightChild(pos)]) {
                    swap(pos, leftChild(pos));
                    minHeapify(leftChild(pos));
                } else {
                    swap(pos, rightChild(pos));
                    minHeapify(rightChild(pos));
                }
            }
        }
    }

    public void insert(int element) {
        headData[++sizeOfHeap] = element;
        int current = sizeOfHeap;

        while (headData[current] < headData[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public void print() {
        for (int i = 1; i <= sizeOfHeap / 2; i++) {
            System.out.print(" PARENT : " + headData[i] + " LEFT CHILD : " + headData[2 * i] + " RIGHT CHILD :" + headData[2 * i + 1]);
            System.out.println();
        }
    }

    public void minHeap() {
        for (int pos = (sizeOfHeap / 2); pos >= 1; pos--) {
            minHeapify(pos);
        }
    }

    public int remove() {
        int popped = headData[FRONT];
        headData[FRONT] = headData[sizeOfHeap--];
        minHeapify(FRONT);
        return popped;
    }
}
