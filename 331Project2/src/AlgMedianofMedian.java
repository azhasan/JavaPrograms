import java.util.Arrays;

public class AlgMedianofMedian {
private static int[] arrayPassed;

public static int[] getArrayPassed() {
	return arrayPassed;
}

public static void setArrayPassed(int[] arrayPassed) {
	AlgMedianofMedian.arrayPassed = arrayPassed;
}
	
	public AlgMedianofMedian(int[] a) {
		arrayPassed = a;
	}
	
	public int QuickMedian(int[] a, int kth) {
		Arrays.sort(a);
		return a[kth - 1];
	}
	
	public int partition(int[] a, int low, int high) {
		int pValue = getPivot(a, low, high);
		while(low < high) {
			while(a[low] < pValue)
				low++;
			while(a[high] > pValue)
				high--;
			if(a[low] == a[high])
				low++;
			else if(low < high)
				swap(a, low, high);
		}
		return high;
	}
	
	public static int getPivot(int[] array, int low, int high)
    {
        if(high-low+1 <= 5)
        {
            Arrays.sort(array);
            return array[array.length/2];
        }
        int temp[] = null;
        int M[] = new int[(int)Math.ceil((int)(high-low+1)/5)];
        int mIndex = 0;
        while(low <= high)
        {
            temp = new int[Math.min(5, high-low+1)];
            for(int j = 0; j < temp.length && low <= high; j++)
            {
                temp[j] = array[low];
                low++; 
            }
            Arrays.sort(temp);
            M[mIndex] = temp[temp.length/2];
            mIndex++;
        }
       
        return getPivot(M, 0, M.length-1);
    }
	
	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
