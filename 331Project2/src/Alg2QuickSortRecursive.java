import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Alg2QuickSortRecursive {

	private static int[] arrayPassed;
	
	public Alg2QuickSortRecursive(int[] array) {
		setArrayPassed(array);
	}
	
	public int recQuick(int[] a, int low, int high, int kth) {
		if(low == high)
			return a[low];
		else if( low < high) 
		{
			int pIndex = partition(a, low, high, kth);
			if(kth - 1 == pIndex)
				return a[kth - 1];
			else if(kth - 1 < pIndex)
				return recQuick(a, low, pIndex - 1, kth);
			else 
				return recQuick(a, pIndex + 1, high, kth);
			
		}
		else 
			return -1;
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
		Alg2QuickSortRecursive.arrayPassed = arrayPassed;
	}
	
}
