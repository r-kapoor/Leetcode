package java1;

public class S222 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int countNodes(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int h = height(root);
		int count = countFullNodes(root, h);
		return (int)Math.pow(2, h) -1 + count;
    }

	private int countFullNodes(TreeNode root, int h) {
		if(root == null) {
			return 0;
		}
		if(h == 0) {
			return 1;
		}
		int left = countFullNodes(root.left, h-1);
		int right = 0;
		if(left == (int)Math.pow(2, h-1)) {
			right = countFullNodes(root.right, h-1);
		}
		int total = left + right;
		return total;
	}

	private int height(TreeNode root) {
		int h = 0;
		while(root.left != null) {
			h++;
			root = root.left;
		}
		return h;
	}

}
