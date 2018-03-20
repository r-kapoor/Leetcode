package java1;

public class MaxSumSubarray {
	
	public static void main(String args[]){
		int[] arr = {2, -1, 10, 2, 3, -3, -6, -4, 10, 3, 9, -1, -4, 7};
		System.out.println(maxSubArray(arr));
	}
	
	public static int maxSubArray(int arr[]){
		int curSum = 0;
		int maxSum = 0;
		for(int i = 0; i < arr.length; i++){
			curSum += arr[i];
			if(curSum < 0){
				curSum = 0;
			}
			if(maxSum < curSum){
				maxSum = curSum;
			}
		}
		return maxSum;
	}
}
