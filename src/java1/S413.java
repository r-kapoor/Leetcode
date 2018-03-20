package java1;

public class S413 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {0, 2, 3, 4, 6, 8, 10};
		System.out.println(numberOfArithmeticSlices(A));
	}
	
	public static int numberOfArithmeticSlices(int[] A) {
		int length = 2;
		int sum = 0;
		for(int i = 1; i < A.length-1; i++){
			if(A[i] - A[i-1] == A[i+1] - A[i]){
				length++;
			}
			else{
				sum += countFromLength(length);
				length = 2;
			}
		}
		sum += countFromLength(length);
		return sum;
    }
	public static int countFromLength(int length){
		return ((length-1)*(length-2))/2;
	}

}
