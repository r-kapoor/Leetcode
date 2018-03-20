package java1;

import java.util.HashMap;
import java.util.HashSet;

public class MinVacations {
	public static void main(String args[]) {
		System.out.println(minWindow(new int[]{7,3,7,3,1,3,4,1}));
		System.out.println(minWindow(new int[]{4,1,1,2,3,1,2,3,4}));
	}
	
	public static int minWindow(int[] arr) {
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<arr.length;i++) map.put(arr[i],map.getOrDefault(arr[i], 0)+1);
		HashMap<Integer,Integer> tempMap = new HashMap<Integer,Integer>();
		tempMap = (HashMap<Integer, Integer>) map.clone();
		int minLen = Integer.MAX_VALUE;
		
	    int minIdx =0;
		int i=-1,j=0;
		int count = map.size();
	    while (i < arr.length-1 && j < arr.length-1)
        {
            if (count>0)
            {
                i++;
                tempMap.put(arr[i], map.get(arr[i])-1);
                if (tempMap.get(arr[i])-1 >= 0)
                {
                    count--;
                    
                }
            }
            else {
            	if (minLen > i - j + 1)
                {
                    minLen = i - j + 1;
                    minIdx = j;
                }
            	tempMap.put(arr[i], map.get(arr[i])+1);
                if (  map.get(arr[i])+1> 0)
                {
                    count++;
                }
                j++;
                
            }
            
           
        }
        if (minLen == Integer.MAX_VALUE)
        {
            return -1;
        }
        return minLen;
    }
	
}
