package java1;

public class S718 {

	public static void main(String[] args) {
		int[] A = {1,2,3,2,1};
		int[] B = {3,2,1,4,7};
		System.out.println(findLength(A, B));
		
	}
	
    public static int findLength(int[] A, int[] B) {
    	int[][] intersections = new int[A.length][B.length];
    	for(int i = 0; i < A.length; i++){
    		for(int j = 0; j < B.length; j++){
    			if(A[i] == B[j]){
    				if(i == 0 || j == 0){
    					intersections[i][j] = 1;
    				}
    				else{
    					intersections[i][j] = intersections[i-1][j-1] + 1;
    				}
    			}
    		}
    	}
    	int max = 0;
    	for(int i = 0; i < A.length; i++){
    		for(int j = 0; j < B.length; j++){
    			if(max < intersections[i][j]){
    				max = intersections[i][j];
    			}
    		}
    	}
        return max;
    }

}
