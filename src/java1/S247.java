package java1;

import java.util.ArrayList;
import java.util.List;

public class S247 {

	public static void main(String[] args) {
		List<String> output = findStrobogrammatic(2);
		for(String out:output){
			System.out.println(out);
		}
	}
	
	public static List<String> findStrobogrammatic(int n) {
		String[] middle = {"0", "1", "8"};
		String[] any = {"0", "1", "6", "8", "9"};
		
		ArrayList<String> result = new ArrayList<String>();
		if(n == 0){
			return result;
		}
		if(n == 1){
			result.add("0");result.add("1");result.add("8");
			return result;
		}
		result.add("1");result.add("6");result.add("8");result.add("9");
		int genLen = n/2;
		for(int i = 1; i < genLen; i++){
			ArrayList<String> temp = new ArrayList<String>();
			for(String res : result){
				for(String digit:any){
					temp.add(res + digit);
				}
			}
			result.clear();
			result.addAll(temp);
		}
		if(n%2!=0){
			//Odd. Add middle digit
			ArrayList<String> temp = new ArrayList<String>();
			for(String res : result){
				for(String digit:middle){
					temp.add(res + digit);
				}
			}
			result.clear();
			result.addAll(temp);
		}
		ArrayList<String> temp = new ArrayList<String>();
		for(String res:result){
			temp.add(reverse(res, n));
		}
		result.clear();
		result.addAll(temp);
		return result;
    }

	private static String reverse(String res, int n) {
		StringBuffer s = new StringBuffer(res);
		for(int i = res.length() - n%2 - 1; i >= 0; i--){
			if(res.charAt(i) == '6'){
				s.append('9');
			}
			else if(res.charAt(i) == '9'){
				s.append('6');
			}
			else{
				s.append(res.charAt(i));
			}
		}
		return s.toString();
	}

}
