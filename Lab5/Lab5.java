package Lab5;

public class Lab5 {
    public static void main(String[] args) {
        stackLinkedList();
    }

    public static void infixToPostfix() {
        InfixToPostfix iToP = new InfixToPostfix();
        System.out.println(iToP.toPostfix("((a+b)*c)"));
    }

    public static void stackArray() {
        StackArray sa = new StackArray(10);
        sa.push(10);
        sa.push(20);
        sa.push(30);
        sa.push(40);
        sa.push(50);
        sa.push(60);
        sa.push(70);
        sa.push(80);
        sa.push(90);
        sa.push(100);
        sa.push(110);
        // sa.pop();
        // sa.pop();
        // sa.pop();
        // sa.pop();
        // sa.pop();
        sa.print();
        System.out.println(sa.isEmpty());
        System.out.println(sa.isFull());
        // sa.pop();
        sa.print();
    }
    public static void stackLinkedList() {
        StackLinkedList sl = new StackLinkedList();
        
        sl.push(10);
        sl.push(20);
        sl.push(30);
        sl.push(40);
        
    }
}
