package java1;

public class S450 {

	public static void main(String[] args) {

	}
	
	public TreeNode deleteNode(TreeNode root, int key) {
		if(root == null) {
			return null;
		}
        if(root.val == key){
        	//Delete the node
        	if(root.right == null){
        		return root.left;
        	}
        	if(root.left == null){
        		return root.right;
        	}
        	TreeNode right = root.right;
        	while(right.left != null) {
        		right = right.left;
        	}
        	right.left = root.left;
        	return root.right;
        }
        if(key < root.val){
        	root.left = deleteNode(root.left, key);
        }
        else {
        	root.right = deleteNode(root.right, key);
        }
        return root;
    }

}
