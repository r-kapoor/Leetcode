package java1;

import java.util.LinkedList;

public class S513 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int findBottomLeftValue(TreeNode root) {
		LinkedList<TreeNode> curr =  new LinkedList<TreeNode>();
		int bottomLeft = root.val;
		curr.add(root);
		while(!curr.isEmpty()){
			bottomLeft = curr.peek().val;
			LinkedList<TreeNode> next = new LinkedList<TreeNode>();
			while(!curr.isEmpty()) {
				TreeNode node = curr.removeFirst();
				if(node.left != null){
					next.add(node.left);
				}
				if(node.right != null){
					next.add(node.right);
				}
			}
			curr = next;
		}
		return bottomLeft;
    }

}
