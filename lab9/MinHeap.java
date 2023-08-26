package lab9;
import java.util.Scanner;
class Heap {
	private int[] heapData;
	private int sizeOfHeap;
	private int heapMaxSize;
	private static final int FRONT = 1;
	public Heap(int heapMaxSize) {
		this.heapMaxSize = heapMaxSize;
		this.sizeOfHeap = 0;
		heapData = new int[this.heapMaxSize + 1];
		heapData[0] = Integer.MIN_VALUE;
	}
	private int getParentPosition(int position) {
		return position / 2;
	}
	private int getLeftChildPosition(int position) {
		return (2 * position);
	}
	private int getRightChildPosition(int position) {
		return (2 * position) + 1;
	}
	private boolean checkLeaf(int position) {
		if (position >= (sizeOfHeap / 2) && position <= sizeOfHeap) {
			return true;
		}
		return false;
	}
	private void swap(int firstNode, int secondNode) {
		int temp;
		temp = heapData[firstNode];
		heapData[firstNode] = heapData[secondNode];
		heapData[secondNode] = temp;
	}
	private void minHeapify(int position) {
			if (!checkLeaf(position)) {
			if (heapData[position] > 
			heapData[getLeftChildPosition(position)]
					|| heapData[position] > 
			heapData[getRightChildPosition(position)]) {
				// swap with left child and then heapify the left child
				if (heapData[getLeftChildPosition(position)]
					< heapData[getRightChildPosition(position)]) {
					swap(position, getLeftChildPosition(position));
					minHeapify(getLeftChildPosition(position));
				} else {
					swap(position, getRightChildPosition(position));
					minHeapify(getRightChildPosition(position));
				}}}}
	public void insertNode(int data) {
		if (sizeOfHeap >= heapMaxSize) {
			return;
		}
		heapData[++sizeOfHeap] = data;
		int current = sizeOfHeap;
		while (heapData[current] 
				< heapData[getParentPosition(current)]) {
			swap(current, getParentPosition(current));
			current = getParentPosition(current);
		}
	}
	public void displayHeap() {
		System.out.println("PARENT NODE" + "\t" + 
	"LEFT CHILD NODE" + "\t" + "RIGHT CHILD NODE");
		for (int k = 1; k <= sizeOfHeap / 2; k++) {
			System.out.print(" " + heapData[k] + "\t\t" +
		heapData[2 * k] + "\t\t" + heapData[2 * k + 1]);
			System.out.println();
		}
	}
	public void designMinHeap() {
		for (int position = (sizeOfHeap / 2); position >= 1;
				position--) {
			minHeapify(position);
		}
	}
	public int removeRoot() {
		int popElement = heapData[FRONT];
		heapData[FRONT] = heapData[sizeOfHeap--];
		minHeapify(FRONT);
		return popElement;
	}
}
public class MinHeap {
	public static void main(String[] arg) {
		int heapSize;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of Min Heap");
		heapSize = sc.nextInt();
		Heap heapObj = new Heap(heapSize);
		for (int i = 1; i <= heapSize; i++) {
			System.out.print("Enter element: " + i);
			int data = sc.nextInt();
			heapObj.insertNode(data);
		}
		sc.close();
		heapObj.designMinHeap();
		System.out.println("The Min Heap is ");
		heapObj.displayHeap();
		System.out.println("After removing the minimum element"
				+ "(Root Node) " + heapObj.removeRoot() + 
				", Min heap is:");
		heapObj.displayHeap();
	}
}