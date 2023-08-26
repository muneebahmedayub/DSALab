package lab13;
public class SortAlgorithm {
	public static void main(String args[]){
    	int [] Array={101,23,45,67,3,67};
    	insertionSort(Array);
    	for(int i=0;i<Array.length;i++)
    	System.out.println(Array[i]);
    }
    public static void slectionSort(int[] list) {
        for (int i = 0; i < list.length; i++) {
            int SNI = i; // Supposition : SNI => smallest number index
            for (int j = i + 1; j < list.length; j++) {
                if (list[j] < list[SNI]) {
                    SNI = j;
                }
            }
            int temp = list[SNI];
            list[SNI] = list[i];
            list[i] = temp;
        }
    }
    // Insertion Sort
    public static void insertionSort(int[] list) {
        for (int i = 0; i < list.length; i++) {
            int temp = list[i];
            int j = i - 1;
            while (j >= 0 && list[j] > temp) {
                list[j + 1] = list[j];
                j--;
            }
            list[j + 1] = temp;
        }
    }
    // Bubble Sort
    public static void bubbleSort(int[] list) {
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list.length - 1; j++) {
                if (list[j] > list[j + 1]) {
                    int temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }

    // Merge Sort
    public static void mergeSort(int[] list, int left, int right) {
        if (right > left) {
            int mid = (left + right) / 2;
            mergeSort(list, left, mid);
            mergeSort(list, mid + 1, right);
            merge(list, left, mid, right);
        }
    }
    private static void merge(int[] list, int left, int mid,
    		int right) {
    	int[] leftTempArr = new int[mid - left + 2];
        int[] rightTempArr = new int[right - mid + 1];
        for (int i = 0; i <= mid - left; i++) {
            leftTempArr[i] = list[left + i];
        }
        for (int i = 0; i < right - mid; i++) {
            rightTempArr[i] = list[(mid + 1) + i];
        }
        leftTempArr[mid - left + 1] = Integer.MAX_VALUE;
        rightTempArr[right - mid] = Integer.MAX_VALUE;
        int i = 0, j = 0;
        for (int k = left; k <= right; k++) {
            if (leftTempArr[i] < rightTempArr[j]) {
                list[k] = leftTempArr[i];
                i++;
            } else {
                list[k] = rightTempArr[j];
                j++;
            }
        }
    }

    
    
}
