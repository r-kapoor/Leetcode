package java1;

import java.util.Arrays;
import java.util.Comparator;

public class S646 {

	public static void main(String[] args) {
		int[][] pairs = {{1, 2}, {1, 3}, {4, 5}, {3, 4}, {3, 5}, {6, 8}, {4, 8}};
		System.out.println(findLongestChain(pairs));
	}
	
	public static int findLongestChain(int[][] pairs) {
		if(pairs.length == 0){
			return 0;
		}
		if(pairs.length == 1){
			return 1;
		}
		Arrays.sort(pairs, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]){
					return Integer.compare(o1[1], o2[1]);
				}
				return Integer.compare(o1[0], o2[0]);
			}
		});;
		
		for(int i = 0; i < pairs.length; i++){
			System.out.println(pairs[i][0]+":"+pairs[i][1]);
		}
		
		int[] longestChainTillNow = new int[pairs.length];
		longestChainTillNow[0] = 1;
		for(int i = 1; i < pairs.length; i++){
			int max = 1;
			for(int j = 0; j < i; j++){
				if(pairs[j][1] < pairs[i][0]){
					//Can be extended
					int length = longestChainTillNow[j] + 1;
					if(max < length){
						max = length;
					}
				}
			}
			longestChainTillNow[i] = max;
		}
        return longestChainTillNow[pairs.length-1];
    }

}
