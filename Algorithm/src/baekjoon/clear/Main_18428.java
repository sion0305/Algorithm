package baekjoon.clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_18428 {
	static int N, cnt;
	static char map[][];
	static ArrayList<Integer> teacher;
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.valueOf(st.nextToken());
		teacher = new ArrayList<>();
		cnt = 0;
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = st.nextToken().charAt(0);
				if (map[i][j] == 'T') {
					teacher.add(cnt);
				}
				cnt++;
			}
		}
		flag = false;
		dfs(0, 0);
		if (flag)
			System.out.println("YES");
		else
			System.out.println("NO");
	}

	static void dfs(int idx, int pick) {
		if (flag)
			return;
		if (idx == N * N) {
			return;
		}
		if (pick == 3) {
			if (find_stu()) {
				flag = true;
			}
			return;
		}
		int r = idx / N;
		int c = idx % N;
		if (map[r][c] == 'X') {
			map[r][c] = 'O';
			dfs(idx + 1, pick + 1);
			map[r][c] = 'X';
		}
		dfs(idx + 1, pick);
	}

	static boolean find_stu() {
		for (int k : teacher) {
			for (int i = 0; i < 4; i++) {
				int cr = k / N;
				int cc = k % N;
				while (true) {
					int nr = cr + dr[i];
					int nc = cc + dc[i];
					if (nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] == 'O')
						break;
					if (map[nr][nc] == 'S') {
						return false;
					}
					cr = nr;
					cc = nc;
				}
			}
		}
		return true;
	}
}
