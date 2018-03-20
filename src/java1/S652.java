package java1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class S652 {
        
	public static void main(String[] args) {
		
	}
	
	public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		List<TreeNode> nodes = new ArrayList<TreeNode>();
		List<TreeNode> duplicates= new ArrayList<TreeNode>();
		HashSet<Integer> duplicateSet = new HashSet<Integer>();
		HashMap<TreeNode, Integer> nodeLevel = new HashMap<TreeNode, Integer>();
		traverse(root, nodes, nodeLevel);
		for(int i = 0; i < nodes.size(); i++){
			for(int j = i+1; j < nodes.size(); j++){
				if(isDuplicate(nodes.get(i), nodes.get(j), nodeLevel)){
					if(!duplicateSet.contains(i) && !duplicateSet.contains(j)){
						duplicates.add(nodes.get(i));
					}
					duplicateSet.add(i);
					duplicateSet.add(j);
				}
			}
		}
        return duplicates;
    }

	private static boolean isDuplicate(TreeNode treeNode1, TreeNode treeNode2, HashMap<TreeNode, Integer> nodeLevel) {
		if(treeNode1 == null && treeNode2 == null){
			return true;
		}
		if(treeNode1 == null || treeNode2 == null){
			return false;
		}
		if(treeNode1.val != treeNode2.val){
			return false;
		}
		if(nodeLevel.get(treeNode1) != nodeLevel.get(treeNode2)){
			return false;
		}
		if(isDuplicate(treeNode1.left, treeNode2.left, nodeLevel) && isDuplicate(treeNode1.right, treeNode2.right, nodeLevel)){
			return true;
		}
		return false;
	}

	private static int traverse(TreeNode root, List<TreeNode> nodes, HashMap<TreeNode, Integer> nodeLevel) {
		if(root == null){
			return 0;
		}
		int leftLevel = traverse(root.left, nodes, nodeLevel);
		nodes.add(root);
		int rightLevel = traverse(root.right, nodes, nodeLevel);
		int level = Math.max(leftLevel, rightLevel) + 1;
		nodeLevel.put(root, level);
		return level;
	}
	
}
