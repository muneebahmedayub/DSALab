package lab2;
public class ArrayCopying {
	public static void main(String args[])
	{
		double[] myList = {1.9, 2.9, 3.4, 3.5};
		double[] myList2 = {1.1, 2.5, 3.7, 3.10};
		myList2=myList;
		for (int i=0;i<myList2.length;i++)
		System.out.println(myList2[i]);
	}
}
