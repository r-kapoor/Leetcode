package java1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.tools.ToolProvider;

public class S417 {

	public static void main(String[] args) {
//		int[][] matrix = {
//				{1,2,2,3,5},
//				{3,2,3,4,4},
//				{2,4,5,3,1},
//				{6,7,1,4,5},
//				{5,1,1,2,4},
//		};
//		int [][]matrix = {
//				{1,1},
//				{1,1}
//		};
		int [][]matrix = {
				{1,2,2,3,5},
				{3,2,3,4,4},
				{2,4,5,3,1},
				{6,7,1,4,5},
				{5,1,1,2,4}
		};
		List<int[]> result = pacificAtlantic(matrix);
		for(int[] r : result){
			System.out.println(r[0]+":"+r[1]);
		}

	}
	
	public static List<int[]> pacificAtlantic(int[][] matrix) {
		ArrayList<int[]> result = new ArrayList<int[]>();
		HashSet<Position> toPacific = new HashSet<Position>();
		HashSet<Position> toPacificCovered = new HashSet<Position>();
		int m = matrix.length;
		if(m == 0){
			return result;
		}
		int n = matrix[0].length;
		if(n == 0){
			return result;
		}
		for(int i = 0; i < m; i++){
			toPacific.add(new Position(i, 0));
		}
		for(int i = 1; i < n; i++){
			toPacific.add(new Position(0, i));
		}
		while(toPacific.size() != 0){
			HashSet<Position> toPacificNew = new HashSet<Position>();
			for(Position pos:toPacific){
				ArrayList<Position> adj = pos.getValidAdjacentPos(m, n);
				for(Position adja : adj){
					if(matrix[adja.x][adja.y] >= matrix[pos.x][pos.y]){
						//Water will flow from ajda to pos and hence to Pacific
						if(!toPacificCovered.contains(adja) && !toPacific.contains(adja)){
							toPacificNew.add(adja);
						}
					}
				}
				toPacificCovered.add(pos);
			}
			toPacific.clear();
			toPacific.addAll(toPacificNew);
		}
//		for(Position p:toPacificCovered){
//			System.out.println("P:"+p);
//		}
		
		HashSet<Position> toAtlantic = new HashSet<Position>();
		HashSet<Position> toAtlanticCovered = new HashSet<Position>();
		for(int i = 0; i < m; i++){
			toAtlantic.add(new Position(i, n-1));
		}
		for(int i = 0; i < n-1; i++){
			toAtlantic.add(new Position(m-1, i));
		}
		while(toAtlantic.size() != 0){
			HashSet<Position> toAtlanticNew = new HashSet<Position>();
			for(Position pos:toAtlantic){
				ArrayList<Position> adj = pos.getValidAdjacentPos(m, n);
				for(Position adja : adj){
					if(matrix[adja.x][adja.y] >= matrix[pos.x][pos.y]){
						//Water will flow from ajda to pos and hence to Pacific
						if(!toAtlanticCovered.contains(adja) && !toAtlantic.contains(adja)){
							toAtlanticNew.add(adja);
						}
					}
				}
				toAtlanticCovered.add(pos);
			}
			toAtlantic.clear();
			toAtlantic.addAll(toAtlanticNew);
		}
//		for(Position p:toAtlanticCovered){
//			System.out.println("A:"+p);
//		}
		toPacificCovered.retainAll(toAtlanticCovered);
		
		for(Position p : toPacificCovered){
			int[] arr = {p.x, p.y};
			result.add(arr);
		}
		return result;
    }
}

class Position {
	public int x;
	public int y;
	public Position(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public ArrayList<Position> getValidAdjacentPos(int m, int n) {
		ArrayList<Position> adj = new ArrayList<Position>();
		int i = x - 1, j = y;
		if (i >= 0 && j >= 0 && i < m && j < n){
			adj.add(new Position(i, j));
		}
		i = x + 1;
		j = y;
		if (i >= 0 && j >= 0 && i < m && j < n){
			adj.add(new Position(i, j));
		}
		i = x;
		j = y - 1;
		if (i >= 0 && j >= 0 && i < m && j < n){
			adj.add(new Position(i, j));
		}
		i = x;
		j = y + 1;
		if (i >= 0 && j >= 0 && i < m && j < n){
			adj.add(new Position(i, j));
		}
		return adj;
	}
	
	@Override
	public int hashCode(){
		return x * 31 + y;
	}
	
	@Override
	public boolean equals(Object obj){
//		System.out.println(this+"::"+obj+":"+(this.x == obj.x && this.y == obj.y));
		Position o = (Position)obj;
		return this.x == o.x && this.y == o.y;
	}
	
	@Override
	public String toString(){
		return x + ":" + y;
	}
}