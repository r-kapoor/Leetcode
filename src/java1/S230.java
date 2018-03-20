package java1;

public class S230 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	int count = 0;
	int value = 0;
	public int kthSmallest(TreeNode root, int k) {
		kthSmallestHelper(root, k);
        return value;
    }
	
	private void kthSmallestHelper(TreeNode root, int k){
		if(root == null) {
			return;
		}
		kthSmallestHelper(root.left, k);
		count++;
		if(count == k) {
			value = root.val;
			return;
		}
		kthSmallestHelper(root.right, k);
	}

}
