package java1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class S249 {

	public static void main(String[] args) {
		String[] strings = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
		List<List<String>> result = groupStrings(strings);
		for(List<String> l : result){
			for(String s:l){
				System.out.print(s+" ");
			}
			System.out.println();
		}
	}
	
    public static List<List<String>> groupStrings(String[] strings) {    	
    	List<List<String>> result = new ArrayList<List<String>>();
    	HashMap<String, List<String>> map = new HashMap<String, List<String>>();
    	String[] modified = new String[strings.length];
    	for(int i = 0; i < strings.length; i++){
    		modified[i] = modify(strings[i]);
    		System.out.println(modified[i]);
    		if(map.containsKey(modified[i])){
    			List<String> list = map.get(modified[i]);
    			list.add(strings[i]);
    		}
    		else{
    			List<String> list = new ArrayList<String>();
    			list.add(strings[i]);
    			map.put(modified[i], list);
    		}
    	}
    	for(String s:map.keySet()){
    		result.add(map.get(s));
    	}
		return result;
    }

	private static String modify(String string) {
		int diff = 0;
		char c = string.charAt(0);
		diff = c - 'a';
		if(diff == 0){
			return string;
		}
		String s = "";
		for(int i = 0; i < string.length(); i++){
			c = string.charAt(i);
			if(c - diff >= 'a'){
				s += (char)(c - diff);
			}
			else{
				s += (char)('z' - ('a' - (c - diff) - 1));
			}
			
		}
		return s;
	}

}
