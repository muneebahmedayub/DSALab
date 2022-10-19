package Lab5;

public class StackArray {
    int top = -1;
    int[] stack;

    StackArray(int length) {
        this.stack = new int[length];
    }

    public void push(int value) {
        if(isFull()) {
            System.out.println("Stack is full");
            return;
        }

        stack[++top] = value;
    }

    public void pop() {
        if(isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        top--;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == stack.length-1;
    }

    public int peek() {
        if(isEmpty()) {
            System.out.println("Stack is empty!!");
            return -1;
        }
        return stack[top];
    }

    public void print() {
        for(int i=0; i<= top; i++) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

}
