package java1;

public class Kraken {
	
	static int krakenCount(int m, int n){
		if(m == 0 || n == 0){
			return 0;
		}
		if(m == 1 || n == 1){
			return 1;
		}
		int[][] arr = new int[m][n];
		for(int i = 0; i < m; i++){
			arr[i][0] = 1;
		}
		for(int i = 0; i < n; i++){
			arr[0][i] = 1;
		}
		for(int i = 1; i < m; i++){
			for(int j = 1; j < n; j++){
				arr[i][j] = arr[i-1][j] + arr[i-1][j-1] + arr[i][j-1];
			}
		}
		return arr[m-1][n-1];
	}
	
	public static void main(String args[]){
		System.out.println(krakenCount(0, 0));
		System.out.println(krakenCount(1, 100));
		System.out.println(krakenCount(100, 1));
		System.out.println(krakenCount(10, 0));
		System.out.println(krakenCount(10, 10));
		System.out.println(krakenCount(3, 3));
		System.out.println(krakenCount(2, 2));
		System.out.println(krakenCount(4, 4));
		System.out.println(krakenCount(4, 2));
	}

}
