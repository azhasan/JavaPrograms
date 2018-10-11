import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class AlgTest {
	public static int size;
	
	public static void main(String[] args) {
		int[]array = null;
	
		
		double totalTime = 0, overallTotal = 0, overallTotal2 = 0, overallTotal3 = 0, overallTotal4 = 0; 
		int k = 0, k2 = 0;
				long start = 0, end = 0;
		int value = 0;
		
		Scanner kb = new Scanner(System.in);
		
		System.out.println("how big u want this array");
		
		size = kb.nextInt();
	    array = new int[size];
	
	ArrayList<Integer> numArray = new ArrayList<Integer>(size);
	 Random rand = new Random();
	
	 
	while(numArray.size() < size) {
		int random = rand.nextInt(size) + 1;
		if(!numArray.contains(random))
			numArray.add(random);
	    }
		for(int i = 0; i < numArray.size(); i++) {
			//System.out.print(numArray.get(i) + " ");
			array[i] = numArray.get(i);
		}
		
		System.out.println();
		 System.out.println("Algorithm 1:");
		 
		Alg1MergeSort plswork = new Alg1MergeSort(array);
		
	    
		for(int i = 0; i < 5; i ++) {
			start = System.nanoTime();
	    	plswork.mergeSort(array);
			end = System.nanoTime();
			end = end - start;
			System.out.println("time: " + end +" nano seconds");
			overallTotal += end;
		}
    	System.out.println("over 5 rounds, average is: " + overallTotal / 5);

		////////////////////////////////////////
		k2 = 1;
		////////////////////////////////////////
		if(k2 == 1) {
			
		System.out.println("k = 1: "+ (array[0]));
		}
		
		else if(k2 == size / 4 - 1) {
		System.out.println("k = n / 4: " + array[k2]);
		}
		
		else if(k2 == 3 * (size / 4) - 1) {
		System.out.println("k = 3 n / 4: " + array[k2]);
		}
		else if(k2 == size / 2 - 1) {
			System.out.println("k = n / 2 : " + (array[k2]));
		}
		
		else if(k2 == size - 1) {
		System.out.println("k = n" + (array[array.length - 1])); // K = n
		}
		
		System.out.println();
	

	System.out.println();
	 System.out.println("Algorithm 2:");
	array = new int[size];
	Alg2QuickSortIterative plswork2 = new Alg2QuickSortIterative(array);
	
	while(numArray.size() < size) {
		int random = rand.nextInt(size) + 1;
	    if(!numArray.contains(random))
			numArray.add(random);
	    }
		for(int i = 0; i < numArray.size(); i++) {
			//System.out.print(numArray.get(i) + " ");
			array[i] = numArray.get(i);
		}
		//////////// CHANGE THIS /////////////////
	    k = 1;
	    /////////////////////////////////////////
	   
	    
	    	for(int i = 0; i < 5; i++) {
				long start2 = System.nanoTime();
	    	value = plswork2.QuickSort(array, 0, size - 1, k, 0);
	    		long end2 = System.nanoTime();
	    		end2 = end2 - start2;
	    		System.out.println("time: " + end2 + " nanoseconds");
	    		System.out.println("n = 1: " + value);
	    	overallTotal2 += end2;
	    	}
	    	

	    	System.out.println("over 5 rounds, average is: " + overallTotal2 / 5);

	
	    System.out.println();
	    System.out.println("Algorithm 3:");
	    array = new int[size];
		Alg2QuickSortRecursive plswork3 = new Alg2QuickSortRecursive(array);
		
		while(numArray.size() < size) {
			int random = rand.nextInt(size) + 1;
			if(!numArray.contains(random))
				numArray.add(random);
		    }
			for(int i = 0; i < numArray.size(); i++) {
				array[i] = numArray.get(i);
			}
	    
		    	for(int i = 0; i < 5; i++) {
		    		long start3 = System.nanoTime();
		    		value = plswork3.recQuick(array, 0, size-1, k);
		    		long end3 = System.nanoTime();
		    		end3 = end3 - start3;
		    				System.out.println("time: " + end3 + "nanoseconds");
		    		    	System.out.println("n = 1: " + value);
		    				overallTotal3 += end;
		    	}
		    	System.out.println("over 5 rounds, average is: " + overallTotal3 / 5);
		    

		System.out.println();
		System.out.println("Algorithm 4:");
		array = new int[size];
		AlgMedianofMedian plswork4 = new AlgMedianofMedian(array);
		
			while(numArray.size() < size) {
				int random = rand.nextInt(size) + 1;
				if(!numArray.contains(random))
				numArray.add(random);
			}
			for(int i = 0; i < numArray.size(); i++) {
				//System.out.print(numArray.get(i) + " ");
				array[i] = numArray.get(i);
			}
				     
		 
		    	for(int i = 0; i < 5; i++) {
		    		long start4 = System.nanoTime();
		    		value = plswork4.QuickMedian(array, k);
		    		long end4 = System.nanoTime();
		    		end4 = end4-start4;
		    			System.out.print("\n time: " + end4 + " nanoseconds");
		    			overallTotal4 += end4;
		    	}
		    	System.out.println();
		    	   System.out.println("n = 1: " + value);
		    	System.out.println("over 5 rounds, average is: " + overallTotal4 / 5);
		    
		   
		    

	}
}
