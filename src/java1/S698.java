package java1;

import java.util.Arrays;
import java.util.Comparator;

public class S698 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {553,450,2412,1735,521,170,943,87,3200,473,75,3819,492,324,689,629};
		System.out.println(canPartitionKSubsets(nums, 4));
	}
	
	public static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        if(sum % k != 0){
            return false;
        }
        int eachSetSum = sum/k;
        int[] sets = new int[k];
        Arrays.sort(nums);
        if(nums[nums.length-1] > eachSetSum){
        	return false;
        }
        return partition(sets, nums, 0, eachSetSum);
    }
    
    public static boolean partition(int[] sets, int[] nums, int cur, int eachSetSum){
        if(cur == nums.length){
            //Reached end
            for(int i = 0; i < sets.length; i++){
                if(sets[i] != eachSetSum){
                    return false;
                }
            }
            return true;
        }
        for(int i = 0; i < sets.length; i++){
            if(sets[i] + nums[cur] <= eachSetSum){
                sets[i] += nums[cur];
                boolean isPossible = partition(sets, nums, cur+1, eachSetSum);
                if(isPossible){
                    return true;
                }
                else{
                	sets[i] -= nums[cur];
                }
            }
            else{
            	break;
            }
        }
        return false;
    }

}
