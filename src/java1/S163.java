package java1;

import java.util.ArrayList;
import java.util.List;

public class S163 {

	public static void main(String[] args) {
//		int[] nums = {0, 1, 3, 50, 75};
		int[] nums = {2147483647};
		List<String> ranges = findMissingRanges(nums, 2147483647, 2147483647);
		for(String s : ranges){
			System.out.println(s);
		}
	}

	public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
		List<String> sol = new ArrayList<String>();
        int cur = lower;
        int ind = 0;
        while(cur <= upper && ind < nums.length){
            if(nums[ind] < cur){
            	ind++;
            	continue;
            }
            else if(nums[ind] == cur){
            	if(cur == Integer.MAX_VALUE){
            		return sol;
            	}
            	ind++;
            	cur++;
            	continue;
            }
            else if(nums[ind] > cur){
            	if(nums[ind] <= upper){
            		String s = getString(cur, nums[ind]-1);
                	sol.add(s);
                	if(nums[ind] == Integer.MAX_VALUE){
                		return sol;
                	}
                	cur = nums[ind]+1;
            	}
            	else{
            		String s = getString(cur, upper);
                	sol.add(s);
                	if(upper == Integer.MAX_VALUE){
                		return sol;
                	}
                	cur = upper+1;
                	break;
            	}
            }
        }
        if(cur <= upper){
        	String s = getString(cur, upper);
        	sol.add(s);
        }
        return sol;
    }

	private static String getString(int cur, int i) {
		if(cur == i){
			return "" + cur;
		}
		String s = cur + "->" + i;
		return s;
	}
	
}
