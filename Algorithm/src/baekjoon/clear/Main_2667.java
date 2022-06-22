package baekjoon.clear;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_2667 {
	static int[][] map;
	static boolean[][] visit;
	static int n;
	static int[] result;
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		map = new int[n][n];
		visit = new boolean[n][n];
		result = new int[n * n];
		int potNum = 0;

		for (int i = 0; i < n; i++) {
			String s = sc.next();
			for (int j = 0; j < n; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 1 && !visit[i][j]) {
					potNum++;
					solution(i, j, potNum);
				}
			}
		}

		Arrays.sort(result);
		System.out.println(potNum);

		for (int i = 0; i < result.length; i++) {
			if (result[i] > 0) {
				System.out.println(result[i]);
			}
		}
	}

	public static void solution(int x, int y, int pot) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { x, y });
		visit[x][y] = true;
		result[pot]++;

		while (!q.isEmpty()) {
			int[] p = q.poll();
			for (int[] d : dirs) {
				int newX = p[0] + d[0];
				int newY = p[1] + d[1];

				if (newX >= 0 && newY >= 0 && newX < n && newY < n) {
					if (map[newX][newY] == 1 && !visit[newX][newY]) {
						q.add(new int[] { newX, newY });
						visit[newX][newY] = true;
						result[pot]++;
					}
				}
			}
		}
	}
}
