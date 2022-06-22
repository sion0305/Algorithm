package baekjoon.clear;

import java.io.*;
import java.util.*;

public class Main_15685 {
	// x�� ���� y�� ����
	static int[][] map = new int[101][101];
	static int square_count = 0;
	// �ε��� ���� 0,1,2,3 �����̴�.
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		for (int t = 0; t < n; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int type = Integer.parseInt(st.nextToken());
			int gen = Integer.parseInt(st.nextToken());

			dragonCurve(x, y, type, gen);
		}

		checkSquare();

		System.out.println(square_count);
	}

	/*
	 * type 0: x��ǥ ���� (��) 1: y��ǥ ���� (��) 2: x��ǥ ���� (��) 3: y��ǥ ���� (��)
	 */
	public static void dragonCurve(int x, int y, int type, int gen) {
		// �� ������ ���� �� �ִ� ArrayList�̴�.
		ArrayList<Integer> arr = new ArrayList<Integer>();

		int tmp_type = type;
		arr.add(tmp_type);
		for (int i = 1; i <= gen; i++) {
			// �� �ڿ������� �����Ѵ�. �ƿ� �������� �ص� �� �� ����.
			for (int j = arr.size() - 1; j >= 0; j--) {
				// ������ �����ڸ� ���� 0,1,2,3�� ���� ���� �� �ְ� �Ѵ�.
				tmp_type = (arr.get(j) + 1) % 4;
				arr.add(tmp_type);
			}
		}

		int tmp_x = x;
		int tmp_y = y;

		for (int i = 0; i < arr.size(); i++) {
			map[tmp_y][tmp_x] = 1;
			tmp_x += dx[arr.get(i)];
			tmp_y += dy[arr.get(i)];
		}

		// �������� �־����� �����Ƿ� �־��ִ� ó���Ѵ�.
		map[tmp_y][tmp_x] = 1;
	}

	public static void checkSquare() {
		int[] dx = { 1, 0, 1 };
		int[] dy = { 0, 1, 1 };
		int check_count = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (map[i][j] == 1) {
					for (int k = 0; k < 3; k++) {
						int tmp_i = i + dy[k];
						int tmp_j = j + dx[k];
						// ������ �Ѿ�� �ʰ� �巡�� Ŀ���� �Ϻ��̸� check_count�� ������Ų��.
						if (tmp_i >= 0 && tmp_i < 101 && tmp_j >= 0 && tmp_j < 101 && map[tmp_i][tmp_j] == 1) {
							check_count++;
						}

					}
					// check_count�� 3�� �Ǹ� 4���� �������� ��� �巡�� Ŀ���� �Ϻ����� Ȯ�εȴ�.
					if (check_count == 3) {
						square_count++;
					}

					check_count = 0;
				}
			}
		}

	}
}
