package java1;

public class S114 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void flatten(TreeNode root) {
        if(root == null) {
        	return;
        }
        flatten(root.left);
        flatten(root.right);
        if(root.left != null) {
        	TreeNode temp = root.left;
        	while(temp.right != null) {
        		temp = temp.right;
        	}
        	temp.right = root.right;
        	root.right = root.left;
            root.left = null;
        }
        
    }

}
