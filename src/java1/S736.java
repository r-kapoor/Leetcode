package java1;

import java.util.HashMap;

public class S736 {

	public static void main(String[] args) {
//		System.out.println(evaluate("(mult (add 1 2) 2)"));
//		System.out.println(evaluate("(mult (add 1 2) (mult 2 3))"));
//		System.out.println(evaluate("(let x 2 x)"));
//		System.out.println(evaluate("(let x 2 x 3 x)"));
//		System.out.println(evaluate("(let x 2 y 3 (add x y))"));
//		System.out.println(evaluate("(let x 2 y x (add x y))"));
//		System.out.println(evaluate("(let x 2 y (add 2 3) (add x y))"));
//		System.out.println(evaluate("(let x 2 y (let x 3 (add x 2)) (add x y))"));
//		System.out.println(evaluate("(let a1 3 b2 (add a1 1) b2)"));
//		System.out.println(evaluate("(let x 2 (add (let x 3 (let x 4 x)) x))"));
//		System.out.println(evaluate("(let x 1 y 2 x (add x y) (add x y))"));
//		System.out.println(evaluate("(let x 3 x 2 x)"));
		System.out.println(evaluate("(let x 2 (mult x (let x 3 y 4 (add x y))))"));
	}
	
	public static int evaluate(String expression) {
        HashMap<String, Integer> variables = new HashMap<String, Integer>();
        return evaluate(expression, variables);
    }
    
    public static int evaluate(String expression, HashMap<String, Integer> variables){
    	System.out.println("Eval :"+expression);
        if(expression.charAt(0) != '('){
            //It is an integer or variable
            if(Character.isLetter(expression.charAt(0))){
                //It is a variable
                return variables.get(expression);
            }
            //It is an integer
            return Integer.parseInt(expression);
        }
        String expressionWB = expression.substring(1, expression.length() - 1);
        int indSpace = expressionWB.indexOf(' ');
        String restExp = expressionWB.substring(indSpace+1);
        if(expressionWB.startsWith("add")){
            return evaluateAdd(restExp, variables);
        }
        else if(expressionWB.startsWith("mult")){
            return evaluateMult(restExp, variables);
        }
        else{
            return evaluateLet(restExp, variables);
        }
    }
    
    public static int evaluateAdd(String expression, HashMap<String, Integer> variables){
    	System.out.println("Add :"+expression);
        int val1 = 0, val2 = 0;
        int index = expression.indexOf(' ');
        if(expression.charAt(0) == '('){
            index = getEndIndex(expression)+1;
        }
        val1 = evaluate(expression.substring(0, index), variables);
        val2 = evaluate(expression.substring(index+1), variables);
        return val1 + val2;
    }
    
    public static int evaluateMult(String expression, HashMap<String, Integer> variables){
    	System.out.println("Mult :"+expression);
        int val1 = 0, val2 = 0;
        int index = expression.indexOf(' ');
        if(expression.charAt(0) == '('){
            index = getEndIndex(expression)+1;
        }
        val1 = evaluate(expression.substring(0, index), variables);
        val2 = evaluate(expression.substring(index+1), variables);
        return val1 * val2;
    }
    
    private static int getEndIndex(String expression) {
    	int count = 0;
    	for(int i = 0; i < expression.length(); i++){
    		if(expression.charAt(i) == '('){
    			count++;
    		}
    		if(expression.charAt(i) == ')'){
    			count--;
    			if(count == 0){
    				return i;
    			}
    		}
    	}
		return 0;
	}

	public static int evaluateLet(String expression, HashMap<String, Integer> variables){
		System.out.println("Let :"+expression);
		HashMap<String, Integer> variablesClone = (HashMap<String, Integer>)variables.clone();
        String cur = expression;
        while(true){
        	System.out.println("Cur :"+cur);
            char start = cur.charAt(0);
            if(start == '('){
                //It is an expression
                return evaluate(cur, variablesClone);
            }
            if(Character.isDigit(start)){
            	//Is integer
            	return Integer.parseInt(cur);
            }
            //It is a variable
            int indSp = cur.indexOf(' ');
            if(indSp == -1){
            	//This needs to be evaluated
            	return evaluate(cur, variablesClone);
            }
            //Is is a variable expression pair
            String variable = cur.substring(0, indSp);
            String rest = cur.substring(indSp+1);
            if(rest.charAt(0) == '('){
            	int endIndex = getEndIndex(rest);
            	int value = evaluate(rest.substring(0, endIndex+1), variablesClone);
            	variablesClone.put(variable, value);
            	cur = rest.substring(endIndex+2);
            	continue;
            }
            int indexSp = rest.indexOf(' ');
            int value = evaluate(rest.substring(0, indexSp), variablesClone);
            variablesClone.put(variable, value);
        	cur = rest.substring(indexSp+1);
        }
    }

}
