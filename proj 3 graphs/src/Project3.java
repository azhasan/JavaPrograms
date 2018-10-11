import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Project3 {
	
	public static void main(String[] args) throws IOException {
		
	String city = null, user, to, from, distance = null, cityAbb, cityName = null, cityName2 = null, 
			secondWord = null, userCityCode2 = null;
	int x = 0, y = 0, ch = 0, d = 0, cityNum = 0, total = 0;
	
	/********************CREATES PATH MATRIX FIRST!!!************************************/
	FileReader reader = new FileReader("road.dat");
	BufferedReader bufferedReader = new BufferedReader(reader);
	
	String line = bufferedReader.readLine();
	//line has the first line rn
	StringTokenizer split = new StringTokenizer(line);
	
	Graph<Integer> test = new Graph<>();
	
		while(line!=null)
		{
			while(split.hasMoreTokens()) 
			{
			    from = split.nextToken();
					 x = Integer.parseInt(from);
					// System.out.println(x);
			    to = split.nextToken();
				   	y = Integer.parseInt(to);
					//System.out.println(y);
	
					test.addEdge(x-1, y-1);
					
					distance = split.nextToken();
					//System.out.println("Added with a distance of " + distance);
					
					d = Integer.parseInt(distance);
					test.addDistance(x-1, y-1, d);
					
					 if(!(split.hasMoreTokens()))
					 {
						 line = bufferedReader.readLine();
						 if(line!=null)
						 split = new StringTokenizer(line);
					 }		
			  }
			
			line = bufferedReader.readLine();
		}
		//test.displayGraph();

		
 /*********************************************************/
	
	do
	{
		Scanner kb = new Scanner(System.in);
		
		System.out.print("Command? ");
		user = kb.nextLine();

	if(user.equalsIgnoreCase("Q")) 
	{
		System.out.print("City code: ");
		city = kb.nextLine();
			
		 reader = new FileReader("city.dat");
	     bufferedReader = new BufferedReader(reader);
		
		 line = bufferedReader.readLine();
		 StringTokenizer lineSplit = new StringTokenizer(line);
		 
		 
		while(line != null)
		{
			  while(lineSplit.hasMoreTokens()) {
				  
				 cityNum = Integer.parseInt(lineSplit.nextToken());
			   	 cityAbb = lineSplit.nextToken();
				  
			 if(line.contains(city)) {
				 if(cityAbb.equals(city))
				 System.out.println(line); 
				  line = bufferedReader.readLine();
				  lineSplit = new StringTokenizer(line);
			  }
			 else {
				  line = bufferedReader.readLine();
				  lineSplit = new StringTokenizer(line);
			 }
		  }
			  line = bufferedReader.readLine();

		}//end while
  		reader.close();
  		
  		System.out.print("Command? ");
		user = kb.nextLine();	
     } 
	
	
	if(user.equalsIgnoreCase("I")){
		x=0;
		y=0;
		reader = new FileReader("city.dat");
	    bufferedReader = new BufferedReader(reader);
	     
		System.out.print("City codes and distance: ");
		user = kb.nextLine();
			
		 reader = new FileReader("city.dat");
	     bufferedReader = new BufferedReader(reader);
		
		 line = bufferedReader.readLine();
		 
		 StringTokenizer lineSplit = new StringTokenizer(line);
		 StringTokenizer userSplit = new StringTokenizer(user); //split user choice
		 
		 String userCityCode1 = userSplit.nextToken();
		 
		while(line != null)
		{
			  while(lineSplit.hasMoreTokens()) {
				  
				 cityNum = Integer.parseInt(lineSplit.nextToken());
			   	 cityAbb = lineSplit.nextToken();
				  
			 if(line.contains(userCityCode1)) {
				 
				 if(cityAbb.equals(userCityCode1)) {
					 
				 StringTokenizer takeCode = new StringTokenizer(line);
				 
				 x = Integer.parseInt(takeCode.nextToken());
				 cityName = lineSplit.nextToken();
				 	
				    secondWord = lineSplit.nextToken();
				    
				    if(secondWord.contains("1") || secondWord.contains("2")|| secondWord.contains("3") || 
				    	secondWord.contains("4")|| secondWord.contains("5") || secondWord.contains("6") || 
				   		secondWord.contains("7") || secondWord.contains("8")|| secondWord.contains("9")) {
				    	
				    	System.out.print("You have inserted a road from " + cityName + " ");
				    }
				
				    else
				    	System.out.print("You have inserted a road from " + cityName + " " + secondWord + " ");
				        takeCode = new StringTokenizer(line);
				 }
				 
				  line = bufferedReader.readLine();
				  lineSplit = new StringTokenizer(line);
			  }
			 else {
				  line = bufferedReader.readLine();
				  lineSplit = new StringTokenizer(line);
			 }
		  }
			  line = bufferedReader.readLine();

		}//end while
  		
		 reader = new FileReader("city.dat");
	     bufferedReader = new BufferedReader(reader);
		
		 line = bufferedReader.readLine();
		 lineSplit = new StringTokenizer(line);
		 
		 try {
			  userCityCode2 = userSplit.nextToken();
		 }catch(Exception e){
			 System.out.println("Does not exist!");
		 }
     	
		 	 
		while(line != null)
		{
			  while(lineSplit.hasMoreTokens()) {
				  
				 cityNum = Integer.parseInt(lineSplit.nextToken());
			   	 cityAbb = lineSplit.nextToken();
				  
			 if(line.contains(userCityCode2)) {
				 if(cityAbb.equals(userCityCode2)) {
				
				 
				 StringTokenizer takeCode = new StringTokenizer(line);
				 y = Integer.parseInt(takeCode.nextToken());
				 cityName = lineSplit.nextToken();
				 	
				    secondWord = lineSplit.nextToken();
				    
				    if(secondWord.contains("1") || secondWord.contains("2")|| secondWord.contains("3") || 
				    	secondWord.contains("4")|| secondWord.contains("5") || secondWord.contains("6") || 
				   		secondWord.contains("7") || secondWord.contains("8")|| secondWord.contains("9")) {
				    	
				    	System.out.print("to " + cityName + " ");
				    }
				
				    else
				    	System.out.print("to " + cityName + " " + secondWord + " ");
				 }
				 
				  line = bufferedReader.readLine();
				  lineSplit = new StringTokenizer(line);
			  }
			 else {
				  line = bufferedReader.readLine();
				  lineSplit = new StringTokenizer(line);
			 }
		  }
			  line = bufferedReader.readLine();

		}//end while
  		reader.close();
		
		int userCityDistance = Integer.parseInt(userSplit.nextToken()); //contains distance
		System.out.print("with a distance of " + userCityDistance + ".");
		System.out.println();
		
		test.addEdge(x-1, y-1);
		test.addDistance(x-1, y-1, userCityDistance);
		
		
		}
	//removing a link
	if(user.equalsIgnoreCase("R")) {
		//take in two city codes side by side
		System.out.print("City codes: ");
		user = kb.nextLine();
		
		//read in the city.dat
		 reader = new FileReader("city.dat");
	     bufferedReader = new BufferedReader(reader);
		
	     //start at the first line
		 line = bufferedReader.readLine();
		 
		 //create string tokenizer for the line to split up
		 StringTokenizer lineSplit = new StringTokenizer(line);
		 
		 //create string tokenizer for the user input to splitup
		 StringTokenizer userSplit = new StringTokenizer(user); //split user choice
		 
		 //userCitycode1 contains the first abbreviation
		 String userCityCode1 = userSplit.nextToken();
		 
		 //as long as the line isnt null
		while(line != null)
		{
			//and while there are individual tokens in the line
			  while(lineSplit.hasMoreTokens()) {
				  
				 //take the first string "the city num" and make it an int
				 cityNum = Integer.parseInt(lineSplit.nextToken());
			   	 cityAbb = lineSplit.nextToken();
			   	 
			   	 
			 if(line.contains(userCityCode1)) {
				 if(cityAbb.equals(userCityCode1)) {
						 
				 StringTokenizer takeCode = new StringTokenizer(line, " ");
				 	x = Integer.parseInt(takeCode.nextToken());
				
				 	cityName = lineSplit.nextToken();
				 	
					    secondWord = lineSplit.nextToken();
					    
					    if(secondWord.contains("1") || secondWord.contains("2")|| secondWord.contains("3") || 
					    		secondWord.contains("4")|| secondWord.contains("5") || secondWord.contains("6") || 
					    		secondWord.contains("7") || secondWord.contains("8")|| secondWord.contains("9")) {
					    	System.out.print("The road from " + cityName + " ");
					    }
					
					    else
					    	System.out.print("The road from " + cityName + " " + secondWord + " ");
				 	
				 takeCode = new StringTokenizer(line);
				 }
				 
				  line = bufferedReader.readLine();
				  lineSplit = new StringTokenizer(line);
			  }
			 else {
				  line = bufferedReader.readLine();
				  lineSplit = new StringTokenizer(line);
			 }
		  }
			  line = bufferedReader.readLine();

		}//end while
  		
		 reader = new FileReader("city.dat");
	     bufferedReader = new BufferedReader(reader);
		
		 line = bufferedReader.readLine();
		 lineSplit = new StringTokenizer(line);
		 
     	  userCityCode2 = userSplit.nextToken();
		 	 
		while(line != null)
		{
			  while(lineSplit.hasMoreTokens()) {
				  
				 cityNum = Integer.parseInt(lineSplit.nextToken());
			   	 cityAbb = lineSplit.nextToken();
				  
			 if(line.contains(userCityCode2)) {
				 if(cityAbb.equals(userCityCode2)) {
				
				 StringTokenizer takeCode = new StringTokenizer(line);
				 y = Integer.parseInt(takeCode.nextToken());
				 cityName = lineSplit.nextToken();
				 
					    secondWord = lineSplit.nextToken();
					    
					    if(secondWord.contains("1") || secondWord.contains("2")|| secondWord.contains("3") || 
					    		secondWord.contains("4")|| secondWord.contains("5") || secondWord.contains("6") || 
					    		secondWord.contains("7") || secondWord.contains("8")|| secondWord.contains("9")) {
					    	System.out.print("and " + cityName + " doesn't exist.");
					    	System.out.println();
					    }
					    else
					    	System.out.print("and "+cityName + " " + secondWord + " doesn't exist.");
					    	System.out.println();
				  }
				 
				  line = bufferedReader.readLine();
				  lineSplit = new StringTokenizer(line);
			  }
			 
			 else {
				  line = bufferedReader.readLine();
				  lineSplit = new StringTokenizer(line);
			 }
		  }
			  line = bufferedReader.readLine();

		}//end while
  		reader.close();
  		test.removeEdge(x-1, y-1);	
	}
	
	if(user.equalsIgnoreCase("D")) {
		
		//take in two city codes side by side
		System.out.print("City codes: ");
		user = kb.nextLine();
		
		//read in the city.dat
		 reader = new FileReader("city.dat");
	     bufferedReader = new BufferedReader(reader);
		
	     //start at the first line
		 line = bufferedReader.readLine();
		 
		 //create string tokenizer for the line to split up
		 StringTokenizer lineSplit = new StringTokenizer(line);
		 
		 //create string tokenizer for the user input to splitup
		 StringTokenizer userSplit = new StringTokenizer(user); //split user choice
		 
		 //userCitycode1 contains the first abbreviation
		 String userCityCode1 = userSplit.nextToken();
		 
		 //as long as the line isnt null
		while(line != null)
		{
			//and while there are individual tokens in the line
			  while(lineSplit.hasMoreTokens()) {
				  
				 //take the first string "the city num" and make it an int
				 cityNum = Integer.parseInt(lineSplit.nextToken());
			   	 cityAbb = lineSplit.nextToken();
			   	 
			   	 
			 if(line.contains(userCityCode1)) {
				 if(cityAbb.equals(userCityCode1)) {
						 
				 StringTokenizer takeCode = new StringTokenizer(line, " ");
				 	x = Integer.parseInt(takeCode.nextToken());
				
				 	cityName = lineSplit.nextToken();
				 	
					    secondWord = lineSplit.nextToken();
					    
					    if(secondWord.contains("1") || secondWord.contains("2")|| secondWord.contains("3") || 
					    		secondWord.contains("4")|| secondWord.contains("5") || secondWord.contains("6") || 
					    		secondWord.contains("7") || secondWord.contains("8")|| secondWord.contains("9")) {
					    	System.out.print("The minimum distance between " + cityName + " ");
					    }
					
					    else
					    	System.out.print("The minimum distance beetween " + cityName + " " + secondWord + " ");
				 	
				 takeCode = new StringTokenizer(line);
				 }
				 
				  line = bufferedReader.readLine();
				  lineSplit = new StringTokenizer(line);
			  }
			 else {
				  line = bufferedReader.readLine();
				  lineSplit = new StringTokenizer(line);
			 }
		  }
			  line = bufferedReader.readLine();

		}//end while
  		
		 reader = new FileReader("city.dat");
	     bufferedReader = new BufferedReader(reader);
		
		 line = bufferedReader.readLine();
		 lineSplit = new StringTokenizer(line);
		 
     	userCityCode2 = userSplit.nextToken();
		 	 
		while(line != null)
		{
			  while(lineSplit.hasMoreTokens()) {
				  
				 cityNum = Integer.parseInt(lineSplit.nextToken());
			   	 cityAbb = lineSplit.nextToken();
				  
			 if(line.contains(userCityCode2)) {
				 if(cityAbb.equals(userCityCode2)) {
				
				 StringTokenizer takeCode = new StringTokenizer(line);
				 y = Integer.parseInt(takeCode.nextToken());
				 test.dijkstras(test, x-1, y-1);	
			        
		         int[] shortest = test.dijkstras(test, 8, 19);
		         for(int i = 0; i < shortest.length; i++) {
		        	 total += shortest[i];
		         }
		         
				 cityName = lineSplit.nextToken();
				 
					    secondWord = lineSplit.nextToken();
					    
					    if(secondWord.contains("1") || secondWord.contains("2")|| secondWord.contains("3") || 
					    		secondWord.contains("4")|| secondWord.contains("5") || secondWord.contains("6") || 
					    		secondWord.contains("7") || secondWord.contains("8")|| secondWord.contains("9")) {
					    	System.out.print("and " + cityName + " is " + total);
					    	System.out.println();
					    }
					    else
					    	System.out.print("and "+cityName + " " + secondWord + " is "+ total);
					    	System.out.println();
				  }
				 
				  line = bufferedReader.readLine();
				  lineSplit = new StringTokenizer(line);
			  }
			 
			 else {
				  line = bufferedReader.readLine();
				  lineSplit = new StringTokenizer(line);
			 }
		  }
			  line = bufferedReader.readLine();

		}//end while
  		reader.close();
  		
        
       // System.out.println();
       
	} 
	
    if(user.equalsIgnoreCase("H"))    {
	System.out.println("Q Query the information by entering the city code. \n"
					+ "D Find the minimum distance between the two cities\n"
					+ "I Insert a road by entering two city codes and a distance.\n"
					+ "R Remove an existing node by entering two city codes.\n"
					+ "H Display this message \n"
					+ "E Exit. ");
          
    }
    
	} while(!(user.equalsIgnoreCase("E")));
	
	System.out.println("Goodbye! (ﾉ◕ヮ◕)ﾉ*:・ﾟ");
	
	

	
	}

}