package java1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class S139 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("leet");
		list.add("code");
		System.out.println(wordBreak("leetcode", list));
	}
	
	public static boolean wordBreak(String s, List<String> wordDict) {
		HashSet<String> set = new HashSet<String>();
		int minLength = Integer.MAX_VALUE;
		int maxLength = 0;
		for(String word:wordDict){
			set.add(word);
			if(word.length() > maxLength){
				maxLength = word.length();
			}
			if(word.length() < minLength){
				minLength = word.length();
			}
		}
		return wordBreak(s, set, minLength, maxLength);
	}
	
	public static boolean wordBreak(String s, HashSet<String> wordDict, int minLength, int maxLength) {
        if(s.length() == 0){
        	return true;
        }
        boolean breakPossible = false;
        for(int i = minLength; i <= maxLength; i++){
        	if(s.length() < i){
        		break;
        	}
        	String possibleWord = s.substring(0, i);
        	if(wordDict.contains(possibleWord)){
        		breakPossible = wordBreak(s.substring(possibleWord.length()), wordDict, minLength, maxLength);
        	}
        	if(breakPossible){
        		return true;
        	}
        }
		return false;
    }

}
