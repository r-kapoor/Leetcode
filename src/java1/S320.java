package java1;

import java.util.ArrayList;
import java.util.List;

public class S320 {

	public static void main(String[] args) {
		List<String> list = generateAbbreviations("word");
		for(String s:list){
			System.out.println(s);
		}
	}
	
	public static List<String> generateAbbreviations(String word) {
		List<String> result = new ArrayList<String>();
		if(word.length() == 0){
			result.add("");
			return result;
		}
		if(word.length() == 1){
			result.add(word.length()+"");
			result.add(word);
			return result;
		}
//		for(int i = 1; i < word.length(); i++){
//			result.add(i+word.substring(i));
//		}
		List<String> subResult = generateAbbreviations(word.substring(1));
		for(String s:subResult){
//			System.out.println("W:"+word);
//			System.out.println("S:"+s);
			if(Character.isDigit(s.charAt(0))){
				int posWord = 1;
				while(posWord < s.length() && Character.isDigit(s.charAt(posWord))){
					posWord++;
				}
				String newS = ""+(1+Integer.parseInt(s.substring(0, posWord)));
				if(posWord < s.length()){
					newS += s.substring(posWord);
				}
//				System.out.println("NewS:"+newS);
				result.add(newS);
			}
			else{				
				result.add("1"+s);
			}
			result.add(word.charAt(0)+s);
		}
		return result;
    }

}

//"1o1d", "1or1", "w1r1", "1o2", "2r1",
