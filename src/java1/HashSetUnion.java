package java1;

import java.util.HashSet;

public class HashSetUnion {
	public static void main(String args[]) {
		HashSet<Integer> set1 = new HashSet<Integer>();
		set1.add(1);
		set1.add(2);
		HashSet<Integer> set2 = new HashSet<Integer>(set1);
		set1.add(1);
		set1.addAll(set2);
		for(int i:set1) {
			System.out.println(i);
		}
	}
}
