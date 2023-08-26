package lab6;
public class CircularQueue_Array {
    private int front;
    private int rear;
    private final int size;
    private int[] queue;
    public CircularQueue_Array(int size) {
        this.size = size;
        queue = new int[size];
        front = rear = -1;
        System.out.println("The Circular queue is created Successfully!");
    }
    // is Empty? 
    // The queue will be empty if rear = -1
    public boolean isEmpty(){
        return rear == -1;
    } 
    // is Full?
    // Will be full if front = 0 and rear = last possible index, i.e; rear = size - 1
    // Also, will be full if rear + 1 = front (if circulated)
    public boolean isFull(){
        return (front == 0 && rear == size - 1) 
        		|| (front == rear + 1);
    }
    public void enQueue(int value){
        if(isFull()){
            System.out.println("The queue is Full!");
        } else if(isEmpty()){ // If enqueing for the first time - we need to increment both front and rear
            front++;
            rear++; 
            queue[rear] = value;
        } else { 
            if(rear + 1 == size){ 
          // if true, then we have free location at left of queue, queue is full from right  
                rear = 0;
            } else { // else we are simply moving towards the right
                rear++;
            }
            queue[rear] = value;
        }
        }
    // deQueue
    public int deQueue(){
        if(isEmpty()){
            System.out.println("The queue is empty at the moment! will return -1");
            return -1;
        } else {
            int result = queue[front];
            queue[front] = -1; // every -1 in the queue means 
            //that is a free space
            // Below code decides where the front variable points to
            if(front == rear){ // It means we are removing the only element from the queue 
                front = rear = -1; 
            } else if(front + 1 == size){ // if the queue has to 
            	//circualte
                front = 0;
            } else {
                front++;
            }
            return result;
        }
    }
       public int peek(){
        if(isEmpty()){
            System.out.println("The queue is empty! Will return -1");
            return -1;
        } else {
            return queue[front];
        }
    }
    public void deleteQueue(){
        queue = null;
        System.out.println("Successully deleted queue from the memory!");
    }
    public void print(){
        System.out.println("<----- Queue (-1 means empty locations)----->");
        for(int i = 0; i < size; i++){
            System.out.print(queue[i] + " ");
        }
        System.out.println("\n<----------------->");
    }
    public static void main (String args[]){
    	CircularQueue_Array cqa=new CircularQueue_Array(5);
    	cqa.enQueue(10);
    	cqa.enQueue(20);
    	cqa.enQueue(5);
    	cqa.print();
    }
} 
