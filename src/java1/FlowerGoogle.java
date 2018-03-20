package java1;

import java.util.TreeMap;

public class FlowerGoogle {

	public static void main(String[] args) {
		int[] N = {3, 1, 5, 4, 2};
		int k = 2;
		System.out.println(function(N, k));
	}
	
	public static int function(int[] N, int k){
		TreeMap<Integer, Integer> indexSize = new TreeMap<Integer, Integer>();
		int max = -1;
		boolean sizeKCreated = false;
		for(int i = 0; i < N.length; i++){
			int flowerIndex = N[i];
			int size = 1;
			Integer lowerKey = indexSize.lowerKey(flowerIndex);
			if(indexSize.containsKey(flowerIndex+1)){
				//Need to merge
				int sizeBeingMerged = indexSize.get(flowerIndex+1);
				size += sizeBeingMerged;
				if(sizeBeingMerged == k){
					max = i;
				}
				indexSize.remove(flowerIndex+1);
			}
			if(lowerKey != null){
				int sizeOfLower = indexSize.get(lowerKey);
				if(lowerKey + sizeOfLower == flowerIndex){
					//Need to merge
					flowerIndex = lowerKey;
					size += sizeOfLower;
					if(sizeOfLower == k){
						max = i;
					}
				}
			}
			if(size == k){
				sizeKCreated = true;
			}
			indexSize.put(flowerIndex, size);
		}
		if(max == -1 && sizeKCreated){
			//Need to return last day
			return N.length;
		}
		return max;
	}

}
