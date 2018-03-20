package java1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class S253 {

	public static void main(String[] args) {
//		Interval i1 = new Interval(0, 30);
//		Interval i2 = new Interval(5, 10);
//		Interval i3 = new Interval(15, 20);
//		Interval i4 = new Interval(8, 20);
		Interval i1 = new Interval(1, 13);
		Interval i2 = new Interval(13, 15);
		Interval[] intervals = {i1, i2};
		System.out.println(minMeetingRooms(intervals));
	}
	
	public static int minMeetingRooms(Interval[] intervals) {
		
		int count = 0;
		Arrays.sort(intervals, new Comparator<Interval>(){

			@Override
			public int compare(Interval o1, Interval o2) {
				return Integer.compare(o1.start, o2.start);
			}
			
		});
		
		PriorityQueue<Integer> endTimes = new PriorityQueue<Integer>();
		for(int i = 0; i < intervals.length; i++){
			if(endTimes.size() > 0){
				int lowestEndTime = endTimes.peek();
				while(lowestEndTime <=
						intervals[i].start){
					endTimes.poll();
					if(endTimes.isEmpty()){
						break;
					}
					lowestEndTime = endTimes.peek();
				}
			}
			endTimes.add(intervals[i].end);
			if(count < endTimes.size()){
				count = endTimes.size();
			}
		}
		if(count < endTimes.size()){
			count = endTimes.size();
		}
		return count;
    }

}
