package baekjoon.clear;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_2468 {
	static int[][] map;
	static boolean[][] visit;
	static int n, max;
	
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		
		n = sc.nextInt();
		
		map = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		max = 0;
		for(int h = 0; h < 101; h++) {
			visit = new boolean[n][n];
			int count = 0;
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(map[i][j] > h && !visit[i][j]) {
						solution(i,j,h);
						count++;
					}
				}
			}
			max = Math.max(max, count);
			
		}
		System.out.println(max);
	}
	static int[][] dirs = {{1,0}, {-1,0}, {0,1}, { 0,-1}};
	public static void solution(int x, int y, int h) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x,y});
		visit[x][y] = true;
		
		while(!q.isEmpty()) {
			int[] p = q.poll();
			for(int[] dir : dirs) {
				int newX = p[0] + dir[0];
				int newY = p[1] + dir[1];
				
				if(newX >= 0 && newX < n && newY >= 0 && newY < n) {
					if(map[newX][newY] > h && !visit[newX][newY]) {
						visit[newX][newY] = true;
						q.offer(new int[] {newX, newY});
					}
				}
			}
		}
	}
}
