package java1;

import java.util.HashMap;

public class S416 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] nums = {1, 5, 11, 5};
		int[] nums = {1, 2, 3, 5};
		System.out.println(canPartition(nums));
	}
	
    public static boolean canPartition(int[] nums) {
    	int[] sums = new int[nums.length];
    	int sum = 0;
    	for(int i = 0; i < nums.length; i++){
    		sum += nums[i];
    		sums[i] = sum;
    	}
    	if(sum%2 != 0){
    		return false;
    	}
    	HashMap<String, Boolean> can = new HashMap<String, Boolean>();
    	return canPartition(nums, sums, nums.length-1, 0, can);
    }
    
    public static boolean canPartition(int[] nums, int[] sums, int index, int differ, HashMap<String, Boolean> can){
    	String input = index+":"+differ;
    	if(can.containsKey(input)){
    		return can.get(input);
    	}
    	if(index == -1){
    		return true;
    	}
    	if(index == 0){
    		if(differ == nums[index]){
    			return true;
    		}
    		return false;
    	}
    	if(sums[index] < differ){
    		return false;
    	}
    	boolean inPart1 = canPartition(nums, sums, index-1, Math.abs(differ-nums[index]), can);
    	if(inPart1){
    		can.put(input, true);
    		return true;
    	}
    	boolean inPart2 = canPartition(nums, sums, index-1, differ + nums[index], can);
    	can.put(input, inPart2);
    	return inPart2;
    }

}
