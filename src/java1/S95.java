package java1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class S95 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<TreeNode> generateTrees(int n) {
		HashMap<String, List<TreeNode>> trees = new HashMap<String, List<TreeNode>>();
		if(n == 0) {
			return new ArrayList<TreeNode>();
		}
        List<TreeNode> list = new ArrayList<TreeNode>();
        TreeNode node = new TreeNode(1);
        list.add(node);
        if(n == 1) {
        	return list;
        }
        trees.put("0:0", list);
        TreeNode node2 = new TreeNode(2);
        
        if(n == 2) {
        	
        }
        return list;
    }

}
