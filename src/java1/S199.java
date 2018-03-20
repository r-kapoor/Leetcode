package java1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class S199 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> rightView = new ArrayList<Integer>();
		if(root == null) {
			return rightView;
		}
		LinkedList<TreeNode> curr = new LinkedList<TreeNode>();		
		curr.add(root);
		while(!curr.isEmpty()) {
			rightView.add(curr.peekLast().val);
			LinkedList<TreeNode> next = new LinkedList<TreeNode>();
			while(!curr.isEmpty()) {
				TreeNode node = curr.removeFirst();
				if(node.left != null) {
					next.addLast(node.left);
				}
				if(node.right != null) {
					next.addLast(node.right);
				}
			}
			curr = next;
		}
		return rightView;
    }

}
