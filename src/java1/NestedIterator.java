package java1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class NestedIterator implements Iterator<Integer>{

	public static void main(String[] args) {
		List<NestedInteger> nestedList = new ArrayList<NestedInteger>();
		NestedIterator i = new NestedIterator(nestedList);
		while (i.hasNext()){
			System.out.println(i.next());
		}
	}
	
	List<NestedInteger> nestedList;
	Integer nextRet;
	Iterator<NestedInteger> iterator;
	NestedIterator internal;
    public NestedIterator(List<NestedInteger> nestedList) {
        this.nestedList = nestedList;
        this.iterator = nestedList.iterator();
    }

    @Override
    public Integer next() {
    	Integer retValue = nextRet;
    	nextRet = null;
    	return retValue;
    }

    @Override
    public boolean hasNext() {
    	if(nextRet != null){
    		return true;
    	}
    	if(internal!=null && internal.hasNext()){
    		nextRet = internal.next();
			return true;
    	}
    	internal = null;
    	while(iterator.hasNext()){
    		NestedInteger next = iterator.next();
    		if(next.isInteger()){
    			nextRet = next.getInteger();
    			return true;
    		}
    		List<NestedInteger> list = next.getList();
    		internal = new NestedIterator(list);
    		boolean internalNext = internal.hasNext();
    		if(internalNext){
                nextRet = internal.next();
    			return true;
    		}
    	}
    	return false;
    }
    
}

interface NestedInteger {
     // @return true if this NestedInteger holds a single integer, rather than a nested list.
     public boolean isInteger();

     // @return the single integer that this NestedInteger holds, if it holds a single integer
     // Return null if this NestedInteger holds a nested list
     public Integer getInteger();

     // @return the nested list that this NestedInteger holds, if it holds a nested list
     // Return null if this NestedInteger holds a single integer
     public List<NestedInteger> getList();
}
