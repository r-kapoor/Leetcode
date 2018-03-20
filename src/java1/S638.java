package java1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class S638 {

	public static void main(String[] args) {
		ArrayList<Integer> price = new ArrayList<Integer>() {{
			add(0);
			add(0);
			add(0);
		}};
		ArrayList<Integer> needs = new ArrayList<Integer>() {{
			add(1);
			add(1);
			add(1);
		}};
		List<List<Integer>> special = new ArrayList<List<Integer>>() {{
			add(new ArrayList<Integer>() {{
				add(1);
				add(1);
				add(0);
				add(4);
			}});
			add(new ArrayList<Integer>() {{
				add(2);
				add(2);
				add(1);
				add(9);
			}});
		}};
		System.out.println(shoppingOffers(price, special, needs));
	}
	
    public static int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
    	int numItems = needs.size();
    	int[] itemNeeds = new int[numItems];
    	int[] prices = new int[numItems];
    	int index = 0;
    	for(int need : needs){
    		itemNeeds[index] = need;
    		index++;
    	}
    	index = 0;
    	for(int itemPrice : price){
    		prices[index] = itemPrice;
    		index++;
    	}
    	eliminateBadOffers(special, prices);
    	HashMap<String, Integer> itemSetPrice = new HashMap<String, Integer>();
    	return shoppingOffers(itemNeeds, special, itemSetPrice, prices);
    }
    
    private static void eliminateBadOffers(List<List<Integer>> special, int[] prices) {
    	Stack<Integer> removeOffers = new Stack<Integer>();
    	int index = 0;
    	for(List<Integer> specialOffer: special){
    		int valueOfIndividual = 0;
    		for(int i = 0; i < specialOffer.size()-1; i++){
    			valueOfIndividual += specialOffer.get(i) * prices[i];
    		}
    		if(valueOfIndividual < specialOffer.get(specialOffer.size()-1)){
    			removeOffers.add(index);
    		}
    		index++;
		}
    	while(!removeOffers.isEmpty()){
    		special.remove((int)removeOffers.pop());
    	}
	}

	public static int shoppingOffers(int[] itemNeeds, List<List<Integer>> special, HashMap<String, Integer> itemSetPrice, int[] prices){
    	boolean isNonZero = false;
    	String itemSet = "";
    	for(int i = 0; i < itemNeeds.length; i++){
    		if(itemNeeds[i] > 0){
    			isNonZero = true;
    		}
    		itemSet += itemNeeds[i] + ":";
    	}
//    	System.out.println("Calls::"+itemSet);
    	if(!isNonZero){
    		return 0;
    	}
    	if(itemSetPrice.containsKey(itemSet)){
    		return itemSetPrice.get(itemSet);
    	}
    	//Try to apply any special offers
    	int min = Integer.MAX_VALUE;
    	Outer:
    	for(List<Integer> specialOffer: special){
    		int[] nextNeeds = new int[itemNeeds.length];
    		for(int i = 0; i < specialOffer.size()-1; i++){
    			nextNeeds[i] = itemNeeds[i] - specialOffer.get(i);
    			if(nextNeeds[i] < 0){
    				continue Outer;
    			}
    		}
    		int valueWithOffer = shoppingOffers(nextNeeds, special, itemSetPrice, prices) + specialOffer.get(specialOffer.size()-1);
    		if(min > valueWithOffer){
    			min = valueWithOffer;
    		}
		}
    	if(min == Integer.MAX_VALUE){
    		//Apply single value items
        	for(int i = 0; i < itemNeeds.length; i++){
        		if(itemNeeds[i] > 0){
        			itemNeeds[i] -= 1;
        		}
        		else{
        			continue;
        		}
        		int valueWithSingleItem = shoppingOffers(itemNeeds, special, itemSetPrice, prices) + prices[i];
        		if(min > valueWithSingleItem){
        			min = valueWithSingleItem;
        		}
        		itemNeeds[i] += 1;
        	}
    	}
//    	System.out.println(itemSet + "--"+min);
    	itemSetPrice.put(itemSet, min);
    	return min;
    }

}
