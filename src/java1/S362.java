package java1;

import java.util.LinkedList;
import java.util.Queue;

public class S362 {

	Queue<Integer> queue;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		S362 obj = new S362();
		System.out.println(obj.getHits(1));
		obj.hit(1);
		obj.hit(2);
		obj.hit(3);
		System.out.println(obj.getHits(4));
		obj.hit(300);
		System.out.println(obj.getHits(300));
		System.out.println(obj.getHits(301));
	}
	
	/** Initialize your data structure here. */
    public S362() {
    	queue = new LinkedList<Integer>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        removeOld(timestamp);
        queue.add(timestamp);
    }
    
    private void removeOld(int timestamp) {
    	while(!queue.isEmpty() && queue.peek() <= timestamp - 300){
    		queue.poll();
    	}
	}

	/** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
    	removeOld(timestamp);
		return queue.size();
    }
    
    
    

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */

}
