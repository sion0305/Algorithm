package baekjoon.clear;

import java.util.*;

public class Main_14502 {
	static int[][] map;
	static int n, m;
	static int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
	static int result = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		map = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		dfs(0);
		
		System.out.println(result);
	}
	
	public static void dfs(int count) {
		if(count == 3) {
			bfs();

			return;
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				map[i][j] = 1;
				dfs(count + 1);
				map[i][j] = 0;
			}
		}
	}
	
	public static void bfs() {
		int[][] copy = new int[n][m];
		Queue<int[]> q = new LinkedList<>();
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				copy[i][j] = map[i][j];
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(copy[i][j] == 2) {
					q.add(new int[] {i,j});
				}
			}
		}
		
		while(!q.isEmpty()) {
			int[] p = q.poll();
			
			for(int[] dir : dirs) {
				int newX = p[0] + dir[0];
				int newY = p[1] + dir[1];
				
				if(newX >= 0 && newY >= 0 && newX < n && newY < m) {
					if(copy[newX][newY] ==  0) {
						copy[newX][newY] = 2;
						q.add(new int[] {newX, newY});
					}
				}
			}
		}

		countSafe(copy);
		
	}
	public static void countSafe(int[][] copy) {
		int cnt = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(copy[i][j] == 0)
					cnt++;
			}
		}
		
		result = Math.max(cnt, result);
	}
}