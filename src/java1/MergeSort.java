package java1;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = {3, 5, 2, 9, 1, 10, 7, 5, 2};
		mergeSort(arr, 0, arr.length-1);
		for(int i : arr) {
			System.out.println(i);
		}
	}
	
	public static void mergeSort(int[] arr, int begin, int end) {
		if(begin >= end) {
			return;
		}
		if(end == begin +1) {
			if(arr[begin] > arr[end]) {
				//Swap
				int temp = arr[begin];
				arr[begin] = arr[end];
				arr[end] = temp;
			}
			return;
		}
		int mid = (begin+end)/2;
		mergeSort(arr, begin, mid);
		mergeSort(arr, mid+1, end);
		//Merge
		int temp[] = new int[end-begin+1];
		int index = 0, left = begin, right = mid+1;
		while(left <= mid && right <= end) {
			if(arr[left] < arr[right]) {
				temp[index] = arr[left];
				index++;
				left++;
			}
			else {
				temp[index] = arr[right];
				index++;
				right++;
			}
		}
		while(left <= mid) {
			temp[index] = arr[left];
			index++;
			left++;
		}
		while(right <= end) {
			temp[index] = arr[right];
			index++;
			right++;
		}
		for(int i = 0; i < temp.length; i++) {
			arr[begin+i] = temp[i];
		}
	}

}
