package java1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class S515 {

	public static void main(String[] args) {

	}
	
    public List<Integer> largestValues(TreeNode root) {
    	List<Integer> largest = new ArrayList<Integer>();
    	if(root == null){
    		return largest;
    	}
    	LinkedList<TreeNode> curr = new LinkedList<TreeNode>();
    	curr.addLast(root);
    	while(!curr.isEmpty()){
    		int max = Integer.MIN_VALUE;
    		LinkedList<TreeNode> next = new LinkedList<TreeNode>();
    		while(!curr.isEmpty()){
    			TreeNode node = curr.removeFirst();
        		if(max < node.val){
        			max = node.val;
        		}
        		if(node.left != null){
        			next.add(node.left);
        		}
        		if(node.right != null){
        			next.add(node.right);
        		}
    		}
    		largest.add(max);
    		curr = next;
    	}
    	return largest;
    }

}
