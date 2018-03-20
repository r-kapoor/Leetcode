package java1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class S409 {

	public static void main(String[] args) {
		int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
		int [][]result = reconstructQueue(people);
		for(int i = 0; i < result.length; i++){
			System.out.print(result[i][0]+","+result[i][1]+" ");
		}
		System.out.println();
	}

	public static int[][] reconstructQueue(int[][] people) {
        ArrayList<Pairs> pairs = new ArrayList<Pairs>();
        LinkedList<Pairs> pairActual = new LinkedList<Pairs>();
        int[][] result = new int[people.length][2];
        for(int[] person : people){
        	pairs.add(new Pairs(person[0], person[1]));
        }
        Collections.sort(pairs);
        for(Pairs pair:pairs){
//        	System.out.println(pair);
        	pairActual.add(pair.k, pair);
        }
        int i = 0;
        for(Pairs pair:pairActual){
//        	System.out.println(pair);
        	result[i][0] = pair.h;
        	result[i][1] = pair.k;
        	i++;
        }
		return result;
    }

}

class Pairs implements Comparable<Pairs>{
	public int h;
	public int k;
	public Pairs(int h, int k){
		this.h = h;
		this.k = k;
	}
	 
	@Override
	public int compareTo(Pairs o) {
		int compared = -Integer.compare(this.h, o.h);
		if(compared == 0){
			return Integer.compare(this.k, o.k);
		}
		return compared;
	}
	
	public String toString(){
		return h+" "+k;
	}
 }
