package lab2;
public class ArrayInsertion {
	public static void main(String args[])
	{
		double[] myList=new double[8];
		myList[0] =1.9;
		myList[1] =1.2;
		myList[2] =1.6;
		myList[3] =1.1;
		int k=0;
		double value=1.12;
		if(k>=myList.length){
			System.out.println("The postion should be less than the size");
			return;
		}
		int j=myList.length-2;
		while(j>=k){
			myList[j+1]=myList[j];
			j--;
		}
		myList[k]=value;
		for(int i=0;i<myList.length;i++)
		System.out.println(myList[i]);
	}
}
