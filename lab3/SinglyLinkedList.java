package lab3;
public class SinglyLinkedList {
    private Node head;
    private Node tail;
    private int size; // .... stores the number of nodes Linked List has
    public SinglyLinkedList() {
    }
    private class Node {
        int value;
        Node next;
        public Node(int value) {
        this.value = value;
        }
    }
    public static void main(String[] args) {
    	SinglyLinkedList sl=new SinglyLinkedList();
    	sl.insert(20, 0);
    	sl.insert(30, 0);
    	sl.insert(30, 2);
    }
    // Code for inserting element in Singly Linked list
    public void insert(int nodeValue, int nodeLocation) {
        Node node = new Node(nodeValue);
        if (head == null) {//The list is initially empty
            node.next = null;
            head = node;
            tail = node;
            return;
        } else if (nodeLocation <= 0) {// Insertion at first position
            node.next = head;
            head = node;
        } else if (nodeLocation >= size) {//insertion at last position
            tail.next = node;
            tail = node;
        } else {//insertion at any random position other than start and end
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
    // Code for traverstin all emelemets 
    public void print() {
        if (head == null) {
            System.out.println("The list is empty!");
        } else {
            Node tempNode = head;
            while (tempNode.next != null) {
                System.out.print(tempNode.value + " ");
                tempNode = tempNode.next;
            }
            System.out.print(tempNode.value + " ");
        }
    }
    // search at a specific index
    public void searchAtSpecificIndex(int index) {
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
System.out.println("The value at index "+index +" is "+tempNode.value);
    	
    }
    // Search specified value in list
    public void searchSpecificValue(int value) {
        boolean found=false;
    	int counter = 0;
        Node tempNode = head;
        while (tempNode.next != null) {
        	if(tempNode.value==value){
        	found=true;
        	break;
        	}
            tempNode = tempNode.next;
            counter++;            
        }
        if(found)
        	System.out.println("The value " + tempNode.value + 
		 " is found in Node " + counter);
        else 
        	System.out.println("The vaue is not "
        			+ "present in the list");
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
        } else if (index <= 0) { // delete head
            head = head.next;
        } else if (index >= size) { // delete tail
            Node tempNode = head;
            while (tempNode.next != tail) {
                tempNode = tempNode.next;
            }
            tempNode.next = null;
            tail = tempNode;
        } else { // delete node somewhere in between head and tail
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
    
    	//sl.deleteEntireList();
    	//sl.searchSpecificValue(30);;
    	//sl.print();
        //Linked a=new Linked();
        //root=a.insert(root,12);
        //root=a.insert(root,2);
        //root=a.insert(root,3);
        //root=a.insert(root,4);
        //a.printLinkedList(root); 
        
    

}


