package java1;

public class S712 {

	public static void main(String[] args) {
		System.out.println(minimumDeleteSum("delete", "leet"));

	}
	
    public static int minimumDeleteSum(String s1, String s2) {
    	if(s1.equals(s2)){
    		return 0;
    	}
    	int[][] minCounts = new int[1+s1.length()][1+s2.length()];
    	for(int i = 1; i <= s1.length(); i++){
    		minCounts[i][0] = minCounts[i-1][0] + s1.charAt(i-1);
    	}
    	for(int i = 1; i <= s2.length(); i++){
    		minCounts[0][i] = minCounts[0][i-1] + s2.charAt(i-1);
    	}
    	for(int i = 1; i <= s1.length(); i++){
    		for(int j = 1; j <= s2.length(); j++){
    			if(s1.charAt(i-1) == s2.charAt(j-1)){
    				minCounts[i][j] = minCounts[i-1][j-1];
    			}
    			else{
    				minCounts[i][j] = Math.min(minCounts[i-1][j] + s1.charAt(i-1), minCounts[i][j-1] + s2.charAt(j-1));
    			}
    		}
    	}
        return minCounts[s1.length()][s2.length()];
    }

}
