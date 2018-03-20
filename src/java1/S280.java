package java1;

import java.util.Arrays;

public class S280 {

	public static void main(String[] args) {
		int[] nums = {3, 5, 2, 1, 6, 4};
		wiggleSort(nums);
		for(int num:nums){
			System.out.println(num);
		}
	}
	
    public static void wiggleSort(int[] nums) {
        for(int i = 0; i < nums.length; i++){
        	int min = Integer.MIN_VALUE;
        	int minIndex = -1;
        	System.out.println("I:"+i+":"+modified(i, nums.length));
        	for(int j = i; j < nums.length; j++){
        		System.out.println("J:"+j+":"+modified(j, nums.length));
        		if(minIndex == -1 || nums[modified(j, nums.length)] < min ){
        			min = nums[modified(j, nums.length)];
        			minIndex = j;
        		}
        	}
        	System.out.println("M:"+min);
        	int temp = nums[modified(i, nums.length)];
        	nums[modified(i, nums.length)] = nums[modified(minIndex, nums.length)];
        	nums[modified(minIndex, nums.length)] = temp;
        }
    }

	private static int modified(int i, int length) {
		if(i*2 < length){
			return i*2;
		}
		if(length%2 == 0){
			return i*2-length+1;
		}
		return i*2-length;
	}
}
