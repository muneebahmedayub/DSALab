package lab12;
import java.util.Collections;
//import lab13.SortAlgorithm;
public class SearchAlgorithm {
    public static void linearSearch(int[] list, int searchValue) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] == searchValue) {
                System.out.println("The number is found on "
                		+ "index : " + i);
                return;
            }
        }
        System.out.println("The number is not found in the list!");
    }
    public static void main(String args[]){
    	int [] Array={1,2,3,4,5,6,7};
    	linearSearch(Array, 9);
    	//System.out.println(binarySearch(Array,0,Array.length,4));
    }
    static int binarySearch(int arr[], int left, int r, int x)
    {
        if (r >= left) {
            int mid = left + (r - left) / 2;
            if (arr[mid] == x)
                return mid;
            if (arr[mid] > x)
                return binarySearch(arr, left, mid - 1, x);
            return binarySearch(arr, mid + 1, r, x);
        }
        return -1;
    }
    
}
