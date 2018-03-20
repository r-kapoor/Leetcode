package java1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class NextClosestTime {
	
	public static void main(String args[]){
		System.out.println(nextClosestTime("11:00"));
		System.out.println(nextClosestTime("19:34"));
		System.out.println(nextClosestTime("23:59"));
		System.out.println(nextClosestTime("10:01"));
	}
	
	public static String nextClosestTime(String time) {
        ArrayList<String> allPossibles = new ArrayList<String>();
        HashSet<Character> digits = extractDistinctCharacters(time);
        allPossibles.add("");
        allPossibles = generateAllTimes(digits, allPossibles);
        Collections.sort(allPossibles);
        int index = allPossibles.indexOf(time);
        index++;
        if(index == allPossibles.size()){
            index = 0;
        }
        return allPossibles.get(index);
    }
    
    public static ArrayList<String> generateAllTimes(HashSet<Character> digits, ArrayList<String> current){
        ArrayList<String> allPossibles = new ArrayList<String>();
        boolean complete = false;
        for(String s:current){
            if(s.length() == 0){
                //Need to add 1st digit
                //Only 0, 1, 2 possible
                for(char c:digits){
                    if(c == '0' || c == '1' || c == '2'){
                        allPossibles.add(c+"");
                    }
                }
            }
            else if(s.length() == 1){
                if(s.charAt(0) == '2'){
                    //Can only add 0-3
                	for(char c:digits){
                		if(c >= '0' && c <= '3'){
                            allPossibles.add(s + c + ":");
                        }
                    }
                }
                else{
                	for(char c:digits){
                        allPossibles.add(s + c + ":");
                    }
                }
            }
            else if(s.length() == 3){
                //Can only add 0-5
            	for(char c:digits){
            		if(c >= '0' && c <= '5'){
                        allPossibles.add(s + c);
                    }
                }
                
            }
            else if(s.length() == 4){
            	for(char c:digits){
            		allPossibles.add(s + c);
                }
                
                complete = true;
            }
        }
        if(complete){
            return allPossibles;
        }
        return generateAllTimes(digits, allPossibles);
    }
    
    public static HashSet<Character> extractDistinctCharacters(String time){
        HashSet<Character> digits = new HashSet<Character>();
        digits.add(time.charAt(0));
        digits.add(time.charAt(1));
        digits.add(time.charAt(3));
        digits.add(time.charAt(4));
        return digits;
    }

}
