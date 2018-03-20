package java1;

public class S106 {

	public static void main(String[] args) {
		int inorder[] = {1, 2, 3};
		int postorder[] = {3, 2, 1};	
		buildTree(inorder, postorder);
	}
	
	public static TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }

	private static TreeNode buildTree(int[] inorder, int inorderI, int inorderJ, int[] postorder, int postorderI, int postorderJ) {
		System.out.print(inorderI+":"+inorderJ+"::"+postorderI+":"+postorderJ);
		System.out.println();
		if(inorderI > inorderJ) {
			return null;
		}
		if(inorderI == inorderJ) {
			return new TreeNode(inorder[inorderI]);
		}
		if(inorderJ - 1 == inorderI) {
			if(inorder[inorderI] == postorder[postorderI]) {
				TreeNode root = new TreeNode(inorder[inorderJ]);
				root.left = new TreeNode(inorder[inorderI]);
				return root;
			}
			else {
				TreeNode root = new TreeNode(inorder[inorderI]);
				root.right = new TreeNode(inorder[inorderJ]);
				return root;
			}
		}
		int root = postorder[postorderJ];
		int rootInorderIndex = 0;
		for(int i = inorderI; i <= inorderJ; i++) {
			if(inorder[i] == root) {
				rootInorderIndex = i;
				break;
			}
		}
		TreeNode rootNode = new TreeNode(root);
		int leftLength = rootInorderIndex - inorderI;
		int rightLength = inorderJ - rootInorderIndex;
		if(rightLength > 0) {
			rootNode.right = buildTree(inorder, rootInorderIndex+1, inorderJ, postorder, postorderJ-rightLength, postorderJ-1);
		}
		if(leftLength > 0) {
			rootNode.left = buildTree(inorder, inorderI, rootInorderIndex-1, postorder, postorderI, postorderI+leftLength-1);
		}
		return rootNode;
	}

}
