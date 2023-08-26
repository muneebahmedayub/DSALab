package lab2;
public class ArraystoMethods {
	public static void main(String args[])
	{
		//int[] list = {3, 1, 2, 6, 4, 2};
		//printArray(list);
		printArray(new int[]{3, 1, 2, 6, 4, 2});
	}
	public static void printArray(int[] array) {
		  for (int i = 0; i < array.length; i++) {
		    System.out.print(array[i] + " ");
		  }
		} 
}
