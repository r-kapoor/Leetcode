package java1;

import java.util.HashMap;

public class S474 {

	public static void main(String[] args) {
//		String[] strs = {"10", "0001", "111001", "1", "0"};
		String[] strs = {"10", "0", "1"};
		System.out.println(findMaxForm(strs, 1, 1));
	}
	
	public static int findMaxForm(String[] strs, int m, int n) {
		HashMap<String, Integer> countToIndex = new HashMap<String, Integer>();
		int[] zeros = new int[strs.length];
		int[] ones = new int[strs.length];
		int[] counts = new int[strs.length];
		for(int i = 0; i < strs.length; i++){
			for(int j = 0; j < strs[i].length(); j++){
				if(strs[i].charAt(j) == '0'){
					zeros[i]++;
				}
				else{
					ones[i]++;
				}
			}
			String count = zeros[i]+":"+ones[i];
			if(countToIndex.containsKey(count)){
				counts[countToIndex.get(count)]++;
				counts[i] = -1;
			}
			else{
				countToIndex.put(count, i);
				counts[i] = 1;
			}
		}
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		return maxTill(map, zeros, ones, counts, m, n, strs.length-1);
	}
	
	public static int maxTill(HashMap<String, Integer> map, int[] zeros, int[] ones, int[] counts, int m, int n, int index){
		String input = m+":"+n+":"+index;
		if(map.containsKey(input)){
			return map.get(input);
		}
//		System.out.println(index+" with "+m+":"+n);
		if(index < 0){
			return 0;
		}
		if(counts[index] == -1){
			return maxTill(map, zeros, ones, counts, m, n , index-1);
		}
		int taken = 0;
		if(zeros[index] <= m && ones[index] <= n){
			// Can be taken
			int zerosLimit = (zeros[index]>0?m/zeros[index]:counts[index]);
			int onesLimit = (ones[index]>0?n/ones[index]:counts[index]);
			int numToTake = Math.min(zerosLimit, Math.min(onesLimit, counts[index]));
			taken = numToTake + maxTill(map, zeros, ones, counts, m-numToTake*zeros[index], n-numToTake*ones[index], index-1);
		}
		int notTaken = maxTill(map, zeros, ones, counts, m, n, index-1);
//		System.out.println(index+"-"+taken+"--"+notTaken);
		int maxValue = Math.max(taken, notTaken);
		map.put(input, maxValue);
		return maxValue;
	}

}
