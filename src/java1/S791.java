package java1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class S791 {

	public static void main(String[] args) {
		System.out.println(customSortString("cba", "abcd"));
	}
	
	public static String customSortString(String S, String T) {
		Character []TArray = new Character[T.length()];
		for(int i = 0; i < T.length(); i++) {
			TArray[i] = T.charAt(i);
		}
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i = 0; i < S.length(); i++) {
			map.put(S.charAt(i), i);
		}
		Arrays.sort(TArray, new Comparator<Character>() {

			@Override
			public int compare(Character o1, Character o2) {
				return Integer.compare(map.getOrDefault(o1, -1), map.getOrDefault(o2, -1));
			}
		});
		T = "";
		for(char c:TArray) {
			T += c;
		}
		return T;
		
		
    }

}
