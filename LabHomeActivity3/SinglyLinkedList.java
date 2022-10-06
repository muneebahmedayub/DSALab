package LabHomeActivity3;

public class SinglyLinkedList {
  private Node head;
  private Node tail;
  private int length;

  SinglyLinkedList() {
    this.length = 0;
  }

  Node getHead() {
    return this.head;
  }

  void insert(int data, int nodeLocation) {
    Node newNode = new Node(data);

    if (this.head == null) {
      this.head = newNode;
      this.tail = newNode;
      this.length++;
      return;
    }

    if (nodeLocation <= 0) {
      newNode.next = this.head;
      this.head = newNode;
      this.length++;
      return;
    }

    if (nodeLocation >= length) {
      this.tail.next = newNode;
      this.tail = newNode;
      this.length++;
      return;
    }

    Node current = this.head;
    for (int i = 0; i < nodeLocation - 1; i++) {
      current = current.next;
    }
    Node temp = current.next;
    newNode.next = temp;
    current.next = newNode;
    length++;

  }

  public void searchByIndex(int index) {
    if (index < 0 || length < index) {
      System.out.println("Index out of bound");
      return;
    }

    if (head == null) {
      System.out.println("List is empty...");
    }

    Node temp = this.head;
    for (int i = 0; i < index; i++) {
      temp = temp.next;
    }

    System.out.println("The data at index " + index + " is " + temp.data);

  }

  public void searchByValue(int value) {
    if (value == this.tail.data) {
      System.out.println("Value " + this.tail.data + " found at index " + (length - 1));
      return;
    }
    Node temp = this.head;
    int index = 0;
    while (temp != null) {
      if (temp.data == value) {
        System.out.println("Value " + temp.data + " found at index " + index);
        return;
      }
      temp = temp.next;
      index++;
    }
    System.out.println("Value not found!");
  }

  public int getLength() {
    return this.length;
  }

  public void display() {
    if (this.head == null) {
      System.out.println("List is empty!");
      return;
    }
    Node current = this.head;
    while (current != null) {
      System.out.print(current.data + " --> ");
      current = current.next;
    }
    System.out.println("null");

  }

  // Home Activity Assignment Questions
  void reverse() {
    Node prev = null;
    Node current = head;
    Node next = null;

    while (current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }
    head = prev;
  }

  void segregateEvenOdd() {
    Node prev = null;
    Node current = head;
    Node end = head;

    while (end.next != null)
      end = end.next;

    Node new_end = end;

    while (current.data % 2 != 0 && current != end) {
      end.next = current;
      current = current.next;
      new_end = new_end.next;
      new_end.next = null;
    }

    if(current.data % 2 == 0) {
      head = current;

      while(current != end) {
        if(current.data % 2 == 0) {
          prev = current;
          current = current.next;
        } else {
          prev.next = current.next;
          current.next = null;
          new_end.next = current;
          new_end = new_end.next;
          current = prev.next;
        }
      }
    } else {
      prev = current;
    }

    if(new_end != end && end.data % 2 != 0) {
      prev.next = end.next;
      end.next = null;
      new_end.next = end;
    }
  }

  void swapNodes(int x, int y) {
    if(x == y) return;

    Node prevX = null, currentX = head;
    while(currentX != null && currentX.data != x) {
      prevX = currentX;
      currentX = currentX.next;
    }

    Node prevY = null, currentY = head;
    while(currentY != null && currentY.data != y) {
      prevY = currentY;
      currentY = currentY.next;
    }

    if(currentX == null || currentY == null) return;

    if(prevX != null) {
      prevX.next = currentY;
    } else {
      head = currentY;
    }

    if(prevY != null) {
      prevY.next = currentX;
    } else {
      head = currentX;
    }

    Node temp = currentX.next;
    currentX.next = currentY.next;
    currentY.next = temp;
  
  }

}

class Node {
  int data;
  Node next;

  Node(int data) {
    this.data = data;
  }
}