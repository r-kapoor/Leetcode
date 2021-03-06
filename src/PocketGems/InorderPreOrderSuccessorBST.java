package PocketGems;

public class InorderPreOrderSuccessorBST {
	public TreeNode successor(TreeNode root, TreeNode p) {
		  if (root == null)
		    return null;

		  if (root.val <= p.val) {
		    return successor(root.right, p);
		  } else {
		    TreeNode left = successor(root.left, p);
		    return (left != null) ? left : root;
		  }
		}
//--------------------------------------------------------------------
	public TreeNode predecessor(TreeNode root, TreeNode p) {
		  if (root == null)
		    return null;

		  if (root.val >= p.val) {
		    return predecessor(root.left, p);
		  } else {
		    TreeNode right = predecessor(root.right, p);
		    return (right != null) ? right : root;
		  }
		}
}
