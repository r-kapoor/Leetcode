package java1;

import java.util.ArrayList;

public class S279 {

	public static void main(String[] args) {
		System.out.println(numSquares(8));
		System.out.println(numSquares(4));
		System.out.println(numSquares(5));
		System.out.println(numSquares(35));

	}
	
	public static int numSquares(int n) {
		int[] nums = new int[n+1];
		ArrayList<Integer> perfects = new ArrayList<Integer>();
		for(int i = 1; i*i <= n; i++){
			nums[i*i] = 1;
			perfects.add(i*i);
		}
		if(nums[n] == 1){
			return 1;
		}
		for(int i = 2; i <= n; i++){
			int min = Integer.MAX_VALUE;
			for(int perfect:perfects){
				if(perfect > i){
					break;
				}
				int possible = nums[i - perfect] + 1;
				if(possible < min){
					min = possible;
				}
			}
			nums[i] = min;
		}
		return nums[n];
    }

}
