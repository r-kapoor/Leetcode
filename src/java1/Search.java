package java1;

public class Search {
	
	public static void main(String args[]){
		int []elements = {-2, 0, 3, 4, 6};
		int target = 3;
		System.out.println(sorted_search(elements, target));
	}
	
	static int sorted_search(int elements[], int target){
		if(elements == null || elements.length <= 0){
			return -1;
		}
		int left = 0, right = elements.length - 1;
		while(left < right){
			int middle = (left + right + 1)/2;
			if(elements[middle] > target){
				right  = middle - 1;
			}
			else{
				left = middle + 1;
			}
		}
		if (elements[right] == target){
			return right;
		}
		return -1;
	}

}
