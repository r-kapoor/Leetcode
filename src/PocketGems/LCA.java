package PocketGems;

public class LCA {
	 public TreeNode lowestCommonAncestorBinaryTree(TreeNode root, TreeNode p, TreeNode q) {
	        if(root == null || root == p || root == q)  return root;
	        TreeNode left = lowestCommonAncestorBinaryTree(root.left, p, q);
	        TreeNode right = lowestCommonAncestorBinaryTree(root.right, p, q);
	        if(left != null && right != null)   return root;
	        return left != null ? left : right;
	    }
	 
	 public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	        if(root.val > p.val && root.val > q.val){
	            return lowestCommonAncestor(root.left, p, q);
	        }else if(root.val < p.val && root.val < q.val){
	            return lowestCommonAncestor(root.right, p, q);
	        }else{
	            return root;
	        }
	    }
}
