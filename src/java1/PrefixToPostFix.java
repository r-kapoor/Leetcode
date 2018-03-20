package java1;

import java.util.Stack;


public class PrefixToPostFix {

    public static void main(String args[]) {
    	
    	String result = prefixToPostfix("++A*BCD");
    	System.out.println(result);
    	
    }
    private static String prefixToPostfix(String prefixExp) {

        final String PARSE_LEFT = "PARSE_LEFT";

        Stack<String> operatorsStack = new Stack<>();
        StringBuilder output = new StringBuilder();

        if (prefixExp.trim().isEmpty()) {
            return null;
        }

        char[] chars = prefixExp.toCharArray();

        for (char aChar : chars) {

            if (isOperator(aChar)) {
            	operatorsStack.push(String.valueOf(aChar));
            } else {
            	output.append(String.valueOf(aChar));
                while (!operatorsStack.empty() && operatorsStack.peek().equals(PARSE_LEFT)) {
                	operatorsStack.pop();
                	output.append(operatorsStack.pop());
                }
                operatorsStack.push(PARSE_LEFT);
            }
        }

        return output.toString();
    }

    private static boolean isOperator(char c) {
    	//list of operators
        char[] operators = {'+', '-', '/', '*'};
        boolean isOperator = false;
        for (char operator : operators) {
            if (c == operator) {
            	isOperator = true;
                break;
            }
        }
        return isOperator;
    }
}
