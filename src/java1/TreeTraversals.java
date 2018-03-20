package java1;

import java.util.Stack;

public class TreeTraversals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(0);
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node3.left = node4;
		node3.right = node5;
		node2.right = node6;
		TreeTraversals trav = new TreeTraversals();
		trav.preorderRec(root);
		System.out.println();
		trav.preorderIt(root);
		System.out.println();
		trav.inorderRec(root);
		System.out.println();
		trav.inorderIt(root);
		System.out.println();
		trav.postorderRec(root);
		System.out.println();
		trav.postorderIt(root);
		System.out.println();
	}
	
	public void preorderRec(TreeNode root) {
		if(root == null) {
			return;
		}
		System.out.print(root.val+",");
		preorderRec(root.left);
		preorderRec(root.right);
	}
	
	public void inorderRec(TreeNode root) {
		if(root == null) {
			return;
		}
		inorderRec(root.left);
		System.out.print(root.val+",");
		inorderRec(root.right);
		
	}
	
	public void postorderRec(TreeNode root) {
		if(root == null) {
			return;
		}
		postorderRec(root.left);
		postorderRec(root.right);
		System.out.print(root.val+",");
	}
	
	public void preorderIt(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if(root == null) {
			return;
		}
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode top = stack.pop();
			System.out.print(top.val + ",");
			if(top.right != null) {
				stack.push(top.right);
			}
			if(top.left != null) {
				stack.push(top.left);
			}
		}
	}
	
	public void inorderIt(TreeNode root) {
		Stack<Object> stack = new Stack<>();
		if(root == null) {
			return;
		}
		stack.push(root);
		while(!stack.isEmpty()) {
			Object top = stack.pop();
			if(top instanceof Integer) {
				Integer topVal = (Integer)top;
				System.out.print(topVal + ",");
			}
			else {
				TreeNode topNode = (TreeNode)top;
				if(topNode.right != null) {
					stack.push(topNode.right);
				}
				stack.push(topNode.val);
				if(topNode.left != null) {
					stack.push(topNode.left);
				}
			}
		}
	}

	public void postorderIt(TreeNode root) {
		Stack<Object> stack = new Stack<>();
		if(root == null) {
			return;
		}
		stack.push(root);
		while(!stack.isEmpty()) {
			Object top = stack.pop();
			if(top instanceof Integer) {
				Integer topVal = (Integer)top;
				System.out.print(topVal + ",");
			}
			else {
				TreeNode topNode = (TreeNode)top;
				stack.push(topNode.val);
				if(topNode.right != null) {
					stack.push(topNode.right);
				}
				if(topNode.left != null) {
					stack.push(topNode.left);
				}
			}
		}
	}


}
