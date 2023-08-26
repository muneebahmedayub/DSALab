package lab1;
import java.util.Scanner;
public class IfElse {
	public static void main(String args[])
	{
		int x;
		Scanner sc=new Scanner(System.in);
		System.out.println("Please Enter a Value");
		x=sc.nextInt();
		if (x > 0)
		System.out.println( "x is positive");
		else if (x < 0)
		System.out.println( "x is negative");
		else
		System.out.println( "x is 0");

	}
}
