package java1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class S524 {

	public static void main(String[] args) {
		String s = "jhef";
		ArrayList<String> d = new ArrayList<String>();
//		d.add("ale");
//		d.add("apple");
//		d.add("monkey");
//		d.add("plea");
		d.add("a");
		d.add("b");
		d.add("c");
		System.out.println(findLongestWord(s, d));
	}
	
	public static String findLongestWord(String s, List<String> d) {
		Collections.sort(d);
		int max = 0;
		String maxString = "";
		for(String word:d){
			if(word.length() > max){
				if(isSubsequence(word, s)){
					maxString = word;
					max = word.length();
				}
			}
		}
		return maxString;
	}

	private static boolean isSubsequence(String word, String s) {
		if(word.length() == 0){
			return true;
		}
		if(word.equals(s)){
			return true;
		}
		if(word.length() > s.length()){
			return false;
		}
		if(word.charAt(0) == s.charAt(0)){
			if(isSubsequence(word.substring(1), s.substring(1))){
				return true;
			}
		}
		return isSubsequence(word, s.substring(1));
	}
}
