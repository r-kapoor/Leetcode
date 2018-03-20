package java1;

import java.util.ArrayList;
import java.util.Iterator;

public class S284 implements Iterator<Integer> {
	
	Integer curr;
	Iterator<Integer> iterator;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		Iterator<Integer> i = list.iterator();
		S284 j = new S284(i);
		System.out.println(j.peek());
		System.out.println(j.next());
		System.out.println(j.peek());
		System.out.println(j.hasNext());
		System.out.println(j.peek());
		System.out.println(j.next());
	}

	public S284(Iterator<Integer> iterator) {
	    // initialize any member here.
	    curr = null;
	    this.iterator = iterator;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		if(curr != null){
			return curr;
		}
        curr = iterator.next();
        return curr;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if(curr != null){
	    	Integer temp = curr;
	    	curr = null;
	    	return temp;
	    }
	    return iterator.next();
	}

	@Override
	public boolean hasNext() {
	    if(curr != null){
	    	return true;
	    }
	    return iterator.hasNext();
	}
}
