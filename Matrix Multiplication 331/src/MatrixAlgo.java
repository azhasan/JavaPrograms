public class MatrixAlgo {

	private int[][] matrixA;
	private int[][] matrixB;
	
	public MatrixAlgo(int[][]a, int[][]b) {
		setMatrixA(a);
		setMatrixB(b);
	}
	

	public int[][] getMatrixB() {
		return matrixB;
	}

	public void setMatrixB(int[][] matrixB) {
		this.matrixB = matrixB;
	}

	public int[][] getMatrixA() {
		return matrixA;
	}

	public void setMatrixA(int[][] matrixA) {
		this.matrixA = matrixA;
	}
	
	public int[][] regMultiply(int[][]a, int[][]b) {
		
		int[][] c = new int[a.length][b[0].length];
		
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < b[0].length; j++) {
				c[i][j] = 0;
			}
		}
		
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < b[0].length; j++) {
				for(int k = 0; k < a[0].length; k++) {
					c[i][j] += a[i][k] * b[k][j];
				}
			}
		}
		 
		return c;
	}
	
	public int[][] divAndConq(int[][]a, int[][]b) {
		return divAndConq(a, b, 0, 0, 0, 0, a.length);
	}
	
	public int[][] divAndConq(int[][]a, int[][]b, int rowA, int colA,
			                  int rowB, int colB, int size) {
		 
	    
		int[][]c = new int[size][size];
		
		if(size == 1)
			c[0][0] = a[rowA][colA]*b[rowB][colB];
		
		else {
			int newSize = size/2;
			
			sumMatrix(c, divAndConq(a, b, rowA, colA, rowB, colB, newSize),
					  divAndConq(a, b, rowA, colA+newSize, rowB + newSize, colB, newSize),
					  0, 0);
			
			sumMatrix(c, divAndConq(a, b, rowA, colA, rowB, colB + newSize, newSize),
					  divAndConq(a, b, rowA, colA+newSize, rowB + newSize, colB + newSize, newSize),
					  0, newSize);
			
			sumMatrix(c, divAndConq(a, b, rowA + newSize, colA, rowB, colB, newSize),
					  divAndConq(a, b, rowA + newSize, colA+newSize, rowB + newSize, colB, newSize),
					  newSize, 0);
			
			sumMatrix(c, divAndConq(a, b, rowA + newSize, colA, rowB, colB + newSize, newSize),
					  divAndConq(a, b, rowA + newSize, colA+newSize, rowB + newSize, colB + newSize, newSize),
					  newSize, newSize);
		}
		
		return c;
	}
	
	private void sumMatrix(int[][]c, int[][]a, int[][]b, int rowC, int colC) {
		int x = a.length;
		for(int i = 0; i < x; i++) {
			for(int j= 0; j < x; j++) {
				c[i+rowC][j+colC] = a[i][j] + b[i][j];
			}
		}
	}
	
	
	public static int [][] strassen(int [][] a, int [][] b)
	{
		int n = a.length;
		int [][] result = new int[n][n];

		if((n%2 != 0 ) && (n !=1))
		{
			int[][] a1, b1, c1;
			int n1 = n+1;
			a1 = new int[n1][n1];
			b1 = new int[n1][n1];
			c1 = new int[n1][n1];

			for(int i=0; i<n; i++)
				for(int j=0; j<n; j++)
				{
					a1[i][j] =a[i][j];
					b1[i][j] =b[i][j];
				}
			c1 = strassen(a1, b1);
			for(int i=0; i<n; i++)
				for(int j=0; j<n; j++)
					result[i][j] =c1[i][j];
			return result;
		}

		if(n == 1)
		{
			result[0][0] = a[0][0] * b[0][0];
		}
		else
		{
			int [][] A11 = new int[n/2][n/2];
			int [][] A12 = new int[n/2][n/2];
			int [][] A21 = new int[n/2][n/2];
			int [][] A22 = new int[n/2][n/2];

			int [][] B11 = new int[n/2][n/2];
			int [][] B12 = new int[n/2][n/2];
			int [][] B21 = new int[n/2][n/2];
			int [][] B22 = new int[n/2][n/2];

			divide(a, A11, 0 , 0);
			divide(a, A12, 0 , n/2);
			divide(a, A21, n/2, 0);
			divide(a, A22, n/2, n/2);

			divide(b, B11, 0 , 0);
			divide(b, B12, 0 , n/2);
			divide(b, B21, n/2, 0);
			divide(b, B22, n/2, n/2);

			int [][] P1 = strassen(add(A11, A22), add(B11, B22));
			int [][] P2 = strassen(add(A21, A22), B11);
			int [][] P3 = strassen(A11, sub(B12, B22));
			int [][] P4 = strassen(A22, sub(B21, B11));
			int [][] P5 = strassen(add(A11, A12), B22);
			int [][] P6 = strassen(sub(A21, A11), add(B11, B12));
			int [][] P7 = strassen(sub(A12, A22), add(B21, B22));

			int [][] C11 = add(sub(add(P1, P4), P5), P7);
			int [][] C12 = add(P3, P5);
			int [][] C21 = add(P2, P4); 
			int [][] C22 = add(sub(add(P1, P3), P2), P6);

			copy(C11, result, 0 , 0);
			copy(C12, result, 0 , n/2);
			copy(C21, result, n/2, 0);
			copy(C22, result, n/2, n/2);
		}
		
		return result;
		
	}

	public static int [][] add(int [][] A, int [][] B)
	{
		int n = A.length;

		int [][] result = new int[n][n];

		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
			result[i][j] = A[i][j] + B[i][j];

		return result;
	}

	public static int [][] sub(int [][] A, int [][] B)
	{
		int n = A.length;

		int [][] result = new int[n][n];

		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++)
			result[i][j] = A[i][j] - B[i][j];

		return result;
	}

	public static void divide(int[][] p1, int[][] c1, int iB, int jB)
	{
		for(int i1 = 0, i2=iB; i1<c1.length; i1++, i2++)
			for(int j1 = 0, j2=jB; j1<c1.length; j1++, j2++)
			{
				c1[i1][j1] = p1[i2][j2];
			}
	}

	
	public static void copy(int[][] c1, int[][] p1, int iB, int jB)
	{
		for(int i1 = 0, i2=iB; i1<c1.length; i1++, i2++)
			for(int j1 = 0, j2=jB; j1<c1.length; j1++, j2++)
			{
				p1[i2][j2] = c1[i1][j1];
			}
	}
	
}
