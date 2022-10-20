package LabHomeActivity5;

public class LabHomeActivity5 {
    public static void main(String[] args) {
        InfixToPostfix iToP = new InfixToPostfix();
        InfixToPrefix iToPrefix = new InfixToPrefix();

        System.out.println(iToP.toPostfix("((a+b)*c)"));
        System.out.println(iToPrefix.toPrefix("((a+b)*c)"));
    }
}
