package baekjoon.clear;

import java.util.*;

public class Main_17182 {

	static int[][] map;
	static int N;
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int start = sc.nextInt();
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				map[i][j] = sc.nextInt();
		}

		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]); // �÷��̵� �ͼ� �˰������� �ּ� �Ÿ�
					//�ѹ� ������ ������ �ٽ� ���� �־ �÷��̵� ���
				}
			}
		}

		boolean[] visited = new boolean[N];
		visited[start] = true;
		dfs(visited, start, 0, 0);

		System.out.println(ans);
	}

	//������ ���� ���ؼ� �Ÿ� �ִܰŸ� ���ϱ�
	public static void dfs(boolean[] visited, int temp, int sum, int depth) {
		if (depth == N - 1) {
			ans = Math.min(ans, sum); // �ִ� �Ÿ� 
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(visited, i, sum + map[temp][i], depth + 1); // �������� ������ ������
				visited[i] = false;
			}
		}
	}
}