package LabHomeActivity7;

public class MaxHeap {
    private int[] headData;
    private int size;
    private int maxSize;
    private static final int FRONT = 1;

    public MaxHeap(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        headData = new int[this.maxSize + 1];
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
        if (pos >= (size / 2) && pos <= size) {
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

    private void maxHeapify(int pos) {
        if (!isLeaf(pos)) {
            if (headData[pos] < headData[leftChild(pos)] || headData[pos] < headData[rightChild(pos)]) {
                if (headData[leftChild(pos)] > headData[rightChild(pos)]) {
                    swap(pos, leftChild(pos));
                    maxHeapify(leftChild(pos));
                } else {
                    swap(pos, rightChild(pos));
                    maxHeapify(rightChild(pos));
                }
            }
        }
    }

    public void insert(int element) {
        headData[++size] = element;
        int current = size;

        while (headData[current] > headData[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public void print() {
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(" PARENT : " + headData[i] + " LEFT CHILD : " + headData[2 * i]
                    + " RIGHT CHILD :" + headData[2 * i + 1]);
            System.out.println();
        }
    }

    public void maxHeap() {
        for (int pos = (size / 2); pos >= 1; pos--) {
            maxHeapify(pos);
        }
    }

    public int remove() {
        int popped = headData[FRONT];
        headData[FRONT] = headData[size--];
        maxHeapify(FRONT);
        return popped;
    }
}
