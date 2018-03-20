package java1;

import java.util.ArrayList;
import java.util.LinkedList;

public class Segment {
	
	public static void main(String args[]) {
//		int arr[] = {1, 2, 2, 5, 4, 6, 8, 1, 5};int size = 3;
//		int arr[] = {1, 2, 3, 1, 2};int size = 1;
//		int arr[] = {1, 1, 1};int size = 2;
		int arr[] = {2, 5, 4, 6, 8};int size = 3;
		minSlidingWindow(arr, size);
	}
	
	public static int minSlidingWindow(int arr[], int size){
		LinkedList<Integer> nums = new LinkedList<Integer>();
		LinkedList<Integer> indices = new LinkedList<Integer>();
		ArrayList<Integer> mins = new ArrayList<>();
		for(int i = 0; i < arr.length; i++){
			if(nums.size() == size){
				nums.removeFirst();
				indices.removeFirst();
			}
			// Now size is fine
			while(!nums.isEmpty() && nums.peekLast() > arr[i]){
				nums.removeLast();
				indices.removeLast();
			}
			// Is either empty or has smaller element before
			nums.addLast(arr[i]);
			indices.add(i);
			
			while(indices.peekFirst() <= i - size){
				nums.removeFirst();
				indices.removeFirst();
			}
			
			//The first num is the smallest in this window
			if(i >= size - 1){
				mins.add(nums.peekFirst());
			}
			
		}
		int max = Integer.MIN_VALUE;
		for(int i : mins){
			System.out.print(i);
			if(max < i){
				max = i;
			}
		}
		System.out.println();
		System.out.println(max);
		return max;
	}

}
