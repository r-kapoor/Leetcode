package java1;

public class S392 {

	public static void main(String[] args) {
		String s = "leeeeetcode";
		String t = "yyylyyyeyyyeyyyeyyyytyyyycyyyoyyyydyyey";
		System.out.println(isSubsequence(s, t));
	}
	
	public static boolean isSubsequence(String s, String t) {
		if(s.length() == 0){
			return true;
		}
		if(t.length() == 0){
			return false;
		}
		int[] maxLengthSubsequencePrev = new int[s.length()];
		int[] maxLengthSubsequenceCurr = new int[s.length()];
		if(s.charAt(0) == t.charAt(0)){
			maxLengthSubsequencePrev[0] = 1;
		}
		for(int i = 1; i < s.length(); i++){
			maxLengthSubsequencePrev[i] = maxLengthSubsequencePrev[i-1];
			if(s.charAt(i) == t.charAt(0)){
				maxLengthSubsequencePrev[i] = 1;
			}
		}
		for(int i = 1; i < t.length(); i++){
			maxLengthSubsequenceCurr = new int[s.length()];
			maxLengthSubsequenceCurr[0] = maxLengthSubsequencePrev[0];
			if(s.charAt(0) == t.charAt(i)){
				maxLengthSubsequenceCurr[0] = 1;
			}
			for(int j = 1; j < s.length(); j++){
				maxLengthSubsequenceCurr[j] = maxLengthSubsequencePrev[j];
				if(s.charAt(j) == t.charAt(i)){
					maxLengthSubsequenceCurr[j] = Math.max(maxLengthSubsequencePrev[j-1]+1, maxLengthSubsequenceCurr[j]);
				}
			}
			maxLengthSubsequencePrev = maxLengthSubsequenceCurr;
		}
//		System.out.println(maxLengthSubsequenceCurr[s.length()-1]);
		if(maxLengthSubsequenceCurr[s.length()-1] == s.length()){
			return true;
		}
		return false;
    }
}
