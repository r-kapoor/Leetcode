package PocketGems;

import java.util.*;

class ListNodeAndValue {
	int value;
	ArrayList<TreeNode> list;
	public ListNodeAndValue(int value, ArrayList<TreeNode> list){
		this.value = value;
		this.list = list;
	}
}

public class Solution {
     static int maxValue;
     static List<TreeNode> solution = new ArrayList<TreeNode>();
     
     public static void main(String args[]){
    	 TreeNode root = new TreeNode(1);
    	    root.left = new TreeNode(3);
    	    root.right = new TreeNode(2);
    	    root.left.left = new TreeNode(4);
    	    root.right.left = new TreeNode(6);
    	    root.right.right = new TreeNode(5);
    	 System.out.println(maxPathSum(root));
    	 for(TreeNode cur:solution){
    		 System.out.println(cur.val);
    	 }
     }
    public static int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxValue;
    }
    
    private static ListNodeAndValue maxPathDown(TreeNode node) {
    	ArrayList<TreeNode> pathFromThisNode = new ArrayList<TreeNode>();
    	int valueFromThisNode = 0;
        if (node == null) return new ListNodeAndValue(valueFromThisNode, pathFromThisNode);
        pathFromThisNode.add(node);
        valueFromThisNode += node.val;
        ListNodeAndValue left = maxPathDown(node.left);
        ListNodeAndValue right = maxPathDown(node.right);
        if(left.value > right.value){
        	pathFromThisNode.addAll(left.list);
        	valueFromThisNode += left.value;
        }
        else{
        	pathFromThisNode.addAll(right.list);
        	valueFromThisNode += right.value;
        }
        if(maxValue < left.value + right.value + node.val) {
        	maxValue = left.value + right.value + node.val;
        	solution = new ArrayList<TreeNode>();
        	solution.addAll(left.list);
        	solution.add(node);
        	solution.addAll(right.list);
        }
        
        return new ListNodeAndValue(valueFromThisNode, pathFromThisNode);
    }
}