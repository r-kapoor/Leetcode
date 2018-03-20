package java1;

import java.util.ArrayList;

public class S129 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
    public int sumNumbers(TreeNode root) {
        if(root == null) {
        	return 0;
        }
        getLastNumbers(root, "");
        int sum = 0;
        for(int num:nums){
        	sum += num;
        }
        return sum;
    }
    ArrayList<Integer> nums = new ArrayList<Integer>();
    
    private void getLastNumbers(TreeNode root, String numTillNow) {
    	numTillNow += root.val;
    	if(root.left == null && root.right == null) {
    		nums.add(Integer.parseInt(numTillNow));
    	}
    	else {
    		if(root.left != null) {
    			getLastNumbers(root.left, numTillNow);
    		}
    		if(root.right != null) {
    			getLastNumbers(root.right, numTillNow);
    		}
    	}
    }

}
