package java1;

public class S654 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static TreeNode constructMaximumBinaryTree(int[] nums) {
		return constructMaximumBinaryTree(nums, 0, nums.length-1);
    }

	private static TreeNode constructMaximumBinaryTree(int[] nums, int begin, int end) {
		if(begin > end || begin < 0 || end >= nums.length){
			return null;
		}
		if(begin == end){
			return new TreeNode(nums[begin]);
		}
		int max = nums[begin];
		int maxIndex = begin;
		for(int i = begin; i <= end; i++){
			if(max < nums[i]){
				max = nums[i];
				maxIndex = i;
			}
		}
		TreeNode root = new TreeNode(max);
		root.left = constructMaximumBinaryTree(nums, begin, maxIndex-1);
		root.right = constructMaximumBinaryTree(nums, maxIndex+1, end);
		return root;
	}
}
