package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_7576 {
	static int[][] box;
	static boolean[][] visit;
	static int m,n;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		m = sc.nextInt();//가로
		n = sc.nextInt();//세로
		
		box = new int[n][m];
		visit = new boolean[n][m];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				box[i][j] = sc.nextInt();
			}
		}
		
		solution();
		
		System.out.println(check());
		
	}
	
	static int[][] dirs = {{1,0}, {-1,0}, {0,1}, { 0,-1}};
	public static void solution() {
		Queue<int[]> q = new LinkedList<>();
		
		//얘가 여기 있어야 익은토마토가 2개이상 있을 경우도 계산 할 수 있음.
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(box[i][j] == 1) {
					q.offer(new int[] {i,j});
					visit[i][j]  = true;
				}
			}
		}
		
		while(!q.isEmpty()) {
			int[] p = q.poll();
			for(int[] dir : dirs) {
				int newX = p[0] + dir[0];
				int newY = p[1] + dir[1];
				
				if(newX >= 0 && newX < n && newY >= 0 && newY < m) {
					if(box[newX][newY] != -1 && !visit[newX][newY]) {
						visit[newX][newY] = true;
						box[newX][newY] = box[p[0]][p[1]] + 1;
						q.offer(new int[] {newX, newY});
					}
				}
			}
		}
	}
	
	public static int check() {
		int max = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(box[i][j] == 0) {
					return -1;
				}
				max = Math.max(max, box[i][j]);
			}
		}
		return max-1;
	}
}
