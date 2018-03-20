package java1;

import java.util.LinkedList;

public class S623 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d == 1){
        	TreeNode changedRoot = new TreeNode(v);
        	changedRoot.left = root;
        	return changedRoot;
        }
        LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
        int cur = 2;
        nodes.add(root);
        while(cur < d){
        	LinkedList<TreeNode> nextNodes = new LinkedList<TreeNode>();
        	while(!nodes.isEmpty()){
        		TreeNode node = nodes.removeFirst();
        		if(node.left != null){
        			nextNodes.addFirst(node.left);
        		}
        		if(node.right != null){
        			nextNodes.addFirst(node.right);
        		}
        	}
        	cur++;
        	nodes = nextNodes;
        }
        for(TreeNode node:nodes) {
        	TreeNode left = node.left;
        	TreeNode right = node.right;
        	TreeNode newLeft = new TreeNode(v);
        	TreeNode newRight = new TreeNode(v);
        	newLeft.left = left;
        	newRight.right = right;
        	node.left = newLeft;
        	node.right = newRight;
        }
        return root;
    }

}
