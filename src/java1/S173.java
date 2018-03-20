package java1;

import java.util.Stack;

public class S173 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(0);
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		root.left = n1;
		n1.left = n2;
		n2.left = n3;
		n1.right = n4;
		n4.right = n5;
		n5.left = n6;
		n6.left = n7;
		S173 i = new S173(root);
		while (i.hasNext()) System.out.println(i.next());

	}
	
	Stack<TreeNode> stack;
	
    public S173(TreeNode root) {
    	stack = new Stack<TreeNode>();
    	while(root != null) {
    		stack.push(root);
    		root = root.left;
    	}
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
    	TreeNode top = stack.pop();
    	if(top.right != null) {
    		TreeNode right = top.right;
    		while(right != null) {
    			stack.push(right);
    			right = right.left;
    		}
    	}
        return top.val;
    }

}
