package baekjoon;

import java.util.Scanner;

public class Main_14499 {
	private static int top = 0, bottom = 0, east = 0, west = 0, north = 0, south = 0;
	private static int[][] dir = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
	private static int x, y;
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		x = sc.nextInt();
		y = sc.nextInt();
		int k = sc.nextInt();

		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < k; i++) {
			int d = sc.nextInt();
			x += dir[d - 1][0];
			y += dir[d - 1][1];
			if (x < 0 || x >= n || y < 0 || y >= m) { //지도 밖
				x -= dir[d - 1][0];
				y -= dir[d - 1][1];
				continue;
			}
			move(d);
		}
	}

	public static void move( int d) {
		switch (d) {
		case 1: //동
			int temp = top;
			top = west;
			west = bottom;
			bottom = east;
			east = temp;
			break;
		case 2: //서
			temp = top;
			top = east;
			east = bottom;
			bottom = west;
			west = temp;
			break;
		case 3: //북
			temp = top;
			top = south;
			south = bottom;
			bottom = north;
			north = temp;
			break;
		case 4: //남
			temp = top;
			top = north;
			north = bottom;
			bottom = south;
			south = temp;
			break;
		}
		if (map[x][y] == 0)
			map[x][y] = bottom;
		else {
			bottom = map[x][y];
			map[x][y] = 0;
		}
			
		System.out.println(top);
	}

}
