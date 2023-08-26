package lab4;
public class DoublyLinkedList {
	private class Node{
        int value;
        Node next;
        Node previous;
        public Node(int value) {
            this.value = value;
        }
    } 
    public Node head;
    public Node tail;
    public int size;
    // insert Node
    public void insert(int nodeValue, int nodeLocation) {
        Node node = new Node(nodeValue);
        if (head == null) {
            node.previous = null;
            node.next = null;
            head = node;
            tail = node;
        } else if (nodeLocation <= 0) { // insert from head side
            node.next = head;
            head.previous = node;
            head = node;
        } else if (nodeLocation >= size) { // insert from tail side
            node.previous = tail;
            tail.next = node;
            tail = node;
        } else { // insert somewhere in between head and tail
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
        if (tempNode == null) {
            System.out.println("The list is empty");
            return;
        }
        while (tempNode.next != null) {
            System.out.print(tempNode.value + " ");
            tempNode = tempNode.next;
        }
        System.out.print(tempNode.value + "\n");
    }

    // Print list in reverse
    public void printInReverse() {
        Node tempNode = tail;
        if (tempNode == null) {
            System.out.println("The list is empty");
            return;
        }
        while (tempNode != null) {
            System.out.print(tempNode.value + " ");
            tempNode = tempNode.previous;
        }
       // System.out.print(tempNode.value + "\n");
    }

    // Get Value of specified index' node
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
        boolean isFound=false;
        Node tempNode = head;
                while (counter<=size) {
                	if(tempNode.value==value){
                		isFound=true;
                		break;
                	}
                    tempNode = tempNode.next;
                    counter++;
                }
                if(isFound)
        System.out.println("The value " +	value + 
        		" is found in Node " + counter);
                else
        System.out.println("The value " +	value + " not found ");
    }

    // Delete entire node list
    public void deleteEntireList() {
        head = tail = null;
    }

    // Remove node on specific location
    public void deleteNodeAt(int nodeLocation) {
        if (head == null) {
            System.out.println("The list is empty");
        } else if (nodeLocation <= 0) { // delete head
            head = head.next;
            head.previous = null;
        } else if (nodeLocation >= size) { // delete tail
            tail = tail.previous;
            tail.next = null;
        } else { // delete node somewhere in between head and tail
            int counter = 0;
            Node tempNode = head;
            while (counter < nodeLocation - 2) {
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
          public static void main(String[] args) {
        	DoublyLinkedList dll=new DoublyLinkedList();
        	dll.insert(20, 0);
        	dll.insert(10, 1);
        	dll.insert(100, 2);
        	dll.printInForward();
        //	dll.printInReverse();
        	//dll.deleteNodeAt(2);
        //	dll.printInForward();
        }
    
}
