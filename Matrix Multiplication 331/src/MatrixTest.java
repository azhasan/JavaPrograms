import java.util.Random;
public class MatrixTest {
	
	public static void main(String[] args) {
		
		int[][] test1 = new int[4][4];
		int[][] test2 = new int[4][4];
		double actualtime = 0, total = 0, total2 = 0, total3 = 0;
		Random rand = new Random();
		
		
		for(int i = 0; i < test1.length; i++) {
			for(int j = 0; j<test1[i].length; j++) {
				test1[i][j] = rand.nextInt(10) + 1;
			}
			System.out.println();
		}
		
		for(int i = 0; i < test2.length; i++) {
			for(int j = 0; j<test2[i].length; j++) {
				test2[i][j] = rand.nextInt(10) + 1;
			}
			System.out.println();
		}
		
		MatrixAlgo plswork = new MatrixAlgo(test1, test2);
	
			System.out.println("REGULAR:");
			for(int i =0; i < 5; i++) {
			 double time = System.nanoTime();
			 ////////////////////////////////////////////////////////////////////
			 int[][] result = plswork.regMultiply(test1, test2);
			 double time2 = System.nanoTime();
			 actualtime = time2-time;
			 System.out.println(actualtime+ " nanoseconds"); 
			 total  += actualtime;

			 ///////////////////////////////////////////////////////////
			}
			 double averagetime = total / 5;
			 System.out.println("average: " + averagetime + " nanoseconds");
		
			 System.out.println();
		
			System.out.println("DIVIDE AND CONQUER:");
		     	for(int i = 0; i < 5; i++) {
				  long timestart2 = System.nanoTime();
				  int[][] divResult = plswork.divAndConq(test1, test2);
				 long timeend2 = System.nanoTime();
				 actualtime = timeend2-timestart2;
				 System.out.println(actualtime+ " nanoseconds"); 
				 total2  += actualtime;
			}
			System.out.println("average: " +total2 / 5 + " nanoseconds");
		
		 
		 System.out.println();
		 
		 System.out.println("STRASSEN:");
		 for(int i = 0; i < 5; i++) {
			 long timestart3 = System.nanoTime();
		 int[][]StrasResult = MatrixAlgo.strassen(test1, test2);
			 long timeend3 = System.nanoTime();
			actualtime = timeend3 - timestart3;
			 System.out.println(actualtime+ " nanoseconds");
			 total3 += actualtime;
		 }
		 System.out.println("average: "+ total3 / 5 + " nanoseconds");
	
	} // main method
 }  //main class