package java1;

import java.util.ArrayList;
import java.util.Collections;

public class QuipMagicStrings {

	public static void main(String[] args) {
		System.out.println(magicalStringO("11011000"));
	}
	
	public static String magicalStringO(String s){
		if(s.length() == 0){
			return s;
		}
		if(s.length() == 2 || s.length() == 4){
			return s;
		}
		ArrayList<String> magicalSubStrings = new ArrayList<String>();
		int begin = 0;
		int count0 = 0;
		int count1 = 0;
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == '0'){
				count0++;
			}
			else{
				count1++;
			}
			if(count0 > count1){
				//Not a magical string
				break;
			}
			if(count0 == count1){
				String smallMagical = "1" + magicalStringO(s.substring(begin+1, i)) + "0";
				magicalSubStrings.add(smallMagical);
				begin = i+1;
			}
		}
		Collections.sort(magicalSubStrings, Collections.reverseOrder());
        return String.join("", magicalSubStrings);
	}

	public static String magicalString(String s){
		System.out.println("Input:"+s);
		if(s.length() == 0){
			return s;
		}
		if(s.length() == 2 || s.length() == 4){
			return s;
		}
		String maxMagical = s;
		for(int i = 0; i < s.length(); i++){
			int count0 = 0;
			int count1 = 0;
			//Search for magical string starting at i
			for(int j = i; j < s.length(); j++){
				if(s.charAt(j) == '0'){
					count0++;
				}
				else{
					count1++;
				}
				if(count0 > count1){
					//Not a magical string
					break;
				}
				if(count0 == count1){
					System.out.println("Magical:"+i+":"+j);
					//Is a magical string from i to j
					//Search for magical string from j+1
					int internal0 = 0;
					int internal1 = 0;
					for(int k = j+1; k < s.length(); k++){
						if(s.charAt(k) == '0'){
							internal0++;
						}
						else{
							internal1++;
						}
						if(internal0 > internal1){
							//Not a magical string
							break;
						}
						if(internal0 == internal1){
							System.out.println("InternMagical:"+(j+1)+":"+k);
							//A magical string from j+1 to k
							String afterSwap = s.substring(0, i) + 
									s.substring(j+1, k+1) + s.substring(i, j+1)
									+ s.substring(k+1);
							if(isBigger(afterSwap, s)){
								//New string bigger
								String maxAfterSwap = magicalString(afterSwap);
								if(isBigger(maxAfterSwap, maxMagical)){
									maxMagical = maxAfterSwap;
								}
							}
						}
					}
				}
			}
		}
		
		return maxMagical;
	}
	
	/**
	 * Bigger of 2 same length strings
	 * @param s1
	 * @param s2
	 * @return true if s1 > s2
	 */
	public static boolean isBigger(String s1, String s2){
		for(int i = 0; i < Math.min(s1.length(), s2.length()); i++){
			if(s1.charAt(i) > s2.charAt(i)){
				return true;
			}
			else if(s1.charAt(i) < s2.charAt(i)){
				return false;
			}
		}
		return false;
	}
}
