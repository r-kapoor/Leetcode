package java1;

import java.util.ArrayList;
import java.util.List;

public class S228 {

	public static void main(String[] args) {
		int[] nums = {};
		List<String> result = summaryRanges(nums);
		for(String res:result){
			System.out.println(res);
		}
	}
	
    public static List<String> summaryRanges(int[] nums) {
    	ArrayList<String> result = new ArrayList<String>();
    	if(nums.length == 0){
    		return result;
    	}
    	if(nums.length == 1){
    		result.add(nums[0]+"");
    		return result;
    	}
    	int begin = nums[0];
    	boolean set = true;
    	int end = nums[0];
        for(int i = 1; i < nums.length; i++){
        	if(!set){
        		begin = nums[i];
        		end = nums[i];
        		set = true;
        		continue;
        	}
        	if(nums[i] == end + 1){
        		end = nums[i];
        	}
        	else{
        		if(begin == end){
        			result.add(begin+"");
        		}
        		else{
        			result.add(begin+"->"+end);
        		}
        		begin = nums[i];
        		end = nums[i];
        	}
        }
        if(set){
        	if(begin == end){
    			result.add(begin+"");
    		}
    		else{
    			result.add(begin+"->"+end);
    		}
        }
        return result;
    }

}
