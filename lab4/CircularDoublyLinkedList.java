package lab4;
public class CircularDoublyLinkedList {
    public Node head;
    public Node tail;
    public int size;

    public CircularDoublyLinkedList() {
    }
    // insert Node
    public void insert(int nodeValue, int nodeLocation) {
        Node node = new Node(nodeValue);
        if (head == null) {
            node.previous = node;
            node.next = node;
            head = node;
            tail = node;
            return;
        } else if (nodeLocation == 0) {
            node.next = head;
            head.previous = node;
            node.previous = tail;
            tail.next = node;
            head = node;
        } else if (nodeLocation >= size) {
            node.previous = tail;
            tail.next = node;
            node.next = head;
            head.previous = node;
            tail = node;
        } else {
            Node tempNode = head;
            int counter = 0;
            while (counter < nodeLocation - 1) {
                tempNode = tempNode.next;
                counter++;
            }
            Node nextNode = tempNode.next;
            tempNode.next = node;
            node.previous = tempNode;
            node.next = nextNode;
            nextNode.previous = node;
        }
        size++;
    }

    // Print list in forward
    public void printInForward() {
        Node tempNode = head;
        int counter = 0;
        while (counter <=size) {
            System.out.print(tempNode.value + " ");
            tempNode = tempNode.next;
            counter++;
        }
    }
    // Print list in reverse
    public void printInReverse() {
        Node tempNode = tail;
        int counter = 0;
        while (counter <= size) {
            System.out.print(tempNode.value + " ");
            tempNode = tempNode.previous;
            counter++;
        }
    }

    // Get Value of specified indexs' node
    public void get(int index) {
        int counter = 0;
        Node tempNode = head;
        if(index<0 || index > size)
    	{
    		System.out.println("Please enter a valid index");
    		return;
    	}
        while (counter < index) {
            tempNode = tempNode.next;
            counter++;
        }
        System.out.println(tempNode.value);
    }

    // Search for node by giving specified value
    public void search(int value) {
        int counter = 0;
        boolean isFound = false;
        Node tempNode = head;
        while (counter <= size) {
            if(tempNode.value == value){
                isFound = true;
                break;
            }
            tempNode = tempNode.next;
            counter++;
        }
        if(isFound){
            System.out.println("The check value " + tempNode.value + " is found in Node " + counter);
        } else {
            System.out.println("The search value is not found!");
        }
    }

    // Delete entire node list
    public void deleteEntireList() {
        head = tail = null;
    }

    // Remove node on specific location
    public void deleteNodeAt(int nodeLocation) {
        if (head == null) {
            System.out.println("The head is NULL, so nothing to delete!");
        } else if (nodeLocation <= 0) {
            head = head.next;
            head.previous = tail;
            tail.next = head;
        } else if (nodeLocation >= size) {
            tail = tail.previous;
            tail.next = head;
            head.previous = tail;
        } else {
            int counter = 0;
            Node tempNode = head;
            while (counter < nodeLocation - 1) {
                tempNode = tempNode.next;
                counter++;
            }
            Node nextNode = tempNode.next.next;
            tempNode.next = nextNode;
            nextNode.previous = tempNode;
        }
        size--;
    }

    // Node class
    private class Node{
        int value;
        Node next;
        Node previous;

        public Node(int value) {
            this.value = value;
        }
        
    }
    public static void main(String[] args) {
    	CircularDoublyLinkedList cdll=new CircularDoublyLinkedList();
    	cdll.insert(20, 0);
    	cdll.insert(10, 1);
    	cdll.insert(100, 2);
    	//dll.deleteEntireList();
    	cdll.printInForward();
    	cdll.printInReverse();
    }
}
