package java1;

public class S650 {

	public static void main(String[] args) {
		System.out.println(minSteps(9));
	}
	
    public static int minSteps(int n) {
    	if(n == 1){
    		return 0;
    	}
    	if(n == 2){
    		return 2;
    	}
    	int[] allSteps = new int[n+1];
    	allSteps[1] = 0;
    	allSteps[2] = 2;
    	for(int i = 3; i <= n; i++){
    		int min = Integer.MAX_VALUE;
    		for(int j = 1; j <= i/2; j++){
    			if(i%j == 0){
    				//Divides
    				int steps = i/j + allSteps[j];
    				if(steps < min){
    					min = steps;
    				}
    			}
    		}
    		allSteps[i] = min;
    	}
        return allSteps[n];
    }

}
