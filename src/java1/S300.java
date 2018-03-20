package java1;

public class S300 {

	public static void main(String[] args) {
//		int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
		int[] nums = {-2, -1};
		System.out.println(lengthOfLIS(nums));
	}
	
    public static int lengthOfLIS(int[] nums) {
    	if(nums.length == 0){
    		return 0;
    	}
    	if(nums.length == 1){
    		return 1;
    	}
    	int[] longestSequenceEndingAt = new int[nums.length];
    	longestSequenceEndingAt[0] = 1;
    	for(int i = 1; i < nums.length; i++){
    		int max = 0;
    		for(int j = i-1; j >= 0; j--){
    			if(nums[j] < nums[i]){
    				if(max < longestSequenceEndingAt[j]){
    					max = longestSequenceEndingAt[j];
    				}
    			}
    		}
    		longestSequenceEndingAt[i] = max+1;
    	}
    	int max = 0;
    	for(int i = 0; i < nums.length; i++){
    		if(max < longestSequenceEndingAt[i]){
    			max = longestSequenceEndingAt[i];
    		}
    	}
        return max;
    }

}
