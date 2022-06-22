package baekjoon.clear;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1260 {
	private static int[][] map;
	private static boolean[] visit_dfs, visit_bfs;
	private static int n, m;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt() + 1;
		m = sc.nextInt();
		int v = sc.nextInt();

		map = new int[n][n];
		visit_dfs = new boolean[n];
		visit_bfs = new boolean[n];

		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			map[x][y] = map[y][x] = 1;
		}

		dfs(v);
		System.out.println();
		bfs(v);

		sc.close();
	}

	public static void dfs(int v) {
		visit_dfs[v] = true;
		System.out.print(v + " ");
		for (int i = 1; i < n; i++) {
			if (map[v][i] == 1 && visit_dfs[i] == false) {
				dfs(i);
			}
		}
	}

	public static void bfs(int v) {
		Queue<Integer> q = new LinkedList<>();
		visit_bfs[v] = true;
		q.offer(v);

		while (!q.isEmpty()) {
			int p = q.poll();
			System.out.print(p + " ");
			for (int i = 1; i < n; i++) {
				if (map[p][i] == 1 && visit_bfs[i] == false) {
					q.add(i);
					visit_bfs[i] = true;
				}
			}
		}
	}
}
