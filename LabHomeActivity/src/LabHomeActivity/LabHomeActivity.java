package LabHomeActivity;

import java.util.Scanner;

public class LabHomeActivity {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the height of the pyramid: ");
        int n = sc.nextInt();
        sc.close();
        if (n < 2) {
            System.out.println("Sorry pyramid must have height of at least 2.");
            return;
        }

        int gap = n / 2;
        for (int i = 0; i <= n; i++) {
            int num = 1;
            // +(n*gap) is to make room for gaps on left side
            // -(i*gap) is to make the row starts before adjusting the gap for next elements
            for (int j = 0; j <= n - i + n - (i * gap) + (n * gap); j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print(String.format("%" + (gap + 1) + "s", num));
                num = num * 2;
            }
            num = num / 2;
            for (int j = 0; j <= i - 1; j++) {
                num = num / 2;
                System.out.print(String.format("%" + (gap + 1) + "s", num));
            }
            System.out.println();
        }
    }
}
