package lab2;
public class ArrayDeletion {
	public static void main(String args[])
	{
		double[] myList=new double[8];
		myList[0] =1.9;
		myList[1] =1.2;
		myList[2] =1.6;
		myList[3] =1.1;
		int k=3;
		if(k>=myList.length){
			System.out.println("The postion should be less than the size");
			return;
		}
		int j=k;
		while(j<myList.length-1){
			myList[j]=myList[j+1];
			j++;
		}
		for(int i=0;i<myList.length;i++)
		System.out.println(myList[i]);
	}
}
