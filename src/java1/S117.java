package java1;

import java.util.LinkedList;

public class S117 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void connect(TreeLinkNode root) {
        if(root == null) {
        	return;
        }
        LinkedList<TreeLinkNode> curr = new LinkedList<TreeLinkNode>();
        curr.add(root);
        while(!curr.isEmpty()) {
        	LinkedList<TreeLinkNode> next = new LinkedList<TreeLinkNode>();
        	while(!curr.isEmpty()) {
        		TreeLinkNode node = curr.removeFirst();
        		if(!curr.isEmpty()) {
        			node.next = curr.getFirst();
        		}
        		if(node.left != null) {
        			next.addLast(node.left);
        		}
        		if(node.right != null) {
        			next.addLast(node.right);
        		}
        	}
        	curr = next;
        }
    }

}
