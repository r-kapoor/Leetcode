package java1;

import java.util.PriorityQueue;

public class S286 {

	public static void main(String[] args) {
//		int[][] rooms = {
//				{2147483647, -1, 0, 2147483647},
//				{2147483647, 2147483647, 2147483647, -1},
//				{2147483647, -1, 2147483647, -1},
//				{0, -1, 2147483647, 2147483647},
//		};
		int[][] rooms = {
				{2147483647, 2147483647},
				{2147483647, 2147483647}
		};
		wallsAndGates(rooms);
		for(int i = 0; i < rooms.length; i++){
			for(int j = 0; j < rooms[0].length; j++){
				System.out.print(rooms[i][j]+" ");
			}
			System.out.println();
		}
	}

	public static void wallsAndGates(int[][] rooms) {
		if(rooms.length == 0){
			return;
		}
        PriorityQueue<Grid> heap = new PriorityQueue<Grid>();
        Grid[][] grids = new Grid[rooms.length][rooms[0].length];
        for(int i = 0; i < rooms.length; i++){
        	for(int j = 0; j < rooms[0].length; j++){
        		if(rooms[i][j] == -1){
        			continue;
        		}
        		Grid grid = new Grid(rooms[i][j], i, j);
        		grids[i][j] = grid;
        		heap.add(grid);
        	}
        }
        while(!heap.isEmpty()){
        	Grid head = heap.poll();
        	rooms[head.x][head.y] = head.value;
        	if(head.value == 2147483647){
        		continue;
        	}
        	if(head.x > 0){
        		Grid left = grids[head.x - 1][head.y];
        		if(left != null && left.value > head.value+1){
        			heap.remove(left);
        			left.value = head.value+1;
        			heap.add(left);
        		}
        	}
        	if(head.y > 0){
        		Grid top = grids[head.x][head.y - 1];
        		if(top != null && top.value > head.value+1){
        			heap.remove(top);
        			top.value = head.value+1;
        			heap.add(top);
        		}
        	}
        	if(head.x < rooms.length-1){
        		Grid top = grids[head.x + 1][head.y];
        		if(top != null && top.value > head.value+1){
        			heap.remove(top);
        			top.value = head.value+1;
        			heap.add(top);
        		}
        	}
        	if(head.y < rooms[0].length-1){
        		Grid top = grids[head.x][head.y + 1];
        		if(top != null && top.value > head.value+1){
        			heap.remove(top);
        			top.value = head.value+1;
        			heap.add(top);
        		}
        	}
        }
    }
	
	
}

class Grid implements Comparable<Grid>{
	int value;
	int x;
	int y;
	public Grid(int value, int x, int y){
		this.value = value;
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int compareTo(Grid o) {
		return Integer.compare(this.value, o.value);
	}
}
