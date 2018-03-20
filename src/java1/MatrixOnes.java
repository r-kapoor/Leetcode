package java1;
import java.io.*;
import java.util.Arrays;

public class MatrixOnes 
{
	public static void main(String args[]) throws Exception
	{
		FileReader fr = new FileReader("/home/rkapoor/Documents/Code/Input1.txt");
		BufferedReader br = new BufferedReader(fr);
		
		int [][] mat1;
		int [][] mat2;
		MatrixOnes obj = new MatrixOnes();
		String line;
		line = br.readLine();
		String chars[] = line.split("");
		int n = chars.length;
		mat1 = new int[n][n];
		int i=0;
		for(int j=0; j<n; j++)
		{
			mat1[0][j] = Integer.valueOf(chars[j]);
		}

		i++;
		while((line=br.readLine())!=null)
		{
			chars = line.split("");
			for(int j=0; j<n; j++)
			{
				mat1[i][j] = Integer.valueOf(chars[j]);
			}

			i++;
		}
		mat2 = obj.copy(mat1, n);
		do
		{
			mat1 = obj.copy(mat2, n);
			for(int k=0; k<n; k++)
				for(int j=0; j<n; j++)
				{
		
					if(obj.isNotSafe(mat2,n, k, j))
					{
						mat2[k][j]=1;
					}
				}
			
			
		}while(!obj.isEq(mat1, mat2, n));
		for(int k=0; k<n; k++)
		{
			for(int j=0; j<n; j++)
			{
				System.out.print(mat1[k][j]);
			}
			System.out.println();
		}
	}
	
	public boolean isNotSafe(int M[][], int n, int k, int j)
	{
	 // row number is in range, column number is in range
	 // and value is 1 and not yet visited
		int rowNbr[] = new int[] {-1, 0, 0,  1,};
        int colNbr[] = new int[] {0,  -1,  1, 0};
        int count=0;
        for(int i=0; i<4; i++)
        {
        	if ((k+rowNbr[i] >= 0) && (k+rowNbr[i] < n) &&
                    (j+colNbr[i] >= 0) && (j+colNbr[i] < n) &&
                    (M[k+rowNbr[i]][j+colNbr[i]]==1))
        	{	
        		count+=1;
        		if(count==2)
        			return true;
        	}
        }
        return false;
	}
	
	public boolean isEq(int[][]m1, int[][]m2, int n)
	{
		for(int k=0; k<n; k++)
			for(int j=0; j<n; j++)
			{
				if(m1[k][j]!=m2[k][j])
					return false;
			}
		
		return true;
	}
	
	public int[][] copy(int[][]m1, int n)
	{
		int [][] m2 = new int[n][n];
		for(int k=0; k<n; k++)
			for(int j=0; j<n; j++)
			{
				m2[k][j]=m1[k][j];
			}
		
		return m2;
	}

	
}
