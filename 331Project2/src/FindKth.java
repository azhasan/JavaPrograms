
import java.util.*;
public class FindKth 
{
    public static int N = 10;
    public static int[] Arr = new int[N];
    
    //mergesort
    public static void merge(int array[], int low, int mid, int high)
    {
        int n1 = mid - low + 1;
        int n2 = high - mid;
        int Low[] = new int [n1];
        int High[] = new int [n2];
        for (int i=0; i<n1; ++i)
            Low[i] = array[low + i];
        for (int j=0; j<n2; ++j)
            High[j] = array[mid + 1+ j];       
        int i = 0;
        int j = 0;
        int k = low;
        while (i < n1 && j < n2)
        {
            if (Low[i] <= High[j])
            {
                array[k] = Low[i];
                i++;
            }
            else
            {
                array[k] = High[j];
                j++;
            }
            k++;
        }
        while (i < n1)
        {
            array[k] = Low[i];
            i++;
            k++;
        }
        while (j < n2)
        {
            array[k] = High[j];
            j++;
            k++;
        }
    }
    public static void sort(int array[], int low, int high)
    {
        if (low < high)
        {
            int mid = (low+high)/2;
            sort(array, low, mid);
            sort(array, mid+1, high);
            merge(array, low, mid, high);
        }
    }
    public static int Alg1(int[] array, int kth)
    {
        sort(array, 0, N-1);
        return array[kth-1];
    }
    //iterative Quick Sort
    public static int Alg2(int array[], int low, int high, int kth, int pivotItem)
    {
        int m = 0;
        int j = high;
        if(low == high)
            return array[low];
        for(;;)
        {
            int pivotIndex = partition(array, m, j, pivotItem);
            if(kth-1 == pivotIndex)
                return array[kth-1];
            else if(kth-1 < pivotIndex)
                j = pivotIndex - 1;
            else
            {
                m = pivotIndex + 1;
                pivotItem = m;
            }
        }
    }   
    public static int partition(int[] array, int low, int high, int pivotIndex)
    {
       int pivotValue = array[low];
       int j = low;
       for(int i = (low+1); i <= high; i++)
       {
           if(array[i] <= pivotValue)
           {
               j++;
               swap(array, i, j);
           }
       }
       pivotIndex = j;
       swap(array, low, pivotIndex);
       return pivotIndex;
    }
    //Quick Sort recursively
    public static int Alg3(int[] array, int low, int high, int kth)
    {
        if(low == high)
            return array[low];
        else if(low < high)
        {
            int pivotIndex = partition(array, low, high, kth);
            if(kth-1 == pivotIndex)
                return array[kth-1];
            else if(kth-1 < pivotIndex)
                return Alg3(array, low, pivotIndex-1, kth);
            else
                return Alg3(array, pivotIndex+1, high, kth);
        } 
        else
            return -1;
    }
    public static void swap(int[] array, int a, int b)
    {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
    //medain of medians
    public static int Alg4(int[] array, int kth)
    {
        Arrays.sort(array);
        return array[kth-1];
    }
    
    public static int partition4(int[] array, int low, int high)
    {
        int pivotValue = getPivot(array, low, high);
        while(low < high)
        {
            while(array[low] < pivotValue)
                low++;
            while(array[high] > pivotValue)
                high--;
            if(array[low] == array[high])
                low++;
            else if(low < high)
                swap(array, low, high);
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
    public static void main(String[] args) 
    {
        int k = N; 
        Random random = new Random();
        for (int i = 0; i < N; i++)
            Arr[i] = random.nextInt(10000);       
        System.out.println("Original:  ");
        for (int i = 0; i < N; i++)
            System.out.print(Arr[i] + " ");
        
        //mergesort
        int Arr1[] = Arr.clone();
        long start = System.nanoTime();
        int one = Alg1(Arr1, k / 4);
        long end = System.nanoTime();
        end = end-start;
        System.out.println("\nMergeSort time: " + end + "\nk= " + one);
        //iterative
        int Arr2[] = Arr.clone();
        start = System.nanoTime();
        int two = Alg2(Arr2, 0, N-1, k/ 2, 0);
        end = System.nanoTime();
        end = end-start;
        System.out.println("Iterative QuickSort time: " + end + "\nk= " + two);
        //recursion
        int Arr3[] = Arr.clone();
        start = System.nanoTime();
        int three = Alg3(Arr3, 0, N-1, k);
        end = System.nanoTime();
        end = end-start;
        System.out.println("Recursive QuickSort time: " + end + "\nk= " + three);
        //median of medians
        int Arr4[] = Arr.clone();
        start = System.nanoTime();
        int four = Alg4(Arr4, k);
        end = System.nanoTime();
        end = end-start;
        System.out.println("Median of Medians time: " + end + "\nk= " + four);
    }
}
