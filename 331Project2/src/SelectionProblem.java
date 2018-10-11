import java.util.Arrays;
import java.util.Random;

public class SelectionProblem
{
	public static void main(String[] args)
	{
		
		int n = 10;
        int[] arr1 = makeMatrix(n);
        
		long st1 = System.nanoTime();
		algorithm4(arr1, n/4);
		long et1 = System.nanoTime();
		long one = et1 - st1;
		
		System.out.println(one);
        
        /*System.out.println("Given Array");
        printArray(arr1);
 
        int ans = algorithm3(arr1, 6);
 
        System.out.println("\nSorted array");
        printArray(arr1);
        System.out.println(ans);*/
	}  
	
	private static int[] makeMatrix(int x)
	{
		int[] y = new int[x];
		Random rand = new Random();

		for (int i = 0; i < x; i++)
			y[i] = rand.nextInt(8) + 1;

		return y;
	}
	
	public static void printArray(int[] arr)
	{
        int n = arr.length;
        
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        
        System.out.println();
	}
	
	public static int algorithm1(int[] r, int k)
	{
		int key;
		
		mergeSort(0, r.length-1, r);
		key = r[k-1];
		
		return key;
	}
	
	public static void mergeSort(int low, int high, int[] arr)
	{		
		if(low < high)
		{
			int mid = (low + high) / 2;
			
			mergeSort(low, mid, arr);
			mergeSort(mid+1, high, arr);
			merge(low, mid, high, arr);
		}
	}
	
	private static void merge(int low, int mid, int high, int[] arr)
	{
		int i = low;
		int j = mid+1;
		int k = low;
		int[] mArr = new int[high + 1];
		
		while(i<=mid && j<=high)
		{
			if(arr[i] < arr[j])
			{
				mArr[k] = arr[i];
				i++;
			}
			else
			{
				mArr[k] = arr[j];
				j++;
			}
				k++;
		}
		
		if(i > mid)
			for(int x = j, y = k; x <= high; x++, y++)
				mArr[y] = arr[x];
		else
			for(int x = i, y = k; x <=  mid; x++, y++)
				mArr[y] = arr[x];
		
		for(int f = low; f <= high; f++)
			arr[f] = mArr[f];
	}
	
	public static int algorithm2(int[] r, int k)
	{
		int key;
		
		quickSortI(0, r.length-1, r, k);
		key = r[k-1];
		
		return key;
	}
	
	public static void quickSortI(int low, int high, int[] arr, int key)
	{
		int pivot = 0;
		
		pivot = partition(low, high, pivot, arr);
		
		while(pivot != (key-1))
		{
			if((key-1) < pivot)
				pivot = partition(low, pivot-1, low, arr);
			if((key-1) > pivot)
				pivot = partition(pivot+1, high, pivot+1, arr);
		}
	}
	
	public static int algorithm3(int[] r, int k)
	{
		int key;
		
		quickSortR(0, r.length-1, r, k);
		key = r[k-1];
		
		return key;
	}
	
	public static void quickSortR(int low, int high, int[] arr, int key)
	{
		int pivot = 0;
		
		pivot = partition(low, high, pivot, arr);
		
		if(pivot == (key-1))
			return;
		else if((key-1) < pivot)
			quickSortR(low, pivot-1, arr, key);
		else
			quickSortR(pivot+1, high, arr, key);
	}
	
	private static int partition(int low, int high, int pivot, int[] arr)
	{
		int temp;
		int j = low;
		int pivotItem = arr[low];
		
		for(int i = low + 1; i <= high; i++)
		{
			if(arr[i] < pivotItem)
			{
				j++;
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		
		pivot = j;
		temp = arr[low];
		arr[low] = arr[pivot];
		arr[pivot] = temp;
		
		return pivot;
	}
	
    public static int algorithm4(int arr[], int k)
    {
        Arrays.sort(arr);
        return arr[k-1];
    }

    public static void getMedian(int arr[])
    {
        int median = findMedian(arr,(arr.length)/2 + 1,0,arr.length-1);
    }

    private static int findMedian(int arr[], int k, int low, int high)
    {
    	if(low == high)
            return arr[low];

        int m = partitionM(arr,low,high);
        int length = m - low + 1;

        if(length == k)
            return arr[m];
        
        if(length > k)
            return findMedian(arr,k,low,m-1);
        else
            return findMedian(arr,k-length,m+1,high);
    }

    private static int partitionM(int arr[],int low, int high)
    {
        int pivotValue = getPivotPoint(arr, low, high);

        while(low < high)
        {
            while(arr[low] < pivotValue)
            {
                low ++;
            }

            while(arr[high] > pivotValue)
            {
                high--;
            }

            if(arr[low] == arr[high])
            {
                low ++;
            }
            else if(low < high)
            {
                int temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
            }

        }
        return high;
    }

    private static int getPivotPoint(int arr[], int low, int high)
    {
        if(high-low+1 <= 9)
        {
            Arrays.sort(arr);
            return arr[arr.length/2];
        }
        
        int temp[] = null;
        
        int medians[] = new int[(int)Math.ceil((double)(high-low+1)/5)];
        int medianIndex = 0;

        while(low <= high)
        {
            temp = new int[Math.min(5,high-low+1)];

            for(int j=0;j<temp.length && low <= high;j++)
            {
                temp[j] = arr[low];
                low++;
            }
            Arrays.sort(temp);

            medians[medianIndex] = temp[temp.length/2];
            medianIndex++;
        }

        return getPivotPoint(medians,0,medians.length-1);
    }
}