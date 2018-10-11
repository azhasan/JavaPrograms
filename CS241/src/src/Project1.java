import java.util.*;

public class Project1 {

	public static void main(String[] args) {
	int tokenConversion;
	String lineOfNums, userChoice = " ";
	
	Scanner kb = new Scanner(System.in);
	
	BinaryTree tree1 = new BinaryTree();
	
		 System.out.println("Please enter the initial sequence of values:");
		 lineOfNums = kb.nextLine();
		 
		 //create a string tokenizer to split the string of integers
		 StringTokenizer numTokens = new StringTokenizer(lineOfNums);
		 
		 //contains the number of how many values in the string
		 int numAmount = numTokens.countTokens();
		 for(int i = 0; i < numAmount; i++ ) {
			 String token = numTokens.nextToken();
			 
			 //parses each token as an int for addition into the tree
			  tokenConversion = Integer.parseInt(token);
			  tree1.add(tokenConversion);
		 }
		 
		 //displays the required traversals in the output
		 System.out.print("\nPre-order: ");
		tree1.preorderTraverse();
		 System.out.print("\nIn-order: ");
		 tree1.inorderTraverse();
		 System.out.print("\nPost-order: ");
		tree1.postOrderTraverse();
		System.out.print("\n");
		
		do{		
			
			System.out.print("Command? ");
			
			userChoice = kb.nextLine(); 
			
			//created another StringTokenizer to separate the command from the data
			StringTokenizer token = new StringTokenizer(userChoice, " ");
			
			//contains the command letter
			userChoice = token.nextToken();
	
			//add a value to the tree
		    if(userChoice.equalsIgnoreCase("I")) {
		    	
		    	//takes the next token -- the integer and parses for addition
		    	int entry = Integer.parseInt(token.nextToken());
		    	
		    	BinaryNode node = tree1.add(entry); 
		    	if(node == null)
		    		System.out.print(entry +" already exists, ignore.");
		    	else
	       	    	tree1.inorderTraverse();
		    	System.out.print("\n"); 
		    	
		     }//end add
		    
		    //remove a value from the tree
		    if(userChoice.equalsIgnoreCase("D")) { 
		    	
		    	//takes the next token -- the integer and parses for removal
		        int entry = Integer.parseInt(token.nextToken()); 
		        if(tree1.getEntry(entry)==null){
		          	System.out.println(entry + " does not exist!");
		        }
		        else {
		    	    tree1.remove(entry);
		    	    tree1.inorderTraverse();
		    	     System.out.print("\n");
		        }
		    }//end remove
		    
		    
		    //find predecessor of the value
		    if(userChoice.equalsIgnoreCase("P")) {
		    	
		    	//takes the next token -- the integer and parses for predecessor location
		    	int entry = Integer.parseInt(token.nextToken());
		    	BinaryNode pred = tree1.getPredecessor(entry);
		    	if(pred.getData() == entry)
		    		System.out.println("There is no predecessor.");
		    	else
		    		System.out.println(pred.getData());
		    	
		    }//end predecessor
		    
		    
		    //find successor	
		    if(userChoice.equalsIgnoreCase("S")) {
		    	
		    	//takes the next token -- the integer and parses for successor location
		    	int entry = Integer.parseInt(token.nextToken());
		    	BinaryNode succ = tree1.getSuccessor(entry);
		    	if(succ.getData() == entry)
		    		System.out.println("There is no successor");
		    	else 
		    		System.out.println(succ.getData());
		    }
	
		    //show menu
		    if(userChoice.equalsIgnoreCase("H")) {
		    	System.out.println("I   Insert a value");
		    	System.out.println("D   Delete a value");
		    	System.out.println("P   Find predecessor");
		    	System.out.println("S   Find successor");
		    	System.out.println("E   Exit the program");
		    	System.out.println("H   Display this message");

		    }
		}while(!(userChoice.equalsIgnoreCase("E"))); //end while
		
		System.out.println("Thanks for using my program!");
		
		
		 
        
	
		
	}
}
