package java1;

public class S337 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	public int rob(TreeNode root) {
        RobNotRob robNotRob = maxRob(root);
        return Math.max(robNotRob.robValue, robNotRob.notRobValue);
    }
	
	public RobNotRob maxRob(TreeNode root){
		if(root == null) {
			return new RobNotRob(0, 0);
		}
		RobNotRob left = maxRob(root.left);
		RobNotRob right = maxRob(root.right);
		return new RobNotRob(root.val + left.notRobValue + right.notRobValue, 
				Math.max(left.robValue, left.notRobValue) + Math.max(right.robValue, right.notRobValue));
	}
}

class RobNotRob {
	int robValue;
	int notRobValue;
	public RobNotRob(int robValue, int notRobValue) {
		this.robValue = robValue;
		this.notRobValue = notRobValue;
	}
}
