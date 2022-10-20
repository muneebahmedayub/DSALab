package LabHomeActivity5;

import java.util.HashMap;

public class EvaluatePostfix {
    Node head;
    Node tail;

    public EvaluatePostfix() {
    }

    public void push(int nodeValue) {
        Node node = new Node();
        node.data = nodeValue;
        if (head == null) {
            node.next = null;
            head = node;
            tail = node;
            return;
        }
        node.next = head;
        head = node;
    }

    public char pop() {
        if (isEmpty()) {
            System.out.println("The Stack is empty!!!");
            return ' ';
        }
        char val = (char) head.data;
        head = head.next;
        return val;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("The Stack is empty!!! (Will return -1)");
            return -1;
        }
        return head.data;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("The Stack is empty!!!");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }


    public int evaluatePostfixExpression(String exp, HashMap<Character, Integer> variables) {
        EvaluatePostfix evaluate = new EvaluatePostfix();
        for(int i=0; i<exp.length(); i++) {
            char ch = exp.charAt(i);

            if(ch >= 'a' || ch <= 'z') {
                int value = variables.get(ch);
                evaluate.push(value);
            } else {
                int value1 = evaluate.pop();
                int value2 = evaluate.pop();
                switch(ch) {
                    case '+':
                        evaluate.push(value1 + value2);
                        break;
                    case '-':
                        evaluate.push(value1 - value2);
                        break;
                    case '*':
                        evaluate.push(value1 * value2);
                        break;
                    case '/':
                        evaluate.push(value1 / value2);
                        break;
                }
            }
        }
        return evaluate.pop();
    }

}

class Node {
    int data;
    Node next;
}