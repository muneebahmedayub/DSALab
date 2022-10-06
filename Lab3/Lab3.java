package Lab3;

public class Lab3 {
  public static void main(String[] args) {
    SinglyLinkedList list = new SinglyLinkedList();

    list.insert(42, 0);
    list.insert(634, 0);
    list.insert(523, 0);
    list.insert(6678, 0);

    list.insert(312, 10);
    list.insert(432, 5);
    list.insert(32, 3);
    list.insert(502, 2);
    list.insert(502, 2);
    list.display();
    list.searchByIndex(7);
    list.searchByValue(432);

  }

}
