package java1;

import java.util.ArrayList;
import java.util.HashSet;

public class PocketFriend {
	public static void dfs(int[][] M, int[] visited, int i,HashSet<Integer> set) {
		for (int j = 0; j < M.length; j++) {
			if (M[i][j] == 1 && visited[j] == 0) {
				visited[j] = 1;
				set.add(j+1);
				dfs(M, visited, j,set);
			}
		}
	}
	public static int findCircleNum(int[][] M,int i,HashSet<Integer> set) {
		int[] visited = new int[M.length];
		if (visited[i] == 0) {
			dfs(M, visited, i,set);
		}
		return set.size();
	}

	public static void main(String args[]) {
//		int n=8;
//		String[] queryType = {"Friend","Friend","Friend","Friend","Friend","Friend","Friend","Total"};
//		int[] student1 = {1,2,3,4,5,6,7,1};
//		int[] student2 = {2,3,4,5,6,7,8,8};
//		int[] result = getTheGroups1(n,queryType,student1,student2);
		
		int n=3;
		String[] queryType = {"Friend","Total"};
		int[] student1 = {1,2};
		int[] student2 = {2,3};
		int[] result = getTheGroups(n,queryType,student1,student2);
		System.out.println("Hello");

		/*int n=4;
		String[] queryType = {"Friend","Total","Total"};
		int[] student1 = {1,3,2};
		int[] student2 = {2,4,3};
		int[] result = getTheGroups(n,queryType,student1,student2);*/
		System.out.println("Answer");
		System.out.println(result[0]);
	}

	public static int find(int[] roots, int id) {

		while(roots[id] != id) {

			roots[id] = roots[roots[id]];  // optional: path compression

			id = roots[id];

		}

		return id;

	}

	public static int[] getTheGroups1(int n, String[] queryType, int[] student1, int[] student2){
		int[] roots = new int[n];
		int[] counts = new int[n];
		for(int i = 0; i < n; i++){
			roots[i] = i;
			counts[i] = 1;
		}

		ArrayList<Integer> totalAns = new ArrayList<Integer>();
		for(int i = 0; i < queryType.length; i++){
			if(queryType[i].equals("Friend")) {
				int f1 = student1[i];
				int f2 = student2[i];
				int root1 = find(roots, f1-1);
				int root2 = find(roots, f2-1);
				if(root1 != root2) {
					roots[root1] = root2;  // union
					counts[root2] += counts[root1];
				}
//				for(int k = 0; k < roots.length; k++){
//					System.out.print(roots[k] + " ");
//				}
//				System.out.println();
//				System.out.print("Counts");
//				for(int k = 0; k < counts.length; k++){
//					System.out.print(counts[k] + " ");
//				}
//				System.out.println();
			} else if(queryType[i].equals("Total")) {
//				for(int k = 0; k < roots.length; k++){
//					System.out.print(roots[k] + " ");
//				}
//				System.out.println();
//				for(int k = 0; k < counts.length; k++){
//					System.out.print(counts[k] + " ");
//				}
//				System.out.println();
//				System.out.println();
				int f1 = student1[i];
				int f2 = student2[i];
				int root1 = find(roots, f1-1);
				int root2 = find(roots, f2-1);
				if(root1 == root2){
					//Same
					totalAns.add(counts[root1]);
				}
				else{
					totalAns.add(counts[root1] + counts[root2]);
				}
			}
		}
		int[] result = new int[totalAns.size()];
		int index = 0;
		for(int i : totalAns){
			result[index] = i;
			index++;
		}
		return result;
	}

	private static int[] getTheGroups(int n, String[] queryType, int[] student1, int[] student2) {
		int[][] M = new int[n][n];
		for(int i=0;i<n;i++) M[i][i]=1;
		ArrayList<Integer> totalAns = new ArrayList<Integer>();
		for(int i = 0; i < queryType.length; i++){
			if(queryType[i].equals("Friend")) {
				int f1 = student1[i];
				int f2 = student2[i];
				M[f1-1][f2-1] = 1;
				M[f2-1][f1-1] = 1;
			} else if(queryType[i].equals("Total")) {
				HashSet<Integer> set = new HashSet<Integer>();
				int totalFirst = findCircleNum(M,student1[i]-1,set);
				int totalSecond = findCircleNum(M,student2[i]-1,set);
				totalAns.add( set.size());
			}
		}
		int[] result = new int[totalAns.size()];
		int index = 0;
		for(int i : totalAns){
			result[index] = i;
			index++;
		}
		return result;

	}
}