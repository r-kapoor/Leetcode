package java1;

public class PureStorage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] elements = {-4, -2, 0, 1, 2, 3, 4, 5, 6, 6, 6, 7, 8};
		int[] elements = {-1, 6, 8};
		System.out.println(binarySearch(elements, 6));
	}
	
	public static int binarySearch(int[] elements, int target){
		if(elements == null || elements.length <= 0){
			return -1;
		}
		int left = 0; int right = elements.length - 1;
		while(left < right){
			int middle = (left + right + 1)/2;
			if(elements[middle] >  target){
				right = middle - 1;
			}
			else{
				left = middle + 1;
			}
		}
		
		if (elements[right] == target) return right;
		return -1;
	}

}
