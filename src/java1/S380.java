package java1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class S380 {
	
	ArrayList<Integer> list;
	HashMap<Integer, Integer> map;

	public static void main(String[] args) {
		S380 obj = new S380();
		System.out.println(obj.insert(10));
		System.out.println(obj.insert(11));
		System.out.println(obj.insert(12));
		System.out.println(obj.insert(10));
		System.out.println(obj.insert(13));
		System.out.println(obj.remove(10));
		System.out.println(obj.insert(14));
		System.out.println(obj.insert(15));
		System.out.println(obj.getRandom());
	}
	
	/** Initialize your data structure here. */
    public S380() {
        list = new ArrayList<Integer>();
        map = new HashMap<Integer, Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
    	if(map.containsKey(val)){
    		return false;
    	}
    	map.put(val, list.size());
		list.add(val);
    	return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
    	if(map.containsKey(val)){
    		int index = map.remove(val);
    		list.set(index, null);
    		return true;
    	}
    	return false;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
    	Random random = new Random();
    	int index = random.nextInt(list.size());
    	Integer val = list.get(index);
    	while(val == null){
    		index = random.nextInt(list.size());
        	val = list.get(index);
    	}
    	return val;
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */