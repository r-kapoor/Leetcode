package java1;

public class S449 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
    	if(root == null){
    		return "";
    	}
    	String serialized = root.val +"";
    	serialized = "(" + serialize(root.left) +")" + serialized + "(" + serialize(root.right) + ")";
    	return serialized;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	if("".equals(data) || "()".equals(data)){
    		return null;
    	}
    	int countOpen = 1;
    	int index = 1;
    	while(countOpen != 0) {
    		char cur = data.charAt(index);
    		if(cur == ')'){
    			countOpen--;
    		}
    		if(cur == '('){
    			countOpen++;
    		}
    		index++;
    	}
    	int start = index;
    	while(data.charAt(index) != '(') {
    		index++;
    	}
    	int end = index;
    	int rootVal = Integer.parseInt(data.substring(start, end));
    	TreeNode root = new TreeNode(rootVal);
    	root.left = deserialize(data.substring(1, start-1));
    	root.right = deserialize(data.substring(end+1, data.length()-1));
        return root;
    }

}
