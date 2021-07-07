package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_16948 {
	private static int n;
	private static int[][] chess;
	private static boolean[][] visit;
	private static int[][] dir = {{-2,-1}, {-2, 1}, {0, -2},{0,2}, {2,-1}, {2,1}};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		chess = new int[n][n];
		visit = new boolean[n][n];
		
		int r1 = sc.nextInt();
		int c1 = sc.nextInt();
		int r2 = sc.nextInt();
		int c2 = sc.nextInt();
		
		System.out.println(solution(r1, c1, r2, c2));
		
		sc.close();
	}

	public static int solution(int r1, int c1, int r2, int c2) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {r1, c1});
		visit[r1][c1] = true;
		chess[r1][c1] = 0;
		
		while(!q.isEmpty()) {
			int[] p = q.poll();
			if(p[0] == r2 && p[1] == c2)
				break;
			for(int[] d : dir) {
				int x = p[0] + d[0];
				int y = p[1] + d[1];
				if(x >= 0 && y >= 0 && x < n && y < n) {
					if(!visit[x][y]) {
						q.offer(new int[] {x,y});
						visit[x][y] = true;
						chess[x][y] = chess[p[0]][p[1]] + 1;
					}
				}
			}
		}
		
		return chess[r2][c2] == 0 ? -1 : chess[r2][c2];
	}
}
