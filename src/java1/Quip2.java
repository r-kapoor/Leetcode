package java1;

public class Quip2 {

	public static void main(String[] args) {
		System.out.println(consecutive(15));
		System.out.println(countConsecutive2(15));
	}
	
	static int consecutive(long num) {
		int count = 0;
		long numberOfConsecutiveInts = 2;
		while(numberOfConsecutiveInts*(numberOfConsecutiveInts-1)/2 < num){
			if(numberOfConsecutiveInts%2 == 0){
				//Even number of consecutive digits
				if(num == (num/numberOfConsecutiveInts)*numberOfConsecutiveInts + numberOfConsecutiveInts/2){
					count++;
				}
			}
			else{
				//Odd number of consecutive digits
				if(num == num/numberOfConsecutiveInts*numberOfConsecutiveInts){
					count++;
				}
			}
			numberOfConsecutiveInts++;
		}
		return count;
	}
	
	static int countConsecutive2(long num){

		long sumOfFirstIntegers = 3;
		int count = 0;
		for(long i = 2 ; sumOfFirstIntegers<=num; ++i){
			if((i%2==0)?(num%i==i/2): (num%i==0)){
				++count;
			}
			sumOfFirstIntegers+=i+1;
		}
		return count;
	}

}
