package java1;

import java.util.HashMap;

public class S399 {
	
	static HashMap<String, Double> variablesValue = new HashMap<String, Double>();
	static HashMap<String, String> variablesTo = new HashMap<String, String>();

	public static void main(String[] args) {
		String [][]equations = { {"a", "b"}, {"b", "c"} };
		double []values = {2.0, 3.0};
		String [][]queries = {{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}}; 
		double[] calc = calcEquation(equations, values, queries);
		for(double c : calc){
			System.out.println(c);
		}
	}

	public static double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
		double results[] = new double[queries.length];
		for(int i = 0; i < equations.length; i++){
			String var1 = equations[i][0];
			String var2 = equations[i][1];
			if(variablesValue.containsKey(var1)){
				if(variablesValue.containsKey(var2)){
					VarVal varVal = getRootVal(var2);
					variablesTo.put(varVal.var, var1);
					variablesValue.put(varVal.var, values[i]/varVal.val);
				}
				else{
					variablesTo.put(var2, var1);
					variablesValue.put(var2, (1/values[i]));
				}
			}
			else if(variablesValue.containsKey(var2)){
				variablesTo.put(var1, var2);
				variablesValue.put(var1, values[i]);
			}
			else{
				//Both not present
				variablesTo.put(var1, var1);
				variablesTo.put(var2, var1);
				variablesValue.put(var2, 1/values[i]);
				variablesValue.put(var1, 1.0);
			}
		}
		for(int i = 0; i < queries.length; i++){
			String []query = queries[i];
			VarVal v1 = getRootVal(query[0]);
			VarVal v2 = getRootVal(query[1]);
			if(!v1.var.equals(v2.var) || v1.var.equals("") || v2.var.equals("")){
				results[i] = -1;
			}
			else{
				results[i] = v1.val/v2.val;
			}
		}
		return results;        
    }

	private static VarVal getRootVal(String var1) {
		if(!variablesTo.containsKey(var1)){
			return new VarVal("", 0);
		}
		double val = 1;
		while(!variablesTo.get(var1).equals(var1)){
			val *= variablesValue.get(var1);
			var1 = variablesTo.get(var1);
		}
		return new VarVal(var1, val);
	}

}

class VarVal {
	public String var;
	public double val;
	public VarVal(String var, double val){
		this.var = var;
		this.val = val;
	}
}
