package lab1;
import java.util.Scanner;
public class DoWhileLoop {
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		String str;
		do {
		System.out.println("Enter text: ");
		str=sc.nextLine();
		System.out.println("You entered: "+ str);
		} while (!(str.equals("bye")));
	}
}
