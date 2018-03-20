package java1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class S743 {

	public static void main(String[] args) {
		int [][]times = {{1,2,2},{2,3,5},{3,4,1},{5, 4, 1}, {2, 5, 8}};
		System.out.println(networkDelayTime(times, 5, 1));
	}
	
	public static int networkDelayTime(int[][] times, int N, int K) {
		PriorityQueue<NodeEdge> heap = new PriorityQueue<NodeEdge>();
		HashMap<Integer, NodeEdge> nodeIdToNode = new HashMap<Integer, NodeEdge>();
		HashMap<Integer, ArrayList<int[]>> nodeToEdges = new HashMap<Integer, ArrayList<int[]>>();
		HashSet<Integer> covered = new HashSet<Integer>();
		for(int i = 1; i <= N; i++){
			NodeEdge nodeEdge = new NodeEdge(i);
			nodeIdToNode.put(i, nodeEdge);
			nodeToEdges.put(i, new ArrayList<int[]>());
			heap.add(nodeEdge);
		}
		int countTime = Integer.MAX_VALUE;
		for(int[] edge: times){
			nodeToEdges.get(edge[0]).add(edge);
		}
		//Start by updating Kth
		NodeEdge Kth = nodeIdToNode.get(K);
		Kth.time = 0;
		heap.remove(Kth);
		heap.add(Kth);
		while(!heap.isEmpty()){
			NodeEdge min = heap.remove();
//			System.out.println("Pick:"+min.nodeNum);
			covered.add(min.nodeNum);
			countTime = min.time;
			if(countTime == Integer.MAX_VALUE){
				return -1;
			}
			// Update edges
			ArrayList<int[]> edges = nodeToEdges.get(min.nodeNum);
			for(int[] edge : edges){
//				System.out.println(edge[0]+" to "+edge[1]);
				if(!covered.contains(edge[1])){
					NodeEdge other = nodeIdToNode.get(edge[1]);
					if(countTime + edge[2] < other.time){
						other.time = Math.min(other.time, countTime + edge[2]);
						heap.remove(other);
						heap.add(other);
					}
				}
			}
		}
		if(countTime == Integer.MAX_VALUE){
			return -1;
		}
		return countTime;
    }

}

class NodeEdge implements Comparable<NodeEdge>{
	int nodeNum;
	int time;
	public NodeEdge(int nodeNum){
		this.nodeNum = nodeNum;
		this.time = Integer.MAX_VALUE;
	}

	@Override
	public int compareTo(NodeEdge o) {
		if(this.time == Integer.MAX_VALUE) {
			return 1;
		}
		else if(o.time == Integer.MAX_VALUE){
			return -1;
		}
		else {
			return Integer.compare(this.time, o.time);
		}
	}
	
}
