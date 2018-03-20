package java1;

import java.util.HashSet;

public class S467 {

	public static void main(String[] args) {
		System.out.println(findSubstringInWraproundString("a"));
	}

    public static int findSubstringInWraproundString(String p) {
    	int sum = 0;
    	char prev = ' ';
    	String current = "";
    	int counter = 0;
    	HashSet<String> set = new HashSet<String>();
    	for(int i = 0; i < p.length(); i++){
    		char curr = p.charAt(i);
    		if((int)curr == (int)prev+1 || (curr == 'a' && prev == 'z')){
    			//Is next
    			counter++;
    			current += curr;
    		}
    		else{
    			if(!set.contains(current)){
    				sum += (counter*(counter+1))/2;
    				set.add(current);
    			}
    			current = ""+curr;
    			counter = 1;
    		}
    		prev = curr;
    	}
    	if(!set.contains(current)){
			sum += (counter*(counter+1))/2;
		}
        return sum;
    }
    
}
