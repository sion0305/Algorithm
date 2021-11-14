package baekjoon;

import java.io.*;
import java.util.*;

public class Main_15685 {
	// x가 가로 y가 세로
	static int[][] map = new int[101][101];
	static int square_count = 0;
	// 인덱스 별로 0,1,2,3 방향이다.
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
	 * type 0: x좌표 증가 (우) 1: y좌표 감소 (상) 2: x좌표 감소 (좌) 3: y좌표 증가 (하)
	 */
	public static void dragonCurve(int x, int y, int type, int gen) {
		// 각 방향을 담을 수 있는 ArrayList이다.
		ArrayList<Integer> arr = new ArrayList<Integer>();

		int tmp_type = type;
		arr.add(tmp_type);
		for (int i = 1; i <= gen; i++) {
			// 맨 뒤에서부터 접근한다. 아예 스택으로 해도 될 것 같다.
			for (int j = arr.size() - 1; j >= 0; j--) {
				// 나누기 연산자를 통해 0,1,2,3의 값만 나올 수 있게 한다.
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

		// 마지막에 넣어주지 않으므로 넣어주는 처리한다.
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
						// 범위를 넘어가지 않고 드래곤 커브의 일부이면 check_count를 증가시킨다.
						if (tmp_i >= 0 && tmp_i < 101 && tmp_j >= 0 && tmp_j < 101 && map[tmp_i][tmp_j] == 1) {
							check_count++;
						}

					}
					// check_count가 3이 되면 4개의 꼭지점이 모두 드래곤 커브의 일부임이 확인된다.
					if (check_count == 3) {
						square_count++;
					}

					check_count = 0;
				}
			}
		}

	}
}
