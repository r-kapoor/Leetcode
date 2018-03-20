package java1;

public class S576 {

	public static void main(String[] args) {
		System.out.println(findPaths(36,
				5,
				50,
				15,
				3));
	}
	
	public static int findPaths(int m, int n, int N, int i, int j) {
		if(N == 0){
			return 0;
		}
        long totalPaths = 0;
        long[][] prevSteps = new long[m][n];
        //Initializing for 1 step
        for(int k = 0; k < n; k++){
        	//Top Layer
        	prevSteps[0][k] += 1;
        	//Bottom Layer
        	prevSteps[m-1][k] += 1;
        }
        for(int k = 0; k < m; k++){
        	//Left
        	prevSteps[k][0] += 1;
        	//Right
        	prevSteps[k][n-1] += 1;
        }
        totalPaths += prevSteps[i][j];
        for(int steps = 2; steps <= N; steps++){
        	long[][] nextSteps = new long[m][n];
        	for(int k = 0; k < m; k++){
        		for(int l = 0; l < n; l++){
        			long sum = 0;
        			if(k > 0){
        				sum += prevSteps[k-1][l]%1000000007l;
        			}
        			if(l > 0){
        				sum += prevSteps[k][l-1]%1000000007l;
        			}
        			if(k < m-1){
        				sum +=  prevSteps[k+1][l]%1000000007l;
        			}
        			if(l < n-1){
        				sum += prevSteps[k][l+1]%1000000007l;
        			}
        			nextSteps[k][l] = sum;
        		}
        	}
        	prevSteps = nextSteps;
        	totalPaths = totalPaths%1000000007l + prevSteps[i][j]%1000000007l;
    		totalPaths = totalPaths % 1000000007l;
        }
		return (int)totalPaths;
    }

}
