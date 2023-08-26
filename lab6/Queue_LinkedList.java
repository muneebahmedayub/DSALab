package lab6;
public class Queue_LinkedList {
	private class Node {
        int value;
        Node next;
    }
    Node head;
    Node tail;
    int size=0;
    public void push(int nodeValue) {
        Node node = new Node();
        node.value = nodeValue;
        if (isEmpty()) {
            node.next = null;
            head = tail = node;
            size++;
            return;
        }
        tail.next = node;
        node.next = null;
        tail = node;
        size++;
    }
    public void pop() {
        if (isEmpty()) {
        	System.out.println("Queue is empty");
        	return;
        }
            head = head.next;
            size--;
    }
    public boolean isEmpty() {
        return head == null;
    }
    public int peekFirst() {
        return head.value;
    }
    public int peekLast() {
        return tail.value;
    }
    public int getCurrentSize() {
        return size;
    }
    public void printQueue() {
        Node tempNode = head;
        int counter=0;
        while (counter<getCurrentSize()) {
            System.out.print(tempNode.value + " ");
            counter++;
            tempNode = tempNode.next;
        }
    }
    public static void main (String args[]){
    	Queue_LinkedList ql=new Queue_LinkedList();
    	ql.push(100);
    	ql.push(10);
    	ql.push(20);
    	ql.push(5);
    	ql.push(50);
    	ql.push(500);
    	ql.printQueue();
    	ql.pop();
    	System.out.println();
    	ql.printQueue();
    }
}
