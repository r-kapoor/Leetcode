package java1;

import java.util.ArrayList;
import java.util.HashMap;

public class S294 {

	public static void main(String[] args) {
//		System.out.println(canWin(""));
//		System.out.println(canWin("++++"));
//		System.out.println(canWin("+++--+++"));
//		System.out.println(canWin("--+++++"));
//		System.out.println(canWin("+"));
//		System.out.println(canWin("++"));
//		System.out.println(canWin("+++"));
//		System.out.println(canWin("--+++++--++--++"));
		System.out.println(canWin("+++++++++"));
	}
	
	public static boolean canWin(String s) {
		ArrayList<Integer> pluses = getConsecutiveLengthsOfPlus(s);
		if(pluses.size() == 0){
			return false;
		}
		int countOfSteps = 0;
		HashMap<Integer, Integer> steps = new HashMap<Integer, Integer>();
		steps.put(0,  0);
		steps.put(1,  0);
		steps.put(2,  1);
		steps.put(3,  1);
		steps.put(4,  1);
		steps.put(5,  2);
		steps.put(6,  3);
		for(int numPlus:pluses){
			countOfSteps += getSteps(numPlus, steps);
		}
		if(countOfSteps%2 != 0){
			return true;
		}
		return false;
	}

	private static int getSteps(int numPlus, HashMap<Integer, Integer> steps) {
		if(steps.containsKey(numPlus)){
			return steps.get(numPlus);
		}
		for(int i = 0, j = numPlus-2; i <= j; i++, j--){
			System.out.println(i+":"+j);
			int iSteps = getSteps(i, steps);
			int jSteps = getSteps(j, steps);
			System.out.println(iSteps+"::"+jSteps);
			int total = iSteps + jSteps;
			if(total%2 == 0){
				return total+1;
			}
		}
		return 0;
	}

	private static ArrayList<Integer> getConsecutiveLengthsOfPlus(String s) {
		ArrayList<Integer> pluses = new ArrayList<Integer>();
		int count = 0;
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == '+'){
				count++;
			}
			else if(count > 0){
				pluses.add(count);
				count = 0;
			}
		}
		if(count > 0){
			pluses.add(count);
			count = 0;
		}
		return pluses;
	}

}
