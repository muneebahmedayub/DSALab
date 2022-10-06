package LabHomeActivity2;

import java.util.ArrayList;

public class Task4 {

  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<Integer>();
    list.add(4324);
    list.add(4234);
    list.add(42342);
    list.add(2423);
    list.add(4323);
    list.add(43223);
    list.add(2333);

    list.remove(2);
    list.set(2, 524);

    System.out.println("Size: " + list.size());
    System.out.println(list);
    System.out.println("3th element: " + list.get(2));
    list.clear();
    System.out.println(list);

  }
}
