package java1;

public class S360 {

	public static void main(String[] args) {
		int[] nums = {-4, -2, 2, 4};
		int[] transformed = sortTransformedArray(nums, 0, 3, 5);
		for(int a:transformed){
			System.out.println(a);
		}
	}
	
	public static int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] transformed = new int[nums.length];
        if(a == 0){
        	
    		for(int i = 0; i < nums.length; i++){
    			if(b>0){
    				transformed[i] = transform(nums[i], a, b, c);
    			}
    			else{
    				transformed[nums.length - i - 1] = transform(nums[i], a, b, c);
    			}
    		}
        	
        }
        else if(a>0){
        	double mid = -(double)b/(2*a);
        	int i = 0;
        	while(i < nums.length && mid > nums[i]){
        		i++;
        	}
        	int left = i - 1;
        	int right = i;
        	int outI = 0;
        	while(left>=0 && right < nums.length){
        		int leftVal = transform(nums[left], a, b, c);
        		int rightVal = transform(nums[right], a, b, c);
        		if(leftVal < rightVal){
        			transformed[outI] = leftVal;
        			left--;
        		}
        		else{
        			transformed[outI] = rightVal;
        			right++;
        		}
        		outI++;
        	}
        	while(left >= 0){
        		int leftVal = transform(nums[left], a, b, c);
        		transformed[outI] = leftVal;
    			left--;
    			outI++;
        	}
        	while(right < nums.length){
        		int rightVal = transform(nums[right], a, b, c);
        		transformed[outI] = rightVal;
    			right++;
    			outI++;
        	}
        }
        else{
        	int left = 0;
        	int right = nums.length - 1;
        	int outI = 0;
        	while(left <= right){
        		int leftVal = transform(nums[left], a, b, c);
        		int rightVal = transform(nums[right], a, b, c);
        		if(leftVal < rightVal){
        			transformed[outI] = leftVal;
        			left++;
        		}
        		else{
        			transformed[outI] = rightVal;
        			right--;
        		}
        		outI++;
        	}
        }
        return transformed;
    }
	
	static int transform(int num, int a, int b, int c){
		return a*num*num + b*num + c;
	}

}
