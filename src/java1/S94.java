package java1;

import java.util.LinkedList;
import java.util.List;

public class S94 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) {
        	return new LinkedList<Integer>();
        }
        List<Integer> left = inorderTraversal(root.left);
        left.add(root.val);
        List<Integer> right = inorderTraversal(root.right);
        left.addAll(right);
        return left;
    }

}
