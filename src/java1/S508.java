package java1;

import java.util.ArrayList;
import java.util.HashMap;

public class S508 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] findFrequentTreeSum(TreeNode root) {
		HashMap<Integer, Integer> treeSumCount = new HashMap<Integer, Integer>();
		findTreeSum(root, treeSumCount);
		int max = 0;
		ArrayList<Integer> maxValues = new ArrayList<Integer>();
		for(int treeSum : treeSumCount.keySet()){
			int count = treeSumCount.get(treeSum);
			if(max < count){
				max = count;
				maxValues = new ArrayList<Integer>();
				maxValues.add(treeSum);
			}
			else if(max == count){
				maxValues.add(treeSum);
			}
		}
		int[] result = new int[maxValues.size()];
		int index = 0;
		for(int val:maxValues){
			result[index] = val;
			index++;
		}
		return result;
    }

	private int findTreeSum(TreeNode root, HashMap<Integer, Integer> treeSumCount) {
		if(root == null){
			return 0;
		}
		int left = findTreeSum(root.left, treeSumCount);
		int right = findTreeSum(root.right, treeSumCount);
		int treeSum = left + root.val + right;
		treeSumCount.put(treeSum, treeSumCount.getOrDefault(treeSum, 0) + 1);
		return treeSum;
	}
	
	

}
