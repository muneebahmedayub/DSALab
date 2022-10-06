package LabHomeActivity2;

public class Task2 {
  public static void main(String[] args) {
    int count = 0;
    for (int i = 101; i < 500; i += 2) {
      boolean isPrime = true;
      for (int j = 2; j < i / 2; j++) {
        if (i % j == 0) {
          isPrime = false;
          break;
        }
      }
      if (isPrime) {
        count++;
      }
    }

    int arr[] = new int[count];
    int index = 0;
    for (int i = 101; i < 500; i += 2) {
      boolean isPrime = true;
      for (int j = 2; j < i / 2; j++) {
        if (i % j == 0) {
          isPrime = false;
          break;
        }
      }
      if (isPrime) {
        arr[index] = i;
        index++;
      }
    }
    System.out.println("Count: " + count);
    for (int i : arr) {
      System.out.print(i + " ");
    }
  }
}
