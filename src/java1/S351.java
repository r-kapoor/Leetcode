package java1;

import java.util.ArrayList;
import java.util.HashSet;

public class S351 {
	
	static int counter = 0;

	public static void main(String[] args) {

	}
	
	public int numberOfPatterns(int m, int n) {
		int [][]reachable = {
				{0,1,0,1,1,1,0,1,0},
				{1,0,1,1,1,1,1,0,1},
				{0,1,0,1,1,1,0,1,0},
				{1,1,1,0,1,0,1,1,1},
				{1,1,1,1,0,1,1,1,1},
				{1,1,1,0,1,0,1,1,1},
				{0,1,0,1,1,1,0,1,0},
				{1,0,1,1,1,1,1,0,1},
				{0,1,0,1,1,1,0,1,0}
		};
		ArrayList<HashSet<Integer>> patterns = new ArrayList<HashSet<Integer>>();
		for(int i = 1; i <= 9; i++){
			HashSet<Integer> pattern = new HashSet<Integer>();
			pattern.add(i);
			patterns.add(pattern);
		}
		extendPatterns(patterns, m, n, 1);
		return counter;
    }

	private void extendPatterns(ArrayList<HashSet<Integer>> patterns, int m, int n, int size) {
		if(size >= m && size <= n){
			counter += patterns.size();
		}
		if(size == n){
			//Already of the size
			return;
		}
		for(HashSet<Integer> pattern : patterns){
			
		}
		
	}

}
