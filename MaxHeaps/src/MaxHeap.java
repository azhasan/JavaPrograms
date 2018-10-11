import java.util.Arrays;
public class MaxHeap {

        private int[] heap; //array of heap entries
        private int lastEntryIndex; //index of last entry
        private boolean begin = false;
        private static final int DEFAULT_CAPACITY = 2010;
        private static final int MAX_CAPACITY = 10000;
        private int swapAddCount = 0, swapOptimCount =0 ;

/*** Default constructor  */
  public MaxHeap() 
  {
          this(DEFAULT_CAPACITY);
  }

  
  
  public MaxHeap(int initialCapacity) {
         //is initialCapacity too small?
          if(initialCapacity < DEFAULT_CAPACITY)
               initialCapacity = DEFAULT_CAPACITY;
          else
                        // is initial capacity too big?
            checkCapacity(initialCapacity);

          int[] temp = new int[initialCapacity + 1];
          heap = temp;
          lastEntryIndex = 0;
          begin = true;

        }

        //optimized method
  public MaxHeap(int[] arrayOfEntries) 
  {
         this(arrayOfEntries.length);
          assert begin = true;
             //copy given array to data field
           for(int i = 0; i < arrayOfEntries.length; i++) {
                 heap[i + 1] = arrayOfEntries[i];
                 lastEntryIndex++;
           }
                //create heap
          for(int rootI = lastEntryIndex / 2; rootI > 0; rootI--)
               reheap(rootI);

   }

/**  This method add's an entry to the heap, properly sortng it to have that max heap algorithm
 * @param newEntry -  the number you want to add into the method
 */
  public void add(int newEntry)
  {
           int newIndex = lastEntryIndex + 1;
           int parentIndex = newIndex / 2;

            while( (parentIndex > 0) && newEntry > heap[parentIndex])
            {
                     heap[newIndex] = heap[parentIndex];
                     swapAddCount++;
                     newIndex = parentIndex;
                     parentIndex = newIndex/2;
             }
               //swapAddCount++;
             heap[newIndex] = newEntry;
            lastEntryIndex++;
           ensureCapacity();

   }

  /** This method removes the max or root from the tree, and resorting it to maintain the max heap 
   *  algorithm
   * @return -  returns the deleted number or the root of the heap */
   public int removeMax( )
    {
         int root = 0;
         if(!isEmpty())
         {
                root = heap[1];                 //return a value
                heap[1] = heap[lastEntryIndex]; //form a semi heap
                lastEntryIndex--;               // decrease a size
                reheap(1);                      // transform to a heap
         }
            return root;
     }
        
   
   /** @return - returns true or false if the lastIndex is less than 0 or not.*/
    public boolean isEmpty()
    {
       return lastEntryIndex < 1;
    }

    /** Clears the heap*/
   public void clear()
     {
         while(lastEntryIndex > -1)
        {
             heap[lastEntryIndex] = 0;
             lastEntryIndex--;
        }
       lastEntryIndex = 0;
   }

   /** Creates the heap from swapping from the non leaf index all the way up to the root node.
    * @param rootIndex - starts the sweeping from here*/
   private void reheap(int rootIndex) 
   {
           boolean finish = false;
           int orphan = heap[rootIndex];
           int leftChildIndex = 2 * rootIndex;

           while(!finish && (leftChildIndex <= lastEntryIndex))
           {
                   int largerChildIndex = leftChildIndex;
                   int rightChildIndex = leftChildIndex + 1;
                   if((rightChildIndex <= lastEntryIndex) && heap[rightChildIndex] > heap[largerChildIndex])
                    rightChildIndex = leftChildIndex + 1;
           	                   if((rightChildIndex <= lastEntryIndex) && heap[rightChildIndex] > heap[largerChildIndex])

           	                           largerChildIndex = rightChildIndex;
          	                   if(orphan < heap[largerChildIndex])
           	                   {
      	                               swapOptimCount++;
           	                           heap[rootIndex] = heap[largerChildIndex];
           	                           rootIndex = largerChildIndex;
           	                           leftChildIndex = 2 * rootIndex;
          	                   }
       	                   else
       	                     finish = true;
                }
      	           heap[rootIndex] = orphan;
      }

   /** Ensures the size of the heap is within the boundaries provided in the beginning*/
      private void ensureCapacity()
   	   {
      	           if(lastEntryIndex >= heap.length)
       	           {
           	                int newCapacity = 2 * (heap.length - 1);
           	                checkCapacity(newCapacity);
           	                heap = Arrays.copyOf(heap, newCapacity);
          	        }
       	}

      /**Checks to see the size of the capcity is greater than the MAX_CAPACITY value declared*/
      	private void checkCapacity(int capacity) {
          	        if(capacity > MAX_CAPACITY)
          	        {
    	                throw new IllegalStateException("Attempt to create a heap"
                     +  "whose capacity exceeds allowed maximum of " + MAX_CAPACITY);
          	        }
      	}

        /**Prints out the heap*/
       	public void print() {
        	    for(int i = 1; i < 11; i++) {
       	            System.out.print(heap[i] + ",");
           	    }
       	    System.out.print("...");
       	}
                
        /**Returns number of swaps from the add method*/
       	public int printAddSwap()
       	{
       	 return swapAddCount;

       	}
       	
        /**Returns number of swaps from the optimized method*/
     	public int printOptimSwap()
       	{
      	   return swapOptimCount;
       	}



 	}
