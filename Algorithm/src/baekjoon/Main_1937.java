package baekjoon;

import java.util.*;

public class Main_1937 {

	public static boolean[][] visited;
	public static int[][] map, dp;
	static int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
	public static int n;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		map = new int[n][n];
		dp = new int[n][n];
		
		visited = new boolean[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(!visited[i][j]) {
					dfs(i,j,map[i][j]);
				}
			}
		}
		
		System.out.println(answer);
	}

	public static int answer = 0;
	public static void dfs(int x, int y , int cost) {
		int max = 0;
		visited[x][y] = true;
		
		for(int[] dir : dirs) {
			int newX = x + dir[0];
			int newY = y + dir[1];
			
			if(newX >= 0 && newY >= 0 && newX < n && newY < n) {
				if(!visited[newX][newY] && map[newX][newY] > cost) {
					dfs(newX, newY, map[newX][newY]);
				}
				
				if(map[newX][newY] > cost) {
					max = Math.max(max, dp[newX][newY]);
				}
			}
		}
		
		dp[x][y] = max + 1;
		answer = Math.max(answer, dp[x][y]);
	}
}
