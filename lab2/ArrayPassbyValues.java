package lab2;
public class ArrayPassbyValues {
	public static void main(String[] args) {
	    int x = 1; 
	    int[] y = new int[10]; 
	    y[0]=232;
	    m(x, y);
	    System.out.println("x is " + x);
	    System.out.println("y[0] is " + y[0]);
	  }
	  public static void m(int number, int[] numbers) {
	    number = 1001; // Assign a new value to number
	    numbers[0] = 5555; // Assign a new value to numbers[0]
	  }
}
