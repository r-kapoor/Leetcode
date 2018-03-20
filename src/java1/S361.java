package java1;

public class S361 {

	public static void main(String[] args) {
		char[][] grid = {{'0','E','0','0'},{'E','0','W','E'},{'0','E','0','0'}};
		System.out.println(maxKilledEnemies(grid));
		
	}
	
	public static int maxKilledEnemies(char[][] grid) {
		if(grid.length == 0){
			return 0;
		}
		if(grid[0].length == 0){
			return 0;
		}
		int[][] kills = new int[grid.length][grid[0].length];
		for(int i = 0; i < kills.length; i++){
			int cur = 0;
			int start = 0;
			for(int j = 0; j < kills[i].length; j++){
				if(grid[i][j] == 'E'){
					cur++;
				}
				else if(grid[i][j] == 'W'){
					if(cur > 0){
						for(int k = start; k < j; k++){
							if(grid[i][k] == '0'){
								kills[i][k] += cur;
							}
						}
					}
					cur = 0;
					start = j+1;
				}
			}
			if(cur > 0){
				for(int k = start; k < kills[i].length; k++){
					if(grid[i][k] == '0'){
						kills[i][k] += cur;
					}
				}
			}
		}
		
		for(int j = 0; j < kills[0].length; j++){
			int cur = 0;
			int start = 0;
			for(int i = 0; i < kills.length; i++){
				if(grid[i][j] == 'E'){
					cur++;
				}
				else if(grid[i][j] == 'W'){
					if(cur > 0){
						for(int k = start; k < i; k++){
							if(grid[k][j] == '0'){
								kills[k][j] += cur;
							}
						}
					}
					cur = 0;
					start = i+1;
				}
			}
			if(cur > 0){
				for(int k = start; k < kills.length; k++){
					if(grid[k][j] == '0'){
						kills[k][j] += cur;
					}
				}
			}
		}
		
		int max = 0;
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[i].length; j++){
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[i].length; j++){
				System.out.print(kills[i][j] + " ");
			}
			System.out.println();
		}
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[i].length; j++){
				if(max < kills[i][j]){
					max = kills[i][j];
				}
			}
		}
        return max;
    }

}
