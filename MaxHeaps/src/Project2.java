import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Project2 {
	
	public static void main(String[] args) 
	{
		int swapCount = 0, optimcount = 0, userinput, total = 0, overalAverage = 0;
		
		MaxHeap test1 = new MaxHeap();
		MaxHeap test1Optimal = null;
		
		//create the menu
		System.out.println("Please select how to test the program:");
		System.out.println("(1) 20 sets of 100 randomly generated integers" +
		                    "\n(2) Fixed integer values 1-100");
		
		System.out.print("Enter choice: ");
		Scanner kb = new Scanner(System.in);
		//take in user input
		userinput = kb.nextInt();
		
		//if user chooses 1...
		if(userinput ==1) {
	
			
			for(int j = 0; j < 20; j++) {
			//create an array list object
				ArrayList<Integer> array = new ArrayList<Integer>(100);
				//create random object
				Random rand = new Random();
				
				//while the array size is less than 100
				while(array.size() < 100) {
					
					//generates numbers from 1-100
					int random = rand.nextInt(100) + 1;
					
					if(!array.contains(random)) {
						array.add(random);
					} 
				}
			
				for(int i = 0; i < array.size(); i++) {
					//add each value from the array into the test1 MaxHeaap object
					test1.add(array.get(i));
					//return the number of swaps from the add method
					swapCount = test1.printAddSwap();
					
					//create a new int array 
					int[] test1Array = new int[100];
					
					//input all values from array into the test1Array to pass into optimized method
					test1Array[i] = array.get(i);
					test1Optimal = new MaxHeap(test1Array);
					
					for(int p = 0; p < 20; p++) {
						//return count of number of swaps in optimized method
					    optimcount = test1Optimal.printOptimSwap();
				   
				}
						
					}//end p for
				    	// end k for
				total += optimcount;

					
			}
			//overalAverage = total / 20;
			swapCount = swapCount / 20;
			}
		
			overalAverage = total / 20;
		
			//print out averages
			System.out.println("Average swaps for series of insertions: "+ swapCount);
			System.out.println("Average swaps for optimal method: " + overalAverage);

	  
	   //if user chooses choice 2...
	   if(userinput ==2) { 
	   
		MaxHeap test2 = new MaxHeap();
		
		//add to the test2 MaxHeap object a fixed number list from 1-100
		for(int i = 1; i<=100; i++) {
			test2.add(i);
		}
		
		//print out the the new heap after adding
		System.out.print("Heap built using series of insertions: ");
		test2.print();
		
		//return the number of swaps for add
		int addCount = test2.printAddSwap();
		System.out.println();
		//print out the swaps of add
		System.out.print("Number of swaps: " + addCount);
		
		//remove from the heap 10 times
		for(int j = 1; j<=10; j++) {
			test2.removeMax();
		}

		//print out the new heap
        System.out.println();
		System.out.print("Heap after 10 removals: ");
		test2.print();
		
	    //optimal method testing
		System.out.println();
		//store values from 1-100 into an array
		int[] test2Array = new int[100];
		for(int i = 0; i < 100; i++) {
			test2Array[i] = i+1;
		}
		//pass the array into the test2Optimal MaxHeap object
		MaxHeap test2Optimal = new MaxHeap(test2Array);
		
		System.out.println();
		
		//print out the heap created from the optimized method
		System.out.print("Heap built using optimal method: ");
		test2Optimal.print();
		
		//return number of swaps
		int optimal2 = test2Optimal.printOptimSwap();
		System.out.println();
		System.out.println("Number of swaps: " + optimal2);
		
		//remove the root 10 times successive
		for(int j = 1; j<=10; j++) {
			test2Optimal.removeMax();
		}
		
		//generate the new heap after removal
		System.out.print("Heap after 10 removals: ");
		test2Optimal.print();
		

	
	   }

	}

}