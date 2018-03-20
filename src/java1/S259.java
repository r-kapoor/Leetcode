package java1;

import java.util.Arrays;

public class S259 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-1, 1, -1, -1};
		System.out.println(threeSumSmaller(nums, -1));
	}
	
    public static int threeSumSmaller(int[] nums, int target) {
        int count = 0;
    	Arrays.sort(nums);
    	for(int i = 0; i < nums.length - 2; i++){
    		int remTarget = target - nums[i];
//    		if(remTarget > 0){
    			for(int j = i+1; j < nums.length - 1; j++){
    				int remremTarget = remTarget - nums[j];
    				int index = binarySearch(remremTarget, j+1, nums.length-1, nums);
    				if(index != -1){
    					count += index - j;
    				}
    			}
//    			int begin = i+1;
//    			int end = nums.length-1;
//    			while(begin<=end){
//    				if(nums[begin] + nums[end] < remTarget){
//    					begin++;
//    				}
//    				else if(nums[begin] + nums[end] > remTarget){
//    					end--;
//    				}
//    				else{
//    					break;
//    				}
//    			}
//    			for(int k = i+1; k <= begin; k++){
//    				count += end - k;
//    			}
//    		}
    	}
        return count;
    }

	private static int binarySearch(int target, int i, int j, int[] nums) {
		if(i > j){
			return -1;
		}
		if(i == j){
			if(target > nums[i]){
				return i;
			}
			return -1;
		}
		if(i+1 == j){
			if(target > nums[j]){
				return j;
			}
			if(target > nums[i]){
				return i;
			}
			return -1;
		}
		int mid = (i+j)/2;
		if(nums[mid] >= target){
			return binarySearch(target, i, mid, nums);
		}
		if(nums[mid] < target){
			int res = binarySearch(target, mid, j, nums);
			if(res == -1){
				return mid;
			}
			return res;
		}
		return -1;
	}

}
