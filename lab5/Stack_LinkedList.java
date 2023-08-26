package lab5;
public class Stack_LinkedList {
	private class Node {
        int value;
        Node next;
    }
    Node head;
    Node tail;
    public Stack_LinkedList() {
    }
    public void push(int nodeValue) {
        Node node = new Node();
        node.value = nodeValue;
        if (head == null) {
            node.next = null;
            head = node;
            tail = node;
            return;
        }
        node.next = head;
        head = node;
    }
    public void pop() {
        if (isEmpty()) {
            System.out.println("The Stack is empty!!!");
            return;
        }
        head = head.next;
    }
    public boolean isEmpty() {
        return head == null;
    }
    public int peek() {
        if (isEmpty()) {
      System.out.println("The Stack is empty!!! (Will return -1)");
            return -1;
        }
        return head.value;
    }
    public void print() {
        if (isEmpty()) {
            System.out.println("The Stack is empty!!!");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    
    public static void main(String args[]){
    	Stack_LinkedList sl=new Stack_LinkedList();
    	sl.push(10);
    	sl.push(20);
    	sl.pop();
    	sl.pop();
    	System.out.println(sl.peek());
    	sl.print();
    }
}
