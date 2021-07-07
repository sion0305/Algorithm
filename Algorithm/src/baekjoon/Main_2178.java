package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_2178 {
	private static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	private static boolean[][] visit;
	private static int N, M;
	private static int[][] maze;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();
        maze = new int[N][M];
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = str.charAt(j)-'0';
            }
        }
	
		solution();
		System.out.println(maze[N-1][M-1]);
		
		sc.close();
	}

	public static void solution() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { 0, 0 });

		while (!q.isEmpty()) {
			int[] p = q.poll();
			visit[p[0]][p[1]] = true;

			for (int[] d : dirs) {
				int x = p[0] + d[0];
				int y = p[1] + d[1];

				if (x >= 0 && x < N && y >= 0 && y < M && maze[x][y] != 0 && !visit[x][y]) {
					maze[x][y]  = maze[p[0]][p[1]] + 1;
					q.offer(new int[] { x, y });
					visit[x][y] = true;
				}
			}
		}
	}
}
