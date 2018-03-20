package java1;

public class S673 {

	public static void main(String[] args) {
		int[] nums = {1,3,5,4,7};
//		int[] nums = {2, 2, 2, 2, 2};
		System.out.println(findNumberOfLIS(nums));
	}
	
    public static int findNumberOfLIS(int[] nums) {
    	if(nums.length == 0){
    		return 0;
    	}
    	if(nums.length == 1){
    		return 1;
    	}
    	int[] longestSequenceEndingAt = new int[nums.length];
    	int[] countOfSequences = new int[nums.length];
    	longestSequenceEndingAt[0] = 1;
    	countOfSequences[0] = 1;
    	for(int i = 1; i < nums.length; i++){
    		int max = 0;
    		int count = 0;
    		for(int j = i-1; j >= 0; j--){
    			if(nums[j] < nums[i]){
    				if(max < longestSequenceEndingAt[j]){
    					max = longestSequenceEndingAt[j];
    					count = countOfSequences[j];
    				}
    				else if(max == longestSequenceEndingAt[j]){
    					count+=countOfSequences[j];
    				}
    			}
    		}
    		longestSequenceEndingAt[i] = max+1;
    		countOfSequences[i] = Math.max(count, 1);
    	}
    	int max = 0;
    	int count = 0;
    	for(int i = 0; i < nums.length; i++){
//    		System.out.println("LIS:"+longestSequenceEndingAt[i]+", Count:"+countOfSequences[i]);
    		if(max < longestSequenceEndingAt[i]){
    			max = longestSequenceEndingAt[i];
    			count = countOfSequences[i];
    		}
    		else if(max == longestSequenceEndingAt[i]){
    			count += countOfSequences[i];
    		}
    	}
        return count;
    }

}
