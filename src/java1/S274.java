package java1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class S274 {

	public static void main(String[] args) {
		int[] citations = {1, 1, 1, 1, 1, 1};
		System.out.println(hIndex(citations));
	}
	
	public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        for(int i = 0; i < citations.length; i++){
        	if(citations[i] >= (citations.length - i)){
        		return (citations.length - i);
        	}
        }
        return 0;
    }

}
