package lab5;
public class Stack_Array {
    int top = -1;
    int[] stack;
    public Stack_Array(int size) {
        stack = new int[size];
    }
    public void push(int stackValue) {
        if (top == stack.length - 1) {
            System.out.println("Stack is full");
        } else {
            stack[++top] = stackValue;
        }
    }
    public void pop() {
        if (top == -1) {
            System.out.println("Stack is empty");
        } else {
            top--;
        }
    }
    public boolean isEmpty() {
        return top == -1;
    }
    public boolean isFull() {
        return top == stack.length - 1;
    }
    public int peek() {
        return stack[top];
    }
    public void print() {
        for (int i = 0; i <= top; i++) {
            System.out.println(stack[i] + " top "+ top);
        }
    }
    public static void main(String args[]){
    	Stack_Array sa=new Stack_Array(10);
    	sa.push(10);
    	sa.push(20);
    	sa.push(30);
    	//sa.pop();
    	sa.print();
    	System.out.println(sa.isEmpty());
    	System.out.println(sa.isFull());
    	sa.pop();
    	sa.print();
    }
}
