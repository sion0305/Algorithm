package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main_11404 {
	public static final int INF = (int) 1e9;
	public static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int m = sc.nextInt();

		map = new int[n + 1][n + 1];

		for (int a = 1; a <= n; a++) {
			for (int b = 1; b <= n; b++) {
				if (a != b)
					map[a][b] = INF;
			}
		}

		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			map[a][b] = c;
		}

		for (int k = 1; k <= n; k++) {
			for (int a = 1; a <= n; a++) {
				if (a == k)
					continue;
				for (int b = 1; b <= n; b++) {
					if (a == b || b == k)
						continue;
					map[a][b] = Math.min(map[a][b], map[a][k] + map[k][b]);
				}
			}
		}

		for (int a = 1; a <= n; a++) {
			for (int b = 1; b <= n; b++) {
				if (map[a][b] == INF) {
					map[a][b] = 0;
				}
				System.out.print(map[a][b] + " ");
			}
			System.out.println();
		}

	}

}
