package Lab2;

import java.util.HashMap;
import java.util.Scanner;

public class Lab2 {
  static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    activity1();
  }

  public static void activity1() {
    int[] arr1 = { 1, 5, 7, 4, 3, 5 };
    int[] arr2 = { 4, 2, 6, 1 };

    arr2 = arr1;

    for (int i : arr2) {
      System.out.print(i + " ");
    }
  }

  public static void activit5() {
    System.out.print("Enter the length of the array: ");
    int length = Integer.parseInt(sc.next());
    if (length <= 0) {
      System.out.println("Length should be greater than zero.");
    }
    int[] arr = new int[length];
    System.out.println("Enter array values: ");
    for (int i = 0; i < arr.length; i++) {
      int value = Integer.parseInt(sc.next());
      arr[i] = value;
    }

    System.out.print("Enter position you want to change: ");
    int k = Integer.parseInt(sc.next());

    System.out.print("Enter value you want to change to: ");
    int value = Integer.parseInt(sc.next());

    if (k < 0 && k >= arr.length) {
      System.out.println("The position should be less than the size");
      return;
    }

    for (int j = arr.length - 2; j >= k; j--) {
      arr[j + 1] = arr[j];
    }
    arr[k] = value;

    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
  }

  static void activit6() {
    int[] arr = { 1, 2, 3, 4, 5, 6, 7 };

    System.out.print("Enter value you want to delete: ");
    int valueToDelete = Integer.parseInt(sc.next());
    int valuePosition = -1;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == valueToDelete) {
        valuePosition = i;
      }
    }

    if (valuePosition == -1) {
      System.out.println("Value not found in array");
      return;
    }

    for (int i = valuePosition; i < arr.length - 1; i++) {
      arr[i] = arr[i + 1];
    }
    arr[arr.length - 1] = 0;

    for (int i : arr) {
      System.out.print(i + " ");
    }

  }

  static void labAssignment1() {
    int[] arr = { 1, 2, 3, 4, 4, 5, 6, 6, 6, 8 };

    for (int i = 0; i < arr.length - 1; i++) {
      if (arr[i] == arr[i + 1]) {
        System.out.println("index " + i + " and index " + (i + 1) + " have same values: " + arr[i]);
      }
    }
  }

  static void labAssignment2() {
    int[] arr = { 1, 2, 3, 4, 4, 5, 6, 6, 6, 8 };

    HashMap<Integer, Integer> values = new HashMap<Integer, Integer>();
    for (int i = 0; i < arr.length; i++) {
      Integer occurance = values.get(arr[i]);
      if (occurance == null) {
        values.put(arr[i], 1);
        continue;
      }

      occurance++;
      values.put(arr[i], occurance);
    }
    // for (HashMap.Entry<Integer, Integer> value : values.entrySet()) {

    // }
    // int[] valuesArr = values.values().toArray();
    // System.out.println(values.values());
    // System.out.println(IntStream.range(0,
    // values.values().toArray().length).filter(i -> values.values()[i]));

  }
}