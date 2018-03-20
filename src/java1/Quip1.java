package java1;

import java.util.TreeMap;

public class Quip1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] elements = {1, 2, 1, 3, 2, 3};
		System.out.println(maxPoints(elements));
		System.out.println(deleteAndEarn(elements));
	}
	
	static long maxPoints(int[] elements) {
        TreeMap<Integer, Integer> countsOfElements = new TreeMap<Integer, Integer>();
        for(int element:elements){
        	if(countsOfElements.containsKey(element)){
        		countsOfElements.put(element, countsOfElements.get(element) + 1);
        	}
        	else{
        		countsOfElements.put(element, 1);
        	}
        }
        long withoutUsing = 0;
        long withUsing = 0;
        for(int element:countsOfElements.keySet()){
        	long max = Long.max(withUsing, withoutUsing);
        	if(!countsOfElements.containsKey(element-1)){
        		withUsing = element * countsOfElements.get(element) + max;
        	}
        	else{
        		withUsing = element * countsOfElements.get(element) + withoutUsing;
        	}
    		withoutUsing = max;
        }
        return Long.max(withoutUsing, withUsing);
    }
	
	public static int deleteAndEarn(int[] nums) {
        int[] count = new int[10001];
        for (int x: nums) count[x]++;
        int avoid = 0, using = 0, prev = -1;

        for (int k = 0; k <= 10000; ++k) if (count[k] > 0) {
            int m = Math.max(avoid, using);
            if (k - 1 != prev) {
                using = k * count[k] + m;
                avoid = m;
            } else {
                using = k * count[k] + avoid;
                avoid = m;
            }
            prev = k;
        }
        return Math.max(avoid, using);
    }

}
