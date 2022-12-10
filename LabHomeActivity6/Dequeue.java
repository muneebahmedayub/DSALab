package LabHomeActivity6;

public class Dequeue {
    Node head, tail;
    void insertAtHead(int data){
        Node newNode = new Node(data);
        if(head==null){
            head = newNode;
            tail = newNode;
            return;
        } 
        newNode.next = head;
        head = newNode;
    }
    void insertAtTail(int data){
        Node newNode = new Node(data);
        if(head==null){
            head = newNode;
            tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }
    void removeAtHead(){
        if(head==null){
            System.out.println("Already empty.");
            return;
        } 
        System.out.println(head.data);
        head = head.next;
    }
    void removeAtTail(){
        if(head==null){
            System.out.println("Empty queue");
            return;
        } 
        Node temp = head;
        while(temp.next == tail){
            temp = temp.next;
        }
        System.out.println("Poped data: "+tail.data);
        tail = temp;
    }

    void printQueue(){
        Node temp = head;
        while(temp.next != null){
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
        System.out.println(temp.data);
    }
}
