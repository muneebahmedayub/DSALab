package LabHomeActivity2;

import java.util.Scanner;

public class Task1 {
  public static void main(String[] args) {
    int length = 5;
    int[] arr = new int[length];
    Scanner sc = new Scanner(System.in);
    int smallest = 0, largest = 0;
    {
      int i = 0;
      while (i < arr.length) {
        System.out.print("Enter " + (i + 1) + " value in array: ");
        try {
          int number = Integer.parseInt(sc.next());
          arr[i] = number;
          if (i == 0) {
            smallest = number;
            largest = number;
          } else if (number < smallest) {
            smallest = number;
          } else if (number > largest) {
            largest = number;
          }
        } catch (NumberFormatException e) {
          System.out.println("Please enter a number");
          continue;
        }
        i++;
      }
    }
    sc.close();

    System.out.println("Smallest: " + smallest);
    System.out.println("Largest: " + largest);
  }
}
