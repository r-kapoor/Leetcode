package java1;

public class S96 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numTrees(3));
	}
	
	public static int numTrees(int n) {
        if(n == 1) {
        	return 1;
        }
        if(n == 2) {
        	return 2;
        }
        int[] numTrees = new int[n+1];
        numTrees[0] = 1;
        numTrees[1] = 1;
        numTrees[2] = 2;
        for(int i = 3; i <= n; i++) {
        	//Make each num as root. Take sum of BSTs
        	int sum = 0;
        	for(int j = 0; j < i; j++){
        		int onLeft = j;
        		int onRight = i-j-1;
        		sum += numTrees[onLeft]*numTrees[onRight];
        	}
        	numTrees[i] = sum;
        }
        return numTrees[n];
        
    }

}
