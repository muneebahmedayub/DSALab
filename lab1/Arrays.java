package lab1;
public class Arrays {
	public static void main(String args[])
	{
		int foo []= {16, 2, 77, 40, 50};
		int n, result=0;
		for (n=0 ; n<5 ; ++n )
		{
		result += foo[n];
		}
		System.out.println(result);
	}
}
