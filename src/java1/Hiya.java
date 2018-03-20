package java1;

import javax.swing.text.html.MinimalHTMLWriter;

public class Hiya {
	
	public static int minimumGroups(int[] predators){
		int[] foodChainLength = new int[predators.length];
		int max = 0;
		for(int i = 0; i < foodChainLength.length; i++){
			if(foodChainLength[i] == 0){
				//Not yet filled
				foodChainLength[i] = foodChain(foodChainLength, predators, i);
				if(max < foodChainLength[i]){
					max = foodChainLength[i];
				}
			}
		}
		return max;
	}
	
	public static int foodChain(int[] foodChainLength, int[]predators, int i){
		if (foodChainLength[i] != 0){
			return foodChainLength[i];
		}
		else{
			int eats = predators[i];
			if(eats == -1){
				//Nobody eats this
				return 1;
			}
			else{
				return 1+foodChain(foodChainLength, predators, predators[i]);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] a = {1, -1, 3, -1};
		int[] a = {-1, 0, 1};
		System.out.println(minimumGroups(a));

	}

}
