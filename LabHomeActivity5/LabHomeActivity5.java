package LabHomeActivity5;

import java.util.Scanner;

public class LabHomeActivity5 {
    public static void main(String[] args) {
        infixToPostfix();
        // infixToPrefix();
    }
    public static void infixToPostfix() {
        InfixToPostfix iToP = new InfixToPostfix();
        System.out.println(iToP.toPostfix("A+(B*C-(D/E)*G)*H"));
    }
    public static void infixToPrefix() {
        Scanner sc = new Scanner(System.in);
        InfixToPrefix iToP = new InfixToPrefix();

        System.out.print("Infix Expression: ");
        String s = sc.nextLine();

        System.out.print("Prefix Expression: "+iToP.infixToPrefix(s));

    }
}
