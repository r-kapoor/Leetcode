package java1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class S113 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) {
        	return result;
        }
    	LinkedList<TreeNode> currPath = new LinkedList<TreeNode>();
        int currSum = 0;
        pathSum(root, sum, currSum, currPath, result);
        return result;
    }

	private void pathSum(TreeNode root, int sum, int currSum, LinkedList<TreeNode> currPath,
			List<List<Integer>> result) {
		if(root == null) {
			return;
		}
		currSum += root.val;
		currPath.addLast(root);
		if(root.left == null && root.right == null) {
			//Leaf node
			if(currSum == sum) {
				List<Integer> output = new ArrayList<Integer>();
				for(TreeNode node:currPath) {
					output.add(node.val);
				}
				result.add(output);
			}
		}
		else {
			pathSum(root.left, sum, currSum, currPath, result);
			pathSum(root.right, sum, currSum, currPath, result);
		}
		currPath.removeLast();
	}

}
