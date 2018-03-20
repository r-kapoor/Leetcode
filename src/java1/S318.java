package java1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;


public class S318 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String []words = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
		System.out.println(maxProduct(words));

	}
	
	public static int maxProduct(String[] words) {
        HashMap<Character, HashSet<Integer>> map = new HashMap<Character, HashSet<Integer>>();
        for(int i = 0; i < words.length; i++){
            for(int j = 0; j < words[i].length(); j++){
                char c = words[i].charAt(j);
                if(map.containsKey(c)){
                    map.get(c).add(i);
                }
                else{
                    HashSet<Integer> list = new HashSet<Integer>();
                    list.add(i);
                    map.put(c, list);
                }
            }
        }
        
        int maxProduct = 0;
        
        //Map is ready
        
        for(int i = 0; i < words.length; i++){
        	HashSet<Integer> common = new HashSet<Integer>();
        	for(int j = 0; j < words[i].length(); j++){
        		char cur = words[i].charAt(j);
        		HashSet<Integer> set = map.get(cur);
        		common.addAll(set);
        	}
        	for(int j = i+1; j < words.length; j++){
        		if(common.contains(j)){
        			continue;
        		}
        		int product = words[j].length() * words[i].length();
        		if(product > maxProduct){
        			maxProduct = product;
        		}
        	}
        }
        
//        for(char c : map.keySet()){
//            for(int i : map.get(c)){
//                if(!covered.contains(i)){
//                    covered.add(i);
//                    System.out.println("Main:"+words[i]);
//                    for(int charI = 0; charI < 26; charI++){
//                        char n = (char) ('a'+charI);
//                        if(words[i].indexOf(n) == -1){
//                        	if(map.containsKey(n)){
//                        		ArrayList<Integer> uncommon = map.get(n);
//                                for(int j : uncommon){
//                                	System.out.println(words[j]);
//                                    int product = words[j].length() * words[i].length();
//                                    if(product > maxProduct){
//                                        maxProduct = product;
//                                    }
//                                }
//                        	}
//                        }
//                    }
//                }
//                
//            }
//        }
        return maxProduct;
    }

}
