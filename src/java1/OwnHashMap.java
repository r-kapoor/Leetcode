package java1;

import java.util.LinkedList;

public class OwnHashMap<T> {
	
	class Node {
		String key;
		T value;
		public Node(String key, T value) {
			this.key = key;
			this.value = value;
		}
	}
	int size;
	LinkedList<Node>[] buckets;
	
	public OwnHashMap(int size) {
		this.size = size;
		buckets = new LinkedList[10];
	}

	public static void main(String[] args) {
		OwnHashMap<Integer> map = new OwnHashMap<Integer>(16);
		map.put("Hello", 10);
		map.put("Hi", 5);
		System.out.println(map.get("Hello"));
		map.put("Hello", 11);
		System.out.println(map.get("Hello"));
		System.out.println(map.get("Hi"));
		System.out.println(map.get("Hit"));
	}
	
	public void put(String key, T value) {
		int bucketNum = key.hashCode()%size;
		if(buckets[bucketNum] == null) {
			buckets[bucketNum] = new LinkedList<Node>();
		}
		for(Node node : buckets[bucketNum]) {
			if(node.key.equals(key)) {
				node.value = value;
				return;
			}
		}
		buckets[bucketNum].add(new Node(key, value));
	}
	
	public T get(String key) {
		int bucketNum = key.hashCode()%size;
		if(buckets[bucketNum] == null) {
			return null;
		}
		for(Node node : buckets[bucketNum]) {
			if(node.key.equals(key)) {
				return node.value;
			}
		}
		return null;
	}
	
	

}
