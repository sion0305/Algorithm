package baekjoon.clear;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1012 {
	static int m, n, k;
	static int[][] grid;
	static boolean[][] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		int[] answer = new int[t];
		
		for (int h = 0; h < t; h++) {
			m = sc.nextInt();// ����
			n = sc.nextInt();// ����
			k = sc.nextInt();// ���� ����
			grid = new int[n][m];
			visit = new boolean[n][m];
			
			for (int i = 0; i < k; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				grid[y][x] = 1;
			}
			
			int result = 0;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(grid[i][j] == 1 && !visit[i][j]) {
						solution(i,j);
						result++;
					}
				}
			}
			
			answer[h] = result;
		}
		
		for(int a : answer) {
			System.out.println(a);
		}
	}

	static int[][] dirs = {{1,0}, {-1,0}, {0,1}, { 0,-1}};
	public static void solution(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		
		q.offer(new int[] {x, y});
		visit[x][y] = true;
		
		while(!q.isEmpty()) {
			int[] p = q.poll();
			for(int[] dir : dirs) {
				int newX = p[0] + dir[0];
				int newY = p[1] + dir[1];
				
				if(newX >= 0 && newX < n && newY >= 0 && newY < m) {
					if(grid[newX][newY] == 1 && !visit[newX][newY]) {
						visit[newX][newY] = true;
						q.offer(new int[] {newX, newY});
					}
				}
			}
		}
	}
}
