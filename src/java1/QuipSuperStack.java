package java1;

import java.util.ArrayList;
import java.util.LinkedList;

public class QuipSuperStack {
	
	LinkedList<Integer> stack = new LinkedList<Integer>();
	ArrayList<ValueElement> incValue = new ArrayList<ValueElement>();

	public static void main(String[] args) {
		QuipSuperStack superStack = new QuipSuperStack();
		superStack.push(5);
		superStack.print();
		superStack.pop();
		superStack.print();
		superStack.push(3);
		superStack.push(4);
		superStack.push(5);
		superStack.print();
		superStack.increment(3, 1);
		superStack.print();
		System.out.println("pop:"+superStack.pop());
		superStack.push(9);
		superStack.print();
		System.out.println("pop:"+superStack.pop());
		superStack.push(10);
		superStack.push(11);
		superStack.increment(3, 5);
		superStack.print();
		System.out.println("pop:"+superStack.pop());
		superStack.print();
		System.out.println("pop:"+superStack.pop());
		superStack.print();
		System.out.println("pop:"+superStack.pop());
		superStack.print();
		System.out.println("pop:"+superStack.pop());
	}
	
	public void print(){
		for(int i:stack){
			System.out.print(i+" ");
		}
		System.out.println();
		for(ValueElement i:incValue){
			System.out.print(i.elements+":"+i.value+",");
		}
		if(incValue.size()>0){
			System.out.println();
		}
		
	}
	
	public void push(Integer num){
		stack.push(num);
	}
	
	public int pop(){
		if(incValue.size() == 0){
			return stack.pop();
		}
		ValueElement increaseValue = incValue.get(incValue.size()-1);
		if(increaseValue.elements < stack.size()-1){
			return stack.pop();
		}
		int popped = stack.pop() + increaseValue.value;
		increaseValue.elements--;
		if(increaseValue.elements == -1){
			incValue.remove(increaseValue);
		}
		else if(incValue.size() > 1){
			ValueElement elementBefore = incValue.get(incValue.size()-2);
			if(elementBefore.elements == increaseValue.elements){
				elementBefore.value += increaseValue.value;
				incValue.remove(incValue.size()-1);
			}
		}
		return popped;
	}
	
	public void increment(int e, int k){
		//Add k to e elements
		e = Math.min(stack.size()-1, e-1);
		if(incValue.size() == 0){
			incValue.add(new ValueElement(e, k));
		}
		else{
			int index = 0;
			boolean change = false;
			for(ValueElement valueElement:incValue){
				if(valueElement.elements == e){
					valueElement.value += k;
					change = true;
				}
				if(valueElement.elements > e){
					break;
				}
				index++;
			}
			if(!change){
				incValue.add(index, new ValueElement(e, k));
			}
		}
	}
}

class ValueElement{
	int elements;
	int value;
	public ValueElement(int elements, int value){
		this.elements = elements;
		this.value = value;
	}
}