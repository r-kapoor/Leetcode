package java1;

import java.util.HashMap;
import java.util.HashSet;

public class S288 {
	HashMap<String, HashSet<String>> abbr = new HashMap<String, HashSet<String>>();

	public static void main(String[] args) {
		String[] dictionary = {"hello", "hollo"};
		String word = "hello";
		S288 obj = new S288(dictionary);
//		System.out.println(obj.abbreviate(word));
		System.out.println(obj.isUnique(word));
	}

    public S288(String[] dictionary) {
        for(String word:dictionary){
        	String abbre = abbreviate(word);
        	if(abbr.containsKey(abbre)){
        		abbr.get(abbre).add(word);
        	}
        	else{
        		HashSet<String> words = new HashSet<String>();
        		words.add(word);
        		abbr.put(abbre, words);
        	}
        }
    }
    
    private String abbreviate(String word) {
		if(word.length() <= 2){
			return word;
		}
		String out = "" + word.charAt(0) + (word.length()-2) + word.charAt(word.length()-1);
		return out;
	}

	public boolean isUnique(String word) {
		String abbre = abbreviate(word);
		if(abbr.containsKey(abbre)){
			HashSet<String> words = abbr.get(abbre);
			if(words.size() == 1 && words.contains(word)){
				return true;
			}
			return false;
		}
    	return true;
        
    }
    
}