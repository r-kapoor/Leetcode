package java1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class S655 {

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(8);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node3.right = node5;
		node4.left = node6;
		node5.right = node7;
		node4.right = node8;
		List<List<String>> result = printTree(node1);
		for(List<String> list:result){
			System.out.println(list);
		}
	}
	
    public static List<List<String>> printTree(TreeNode root) {
    	int height = heightOf(root);
    	List<List<String>> result = new LinkedList<List<String>>();
    	int numCols = 0;
    	for(int i = 0; i < height; i++){
    		numCols += (int)Math.pow(2, i);
    	}
    	String[][] array = new String[height][numCols];
    	for(int i = 0; i < array.length; i++){
    		Arrays.fill(array[i], "");
    	}
    	printTree(array, 0, numCols-1, root, 0);
    	for(int i = 0; i < array.length; i++){
    		result.add(Arrays.asList(array[i]));
    	}
    	return result;
    }
    
    private static void printTree(String[][] array, int begin, int end, TreeNode root, int level) {
    	if(level >= array.length || root==null){
    		return;
    	}
    	if(begin>end){
    		return;
    	}
    	int mid = (begin+end)/2;
    	array[level][mid] = root.val+"";
    	printTree(array, begin, mid-1, root.left, level+1);
    	printTree(array, mid+1, end, root.right, level+1);
	}
	private static int heightOf(TreeNode root) {
		if(root == null){
			return 0;
		}
		int left = heightOf(root.left);
		int right = heightOf(root.right);
		return Math.max(left, right) + 1;
	}

}
