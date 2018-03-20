package java1;

public class MaxXORSolution {
	
	public static int maxXOR(int left, int right, int k){
		int maxXor = 0;
		for(int i = left; i < right; i++){
			for(int j = i + 1; j < right; j++){
				int xor = i ^ j;
				System.out.println(i+"^"+j+"="+xor);
				if(maxXor < xor && xor < k){
					maxXor = xor;
				}
			}
		}
		System.out.println(maxXor);
		return maxXor;
	}

	public static void main(String[] args) {
		maxXOR(1, 20, 20);
	}

}
