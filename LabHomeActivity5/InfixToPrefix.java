package LabHomeActivity5;

import java.util.Scanner;

public class InfixToPrefix {
    Node top;

    int size;

    public InfixToPrefix(){

        top = null;
        size = 0;
    }

    private class Node{
        Node next;
        char data;
    }

    public void push(char value){

        Node node = new Node();
        node.data = value;

        node.next = top;
        top = node;
        size++;
    }

    public char pop() {
        char result = top.data;
        top = top.next;
        size--;
        return result;

    }

     public int precedence(char c){

        switch (c){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public char peek(){
        return top.data;
    }


    boolean isalpha(char c) {
        if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
            return true;
        }
        return false;
    }

    boolean isdigit(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        }
        return false;
    }

    boolean isOperator(char c) {
        return (!isalpha(c) && !isdigit(c));
    }

    int getPriority(char C) {
        if (C == '-' || C == '+')
            return 1;
        else if (C == '*' || C == '/')
            return 2;
        else if (C == '^')
            return 3;

        return 0;
    }

    public String infixToPrefix(String infix) {
        String prefix = "";
        InfixToPrefix stack = new InfixToPrefix();

        for (int i = infix.length() - 1; i >= 0; i--) {
            char symbol = infix.charAt(i);

            if (precedence(symbol) > 0) {
                while (!stack.isEmpty() &&  precedence(stack.peek()) > precedence(symbol)) {
                    prefix += stack.pop();
                }
                stack.push(symbol);
            } else if (symbol == '(') {

                char x = stack.pop();
                while (x != ')') {
                    prefix += x;
                    x = stack.pop();
                }

            } else if (symbol == ')') {
                stack.push(symbol);
            } else {
                prefix += symbol;
            }
        }

        while (!stack.isEmpty()) {
            prefix += stack.pop();
        }

        String reversedPrefix = "";
        for (int i = prefix.length() - 1; i >= 0; i--) {
            reversedPrefix += prefix.charAt(i);
        }
        return reversedPrefix;
    }

}
