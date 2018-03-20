package java1;

import java.util.TreeSet;

public class S464 {

	public static void main(String[] args) {
		System.out.println(canIWin(10, 40));
		System.out.println(canIWin(10, 11));
	}
	
    public static boolean canIWin(int maxChoosableInteger, int desiredTotal) {
    	TreeSet<Integer> set = new TreeSet<Integer>();
    	for(int i = 1; i <= maxChoosableInteger; i++) {
    		set.add(i);
    	}
    	return canIWin(set, desiredTotal) != -1;
    }

	private static int canIWin(TreeSet<Integer> set, int desiredTotal) {
//		System.out.println(set + ":::" + desiredTotal);
		if(set.isEmpty()){
			return -1;
		}
		if(set.ceiling(desiredTotal) != null){
			return 1;
		}
		TreeSet<Integer> removedSet = new TreeSet<Integer>(set);
		for(int i:set){
			removedSet.remove(i);
			int opponentWin = canIWin(removedSet, desiredTotal-i);
			if(opponentWin == 1){
				return -1;
			}
			else if(opponentWin == -1){
				return 2;
			}
			removedSet.add(i);
		}
		return -1;
	}
}
