import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class Alg1MergeSort {
	
	int[] arrayPassed;
	
	
	public Alg1MergeSort(int[] array) {
		arrayPassed = array;
	}

	public void mergeSort(int[] A) {
		mergeSort(A, new int[A.length], 0, A.length);

	}
	
	private static void mergeSort(int[] a, int[] buff, int start, int end) {
		if(start +1 < end) {
			mergeSort(a, buff, start, (start+end)/2);
			mergeSort(a, buff, (start+end)/2, end);
			merge(a, buff, start, (start+end)/2, end);
		}
	}
	
	private static void merge(int[] a, int[] buff, int start, int mid, int end) {
		System.arraycopy(a, start, buff, start, end-start);
		int index1 = start, index2 = mid;
		int resultIndex = start;
		
		while(index1 < mid && index2 < end) {
			if(buff[index1] < buff[index2]) {
				a[resultIndex++] = buff[index1++];
			}
			else {
				a[resultIndex++] = buff[index2++];
			}
		}
		if(index1 < mid)
			System.arraycopy(buff, index1, a, resultIndex, mid-index1);
		if(index2 < end)
			System.arraycopy(buff, index2, a, resultIndex, end - index2);
	}
	
}


