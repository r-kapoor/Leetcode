package java1;

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 
 Question:
Given two strings, one smaller string (needle) and one bigger string (haystack), find all permutations of the needle string within the haystack.

For example:
(needle, haystack) => output
('abc', 'abc') => ['abc']
('abc', 'cab') => ['cab']
('abc', 'cabbac') => ['cab', 'bac']
('abcd', 'cab') => []
('sis', 'mississippi') => ['iss', 'ssi', 'sis', 'iss', 'ssi']
('sis', 'missoissippi') => ['iss', 'iss', 'ssi']
 
 */

class SumoLogic {
  public static void main(String[] args) {
    ArrayList<String> strings = new ArrayList<String>();
    strings.add("Hello, World!");
    strings.add("Welcome to CoderPad.");
    strings.add("This pad is running Java 8.");

    for (String string : strings) {
      System.out.println(string);
    }
    
    ArrayList<String> result = findInHaystack("abc", "cabbac");
    for(String s:result){
      System.out.println(s);
    }
  }
  
  public static ArrayList<String> findInHaystack(String needle, String haystack){
    
    ArrayList<String> result = new ArrayList<String>();
    if(needle.length() > haystack.length()){
      return result;
    }
    HashMap<Character, Integer> charToCount = new HashMap<Character, Integer>();
    HashMap<Character, Integer> windowMap = new HashMap<Character, Integer>();
    int nLength = needle.length();
    int hLength = haystack.length();
    
    //Adding in hashmap
    for(int i = 0; i < nLength; i++){
      if(charToCount.containsKey(needle.charAt(i))){
        charToCount.put(needle.charAt(i), charToCount.get(needle.charAt(i))+1);
      }
         else{
           charToCount.put(needle.charAt(i), 1);
         }
    }
    
    
    
         
    for(int i = 0; i < nLength ; i++){
      if(windowMap.containsKey(haystack.charAt(i))){
        windowMap.put(haystack.charAt(i), windowMap.get(haystack.charAt(i))+1);
      }
         else{
           windowMap.put(haystack.charAt(i), 1);
         }
    }
    
    if(isMatch(windowMap, charToCount)){
        result.add(haystack.substring(0, nLength));
      }
         
    for(int i = nLength; i < hLength; i++){
      char lastChar = haystack.charAt(i);
      char firstChar = haystack.charAt(i - nLength);
      if(windowMap.containsKey(lastChar)){
           windowMap.put(lastChar, windowMap.get(lastChar) + 1);
      }
      else{
        windowMap.put(lastChar, 1);
      }
      windowMap.put(firstChar, windowMap.get(firstChar) - 1); 
      if(isMatch(windowMap, charToCount)){
        result.add(haystack.substring(i-nLength+1, i+1));
      }
      
    }
                   
    return result;
  }
         
  public static boolean isMatch(HashMap<Character, Integer> map1, HashMap<Character, Integer> map2){
//    System.out.println("-");
    for(char c:map1.keySet()){
      int count = map1.get(c);
//      System.out.println(c + " " + count + " " + map2.get(c));
      if(count == 0){
    	  continue;
      }
      if(!map2.containsKey(c)){
        return false;
      }
      if(count != map2.get(c)){
        return false;
      }
    }
    return true;
  }
}

