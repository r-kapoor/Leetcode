package java1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class S684 {
	
	public static void main(String args[]){
//		int[][] edges = {{1,2}, {1,3}, {2,3}};
		int[][] edges = {{1,2}, {2,3}, {3,4}, {1,4}, {1,5}};
		int[] result = findRedundantConnection(edges);
		System.out.println(result[0]+","+result[1]);
	}
	
    public static int[] findRedundantConnection(int[][] edges) {
    	if(edges.length == 0){
    		return new int[]{0, 0};
    	}
    	HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<Integer, ArrayList<Integer>>();
    	Stack<Integer> stack = new Stack<Integer>();
    	int curNode = edges[0][0];
    	HashSet<String> coveredEdge = new HashSet<String>();
    	HashSet<Integer> coveredNode = new HashSet<Integer>();
    	for(int[] edge:edges){
    		// For node 1
    		ArrayList<Integer> adj = adjList.get(edge[0]);
    		if(adj == null){
    			adj = new ArrayList<Integer>();
    			adjList.put(edge[0], adj);
    		}
    		adj.add(edge[1]);
    		// For node 2
    		adj = adjList.get(edge[1]);
    		if(adj == null){
    			adj = new ArrayList<Integer>();
    			adjList.put(edge[1], adj);
    		}
    		adj.add(edge[0]);
    	}
    	int otherNode = -1;
    	int retVal = dfs(adjList, curNode, stack, coveredEdge, coveredNode);
    	HashSet<String> cycleEdges = new HashSet<String>();
    	int cur = retVal;
    	while(retVal != stack.peek()){
    		int other = stack.pop();
    		cycleEdges.add(Math.min(cur, other) + ":" + Math.max(cur, other));
    		cur = other;
    	}
    	cycleEdges.add(Math.min(cur, retVal) + ":" + Math.max(cur, retVal));
    	int[] result = {-1, -1};
    	for(int []edge:edges){
    		if(cycleEdges.contains(edge[0]+":"+edge[1])){
    			result = edge;
    		}
    	}
		return result;
    }

	private static int dfs(HashMap<Integer, ArrayList<Integer>> adjList, int curNode, Stack<Integer> stack, HashSet<String> coveredEdge, HashSet<Integer> coveredNode) {
		if(adjList.isEmpty()){
			return -1;
		}
		stack.push(curNode);
		coveredNode.add(curNode);
		ArrayList<Integer> adj = adjList.get(curNode);
		for(int adjNode : adj){
			String edgeString = Math.min(curNode, adjNode) + ":" + Math.max(curNode, adjNode);
			if(!coveredEdge.contains(edgeString)){
				//Edge is not covered
				coveredEdge.add(edgeString);
				if(coveredNode.contains(adjNode)){
					// Found Cycle
					return adjNode;
				}
				//DFS further
				int retVal = dfs(adjList, adjNode, stack, coveredEdge, coveredNode);
				if(retVal != -1){
					return retVal;
				}
				
			}
		}
		stack.pop();
		adjList.remove(curNode);
		return -1;
	}

}
