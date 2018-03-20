package java1;

public class S98 {

	public static void main(String[] args) {

	}
	
	public boolean isValidBST(TreeNode root) {
        if(root == null) {
        	return true;
        }
        return validBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

	private boolean validBST(TreeNode root, int minValue, int maxValue) {
		if(root == null) {
			return true;
		}
		if(root.val == Integer.MIN_VALUE && root.left != null) {
			return false;
		}
		if(root.val == Integer.MAX_VALUE && root.right != null) {
			return false;
		}
		if(root.val >= minValue && root.val <= maxValue) {
			return validBST(root.left, minValue, root.val-1) && validBST(root.right, root.val+1, maxValue);
		}
		return false;
	}

}
