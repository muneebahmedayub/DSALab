package LabHomeActivity2;

import java.util.Scanner;

public class Task3 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    try {
      System.out.print("Enter the length of the fibonacci series: ");
      int length = Integer.parseInt(sc.next());

      int prev = 0, current = 1, next = 0;

      for (int i = 0; i < length; i++) {
        if (i <= 1) {
          next = i;
        } else {
          next = prev + current;
          prev = current;
          current = next;
        }
        System.out.print(next + " ");
      }

    } catch (NumberFormatException e) {
      System.out.println("Enter a number for length...");
    }
    sc.close();
  }
}
