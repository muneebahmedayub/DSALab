package lab4;
public class CircularSinglyLinkedList {
    Node head;
    Node tail;
    int size;
    public CircularSinglyLinkedList() {
    }
    // insert Method for CSLL
    public void insert(int nodeValue, int nodeLocation) {
        Node node = new Node(nodeValue);
        if (head == null) {
            node.next = node;
            head = node;
            tail = node;
        } else if (nodeLocation <= 0) { // insert from head side
            node.next = head;
            head = node;
            tail.next = head;          // Important
        } else if (nodeLocation >= size) { // insert from tail side
            tail.next = node;
            tail = node;
            tail.next = head;
        } else { // insert somewhere in between head and tail
            Node tempNode = head;
            int indexCounter = 0;
            while (indexCounter < nodeLocation - 1) {
                tempNode = tempNode.next;
                indexCounter++;
            }
            Node nextNode = tempNode.next;
            tempNode.next = node;
            node.next = nextNode;
        }
        size++;
    }

    // Print method
    public void print() {
        Node tempNode = head;
        for (int i = 0; i <= size; i++) {
            System.out.print(tempNode.value + " ");
            tempNode = tempNode.next;
        }

    }

    // Get specific nodes' value
    public void get(int index) {
        Node tempNode = head;
        if(index<0 || index > size)
    	{
    		System.out.println("Please enter a valid index");
    		return;
    	}
        int counter = 0;
        while (counter < index) {
            counter++;
            tempNode = tempNode.next;
        }
        System.out.println(tempNode.value);
    }

    // Search specified value in list
    public void search(int value) {
        int counter = 0;
        boolean isFound = false;
        Node tempNode = head;
        while (counter <= size) {
            if (tempNode.value == value) {
                isFound = true;
                break;
            }
            tempNode = tempNode.next;
            counter++;
        }

        if (isFound) {
            System.out.println("The value " + tempNode.value + " is found in Node " + counter);
        } else {
            System.out.println("Value not found!");
        }

    }

    // Delete entire list
    public void deleteEntireList() {
        head = tail = null;
    }

    // Delete node at specified location 
    public void deleteNodeAt(int index) {
        if (head == null) {
            System.out.println("The list is empty!");
            return;
        } else if (index <= 0) {
            head = head.next;
            tail.next = head;
        } else if (index >= size) {
            Node tempNode = head;
            while (tempNode.next != tail) {
                tempNode = tempNode.next;
            }
            tempNode.next = head;
            tail = tempNode;
        } else {
            Node tempNode = head;
            int counter = 0;
            while (counter < index - 1) {
                tempNode = tempNode.next;
                counter++;
            }
            Node nextNode = tempNode.next.next;
            tempNode.next = nextNode;
        }
        size--;
    }
    // Node class
    private class Node {
        int value;
        Node next;
        public Node(int value) {
        this.value = value;
        }
    }
    public static void main(String[] args) {
    	CircularSinglyLinkedList csll=new CircularSinglyLinkedList();
    	csll.insert(20, 0);
    	csll.insert(10, 1);
    	csll.insert(100, 2);
    	//dll.deleteEntireList();
    	csll.print();
    }
}
