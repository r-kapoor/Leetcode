package java1;

import java.util.LinkedList;
import java.util.List;

public class S102 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		if(root == null) {
			return result;
		}
		LinkedList<TreeNode> curr = new LinkedList<TreeNode>();
		curr.add(root);
		while(!curr.isEmpty()) {
			LinkedList<TreeNode> next = new LinkedList<TreeNode>();
			List<Integer> list = new LinkedList<Integer>();
			while(!curr.isEmpty()) {
				TreeNode node = curr.removeFirst();
				list.add(node.val);
				if(node.left != null) {
					next.addLast(node.left);
				}
				if(node.right != null) {
					next.addLast(node.right);
				}
			}
			result.add(list);
			curr = next;
		}
		return result;
        
    }

}
