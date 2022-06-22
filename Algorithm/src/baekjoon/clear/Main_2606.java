package baekjoon.clear;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_2606 {
	static int comp[][];
	static boolean visit[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		comp = new int[n + 1][n + 1];
		visit = new boolean[n + 1];
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			comp[a][b] = 1;
			comp[b][a] = 1;

		}

		solution(1);

	}

	static void solution(int start) {
		Queue<Integer> queue = new LinkedList<>();
		visit[start] = true;
		queue.offer(start);
		int cnt = 0;

		while (!queue.isEmpty()) {
			int x = queue.poll();

			for (int i = 1; i < comp.length; i++) {
				if (comp[x][i] == 1 && !visit[i]) {
					queue.offer(i);
					visit[i] = true;
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}
