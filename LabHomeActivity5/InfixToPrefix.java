package LabHomeActivity5;

public class InfixToPrefix {
    Node head;
    Node tail;

    public InfixToPrefix() {
    }

    public void push(int nodeValue) {
        Node node = new Node();
        node.value = nodeValue;
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
        char val = (char) head.value;
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
        return head.value;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("The Stack is empty!!!");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    private String reverse(String str) {
        char[] charArr = str.toCharArray();
        int start = 0;
        int end = str.length() - 1;
        
        char temp;
        while(start < end) {
            temp = charArr[start];
            charArr[start] = charArr[end];
            charArr[end] = temp;
            start++;
            end--;
        }

        return String.valueOf(charArr);
    }


    private String toPostfix(String infix) {
        InfixToPrefix operators = new InfixToPrefix();
        char symbol;
        String postfix = "";
        for (int i = 0; i < infix.length(); ++i) {
            symbol = infix.charAt(i);
            if (Character.isLetter(symbol))
                postfix = postfix + symbol;
            else if (symbol == '(') {
                operators.push(symbol);
            } else if (symbol == ')') {
                while (operators.peek() != '(') {
                    postfix = postfix + operators.pop();
                }
                operators.pop(); // remove '('
            } else {
                while (!operators.isEmpty() &&
                        !(operators.peek() == '(') && prec(symbol) <= prec((char) operators.peek()))
                    postfix = postfix + operators.pop();
                operators.push(symbol);
            }
        }
        while (!operators.isEmpty())
            postfix = postfix + operators.pop();
        return postfix;
    }

    public String toPrefix(String infix) {
        String reversedInfix = reverse(infix);

        char[] infixCharArr = reversedInfix.toCharArray();

        for(int i=0; i < infixCharArr.length; i++) {
            if(infixCharArr[i] == '(') {
                infixCharArr[i] = ')';
            } else if(infixCharArr[i] == ')') {
                infixCharArr[i] = '(';
            }
            i++;
        }

        String prefix = toPostfix(String.valueOf(infixCharArr));
        prefix = reverse(prefix);

        return prefix;
    }

    int prec(char x) {
        if (x == '+' || x == '-')
            return 1;
        if (x == '*' || x == '/' || x == '%')
            return 2;
        return 0;
    }
}


class Node {

    int value;
    Node next;
}