package java1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class S56 {

	public static void main(String[] args) {
		ArrayList<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1, 3));
		intervals.add(new Interval(2, 6));
		intervals.add(new Interval(1, 8));
		intervals.add(new Interval(9, 12));
		intervals.add(new Interval(11, 15));
		List<Interval> merged = merge(intervals);
		for(Interval interval : merged){
			System.out.println(interval);
		}
	}
	
	public static List<Interval> merge(List<Interval> intervals) {
		ArrayList<Interval> merged = new ArrayList<Interval>();
		Comparator<Interval> c = new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				if(o1.start == o2.start){
					return Integer.compare(o1.end, o2.end);
				}
				return Integer.compare(o1.start, o2.start);
			}
			
		};
		intervals.sort(c);
		for(int i = 0; i < intervals.size(); i++){
			Interval curr = intervals.get(i);
			if(i+1 < intervals.size()){
				//Not the last
				Interval next = intervals.get(i+1);
				if(next.start > curr.end){
					merged.add(curr);
					continue;
				}
				int start = curr.start;
				int maxEnd = curr.end;
				while(next.start <= maxEnd){
					if(next.end > maxEnd){
						maxEnd = next.end;
					}
					i++;
					if(i+1 >= intervals.size()){
						break;
					}
					next = intervals.get(i+1);
				}
				Interval interval = new Interval(start, maxEnd);
				merged.add(interval);
			}
			else{
				merged.add(curr);
			}
		}
		return merged;
    }

}

class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
	
	@Override
	public String toString(){
		return start + ":" + end;
	}
}