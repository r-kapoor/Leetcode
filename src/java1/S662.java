package java1;

import java.util.LinkedList;

public class S662 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(1);
		TreeNode node3 = new TreeNode(1);
		TreeNode node4 = new TreeNode(1);
		TreeNode node5 = new TreeNode(1);
		TreeNode node6 = new TreeNode(1);
		TreeNode node7 = new TreeNode(1);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node3.right = node5;
		node4.left = node6;
		node5.right = node7;
		System.out.println(widthOfBinaryTree(node1));
	}
	
    public static int widthOfBinaryTree(TreeNode root) {
        if(root == null){
        	return 0;
        }
        int maxWidth = 1;
    	LinkedList<TreeNode> listCur = new LinkedList<TreeNode>();
        listCur.add(root);
        while(listCur.size() != 0){
        	LinkedList<TreeNode> listNext = new LinkedList<TreeNode>();
        	for(TreeNode node : listCur){
        		if(node != null){
        			listNext.addLast(node.left);
        			listNext.addLast(node.right);
        		}
        		else{
        			listNext.addLast(null);
        			listNext.addLast(null);
        		}
        	}
        	int width = findWidthOfLevel(listNext);
        	if(maxWidth < width){
        		maxWidth = width;
        	}
        	if(width > 0){
        		listCur = listNext;
        	}
        	else{
        		break;
        	}
        }
    	return maxWidth;
    }

	private static int findWidthOfLevel(LinkedList<TreeNode> listNext) {
		while(!listNext.isEmpty() && listNext.getFirst() == null){
			listNext.removeFirst();
		}
		while(!listNext.isEmpty() && listNext.getLast() == null){
			listNext.removeLast();
		}
		return listNext.size();
	}

}
