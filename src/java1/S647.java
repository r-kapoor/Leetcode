package java1;

public class S647 {

	public static void main(String[] args) {
		System.out.println(countSubstrings("aabaa"));
	}
	
    public static int countSubstrings(String s) {
    	if(s.length() == 0){
    		return 0;
    	}
    	if(s.length() == 1){
    		return 1;
    	}
    	boolean[][] isPalindrome = new boolean[s.length()][s.length()];
    	for(int i = 0; i < s.length(); i++){
    		isPalindrome[i][i] = true;
    	}
    	for(int i = 0; i < s.length()-1; i++){
    		if(s.charAt(i) == s.charAt(i+1)){
    			isPalindrome[i][i+1] = true;
    		}
    	}
    	for(int i = 2; i < s.length(); i++){
    		for(int j = 0; j < s.length()-i; j++){
    			if(s.charAt(j) == s.charAt(j+i)){
    				isPalindrome[j][j+i] = isPalindrome[j+1][j+i-1];
    			}
    		}
    	}
    	int count = 0;
    	for(int i = 0; i < s.length(); i++){
    		for(int j = i; j < s.length(); j++){
    			if(isPalindrome[i][j]){
    				count++;
    			}
    		}
    	}
        return count;
    }

}
