package Lab1;

import java.util.HashMap;
import java.util.Scanner;

public class Lab1 {
    static Scanner intsc = new Scanner(System.in);
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
//        task1();
//        task2();
//        task3();
//        task4();
//        task5();
//        task6();
//        task7();
//        task8();
//        task9();
//        task10();
//        int[] arr = {1,3,56,7,5,85,3};
//        int a = 0;
//        array_pass(arr, a);
//        for(int i: arr) {
//            System.out.println(i);
//        }
//        System.out.println("a = " + a);
        student();
    }

    static void task1() {
        System.out.println("Task1");
        System.out.println("Hello WOrld");
    }

    static void task2() {
        System.out.println("Task2");
        System.out.print("Enter int value: ");

        int num = intsc.nextInt();

        System.out.print("Enter double value: ");
        double myHeight = intsc.nextDouble();

        System.out.print("Enter String value: ");
        String myName = sc.nextLine();
        System.out.println(myName + " " + num + " " + myHeight);
    }

    static void task3() {
        System.out.println("Task3");
        String greeting = "Hello World";
        System.out.println(greeting);
    }

    static void task4() {
        System.out.println("Task4");
        int num1 = 14;
        int num2 = 20;
        int sum = num1 + num2;
        int product = num1 * num2;
        int diff = num2 - num1;
        double quotient = num2 / num1;

        System.out.println("Sum: " + sum);
        System.out.println("Product: " + product);
        System.out.println("Difference: " + diff);
        System.out.println("Quotient: " + quotient);
    }

    static void task5() {
        System.out.println("Task5");
        int num1 = 50;
        int num2 = 42;
        boolean condition = num1 > num2;
        if(condition) {
            System.out.println("True");
        }
    }

    static void task6() {
        System.out.println("Task6");
        int num1 = 90;
        int num2 = 31;

        if(num2 > num1) {
            System.out.println("Number 2 is greater");
        } else {
            System.out.println("Number 1 is greater");
        }
    }

    static void task7() {
        System.out.println("Task7");
        int i = 0;
        while(i<10) {
            System.out.println("I: " + i);
            i++;
        }
    }

    static void task8() {
        System.out.println("Task8");
        int i = 10;
        do{
            System.out.println("I: "+ i);
            i++;
        }while(i<10);
    }

    static void task9() {
        System.out.println("Task9");
        int num1 = 20;
        int num2 = 12;

        System.out.println(num1 + num2);
    }

    static void task10() {
        System.out.println("Task10");
        int[] arr = {1,2,4,5,6,57,68,3};

        for(int i: arr) {
            System.out.println(i);
        }
    }

    static void array_pass(int[] arr, int a) {
        System.out.println("Passing the Array to function");
        for(int i = 0; i<arr.length; i++) {
            arr[i] = arr[i] + 5;
            a = a + 1;
        }

    }

    static void student() {
        System.out.print("Enter the number of students: ");
        int length = intsc.nextInt();

        int highest = 0;

        HashMap<Integer, String> students = new HashMap<Integer, String>();

        for(int i = 0; i<length; i++) {
            System.out.print("Enter Name of student: ");
            String name = sc.nextLine();
            System.out.print("Enter Score of "+name+": ");
            int score = intsc.nextInt();

            students.put(score, name);
            if(score>highest) {
                highest = score;
            }
        }
        System.out.println("Name: " + students.get(highest));
        System.out.println("Score: " + highest);
    }

}
