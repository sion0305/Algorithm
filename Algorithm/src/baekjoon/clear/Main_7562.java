package baekjoon.clear;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_7562 {
	static int n;
	static int[][] chess;
	static boolean[][] visit;
	static int[][] moves = {{-1, 2}, {-2,1}, {-1,-2}, {-2,-1} , 
							{1,2}, {2,1}, {1,-2}, {2,-1}};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for(int h = 0; h < t; h++) {
			 n = sc.nextInt();
			 
			 chess = new int[n][n];
			 visit = new boolean[n][n];
			 
			 int nowX = sc.nextInt();
			 int nowY = sc.nextInt();
			 
			 int nextX = sc.nextInt();
			 int nextY = sc.nextInt();
			 
			 solution(nowX, nowY, nextX, nextY);
			 
			 System.out.println(chess[nextX][nextY]);
		}
	}
	
	public static void solution(int x, int y, int a, int b) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {x, y});
		visit[x][y] = true;
		
		while(!q.isEmpty()) {
			int[] p = q.poll();
			if(p[0] == a && p[1] == b) {
				break;
			}
			for(int[] m : moves) {
				int newX = p[0] + m[0];
				int newY = p[1] + m[1];
				
				if(newX >= 0 && newX < n && newY >= 0 && newY < n && !visit[newX][newY]) {
					visit[newX][newY] = true;
					chess[newX][newY] = chess[p[0]][p[1]] + 1;
					q.offer(new int[] {newX, newY});
				}
			}
		}
	}
}
