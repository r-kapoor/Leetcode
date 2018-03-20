package java1;

public class S678 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(checkValidString("((*))"));
	}
	
	public static boolean checkValidString(String s) {
        return checkValidString(s, 0, 0);
    }

	private static boolean checkValidString(String s, int index, int currOpened) {
		if(currOpened < 0) {
			return false;
		}
		if(index >= s.length()) {
			return currOpened==0;
		}
		if(s.charAt(index) == '(') {
			return checkValidString(s, index+1, currOpened+1);
		}
		if(s.charAt(index) == ')') {
			return checkValidString(s, index+1, currOpened-1);
		}
		boolean result = false;
		if(currOpened > 0) {
			// Treat as )
			result = checkValidString(s, index+1, currOpened-1);
		}
		if(result) {
			return true;
		}
		// Treat as ""
		result = checkValidString(s, index+1, currOpened);
		if(result) {
			return true;
		}
		// Treat as (
		result = checkValidString(s, index+1, currOpened+1);
		return result;
	}

}
