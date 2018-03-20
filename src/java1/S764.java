package java1;

public class S764 {

	public static void main(String[] args) {
		int[][] mines = {{4, 2}};
		System.out.println(orderOfLargestPlusSign(5, mines));
	}

	public static int orderOfLargestPlusSign(int N, int[][] mines) {
        if(mines.length == 0){
            if(N%2 == 0){
                return N/2;
            }
            else{
                return (N+1)/2;
            }
        }
        int[][] maze = new int[N][N];
        for(int i = 0; i < N; i++){
        	for(int j = 0; j < N; j++){
        		maze[i][j] = 1;
        	}
        }
        for(int i = 0; i < mines.length; i++){
        	maze[mines[i][0]][mines[i][1]] = 0;
        }
        int[][] leftToRight = new int[N][N];
        int[][] rightToLeft = new int[N][N];
        int[][] topToBottom = new int[N][N];
        int[][] bottomToTop = new int[N][N];
        //Left to Right
        for(int i = 0; i < N; i++){
        	for(int j = 0; j < N; j++){
        		if(maze[i][j] == 1){
        			if(j == 0){
        				leftToRight[i][j] = 1;
        			}
        			else{
        				leftToRight[i][j] = leftToRight[i][j-1] + 1;
        			}
        		}
        	}
        }
        //Right to Left
        for(int i = 0; i < N; i++){
        	for(int j = N-1; j >= 0; j--){
        		if(maze[i][j] == 1){
        			if(j == N-1){
        				rightToLeft[i][j] = 1;
        			}
        			else{
        				rightToLeft[i][j] = rightToLeft[i][j+1] + 1;
        			}
        		}
        	}
        }
        //Top to Bottom
        for(int j = 0; j < N; j++){
        	for(int i = 0; i < N; i++){
        		if(maze[i][j] == 1){
        			if(i == 0){
        				topToBottom[i][j] = 1;
        			}
        			else{
        				topToBottom[i][j] = topToBottom[i-1][j] + 1;
        			}
        		}
        	}
        }
        //Bottom to Top
        for(int j = 0; j < N; j++){
        	for(int i = N-1; i >= 0; i--){
        		if(maze[i][j] == 1){
        			if(i == N-1){
        				bottomToTop[i][j] = 1;
        			}
        			else{
        				bottomToTop[i][j] = bottomToTop[i+1][j] + 1;
        			}
        		}
        	}
        }
        int max = 0;
        for(int i = 0; i < N; i++){
        	for(int j = 0; j < N; j++){
        		max = Math.max(max, Math.min(leftToRight[i][j], Math.min(rightToLeft[i][j], 
        				Math.min(topToBottom[i][j], bottomToTop[i][j]))));
        	}
        }
        return max;
    }
}
