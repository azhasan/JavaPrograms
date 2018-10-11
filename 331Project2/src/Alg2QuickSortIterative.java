import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class Alg2QuickSortIterative {

	private static int[] arrayPassed;
	
	public Alg2QuickSortIterative(int[] a) {
		setArrayPassed(null);
	}

	public int QuickSort(int[] a, int low, int high, int kth, int pivot ) {
		int m = 0;
		int j = high;
		if(low == high)
			return a[low];
		
		for(;;) {
			
			int pIndex = partition(a, m, j, pivot);
			if(kth - 1 == pIndex)
				return a[kth - 1];
			else if(kth - 1 < pIndex)
				j = pIndex - 1;
			else {
				m = pIndex + 1;
				pivot = m;
			}
		}
	}
	
	private static int partition(int[]a, int low, int high, int pIndex) {
		int pivotValue = a[low];
		int j = low;
		for(int i = (low+1); i <= high; i++) {
			if(a[i] <= pivotValue) {
				j++;
				swap(a, i, j);
			}
		}
		
		pIndex = j;
		swap(a, low, pIndex);
		return pIndex;
	}
	
	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static int[] getArrayPassed() {
		return arrayPassed;
	}

	public static void setArrayPassed(int[] arrayPassed) {
		Alg2QuickSortIterative.arrayPassed = arrayPassed;
	}

}
