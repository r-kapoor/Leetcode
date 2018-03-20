package java1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class S281 {
	
    ArrayList<List<Integer>> lists;
    ArrayList<Iterator<Integer>> iterators;
    int cur = -1;
    public S281(List<Integer> v1, List<Integer> v2) {
    	lists = new ArrayList<List<Integer>>();
    	iterators = new ArrayList<Iterator<Integer>>();
    	if(v1.size() > 0){
    		lists.add(v1);
    		iterators.add(v1.iterator());
    	}
        
        if(v2.size() > 0){
        	lists.add(v2);
        	iterators.add(v2.iterator());
        }
        if(iterators.size() > 0){
        	cur = 0;
        }
        
    }

    public int next() {
        int retVal = iterators.get(cur).next();
        if(!iterators.get(cur).hasNext()){
        	iterators.remove(cur);
        	if(iterators.size() == 0){
        		cur = -1;
        		return retVal;
        	}
        }
        cur++;
        if(cur >= iterators.size()){
        	cur = 0;
        }
        return retVal;
    }

    public boolean hasNext() {
//    	System.out.println("Size:"+iterators.size()+" "+cur);
        return cur != -1 && iterators.get(cur).hasNext();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> v1 = new ArrayList<Integer>();
		List<Integer> v2 = new ArrayList<Integer>();
		v1.add(1);v1.add(2);
		v2.add(3);//v2.add(4);v2.add(5);v2.add(6);
		S281 i = new S281(v1, v2);
		while (i.hasNext()) System.out.println(i.next());
	}

}
