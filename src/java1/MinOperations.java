package java1;

public class MinOperations {
	
	public static int minOperationsForN(int n){
		int[] arr = new int[(n>3)?n+1:4];
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 3;
		for(int i = 4; i <= n; i++){
			int op1 = arr[i-1] + 1;
			if(i%2 == 0){
				if(arr[i/2] < arr[i-1]){
					op1 = arr[i/2] + 1;
				}
			}
			arr[i] = op1;
		}
		return arr[n];
	}
	public static void main(String args[]){
		System.out.println(minOperationsForN(1));
		System.out.println(minOperationsForN(2));
		System.out.println(minOperationsForN(3));
		System.out.println(minOperationsForN(4));
		System.out.println(minOperationsForN(5));
		System.out.println(minOperationsForN(6));
		System.out.println(minOperationsForN(10));
	}

}
