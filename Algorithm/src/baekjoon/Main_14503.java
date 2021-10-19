package baekjoon;

import java.util.*;

public class Main_14503 {
	static int n, m;
	static int[][] map;
	static int[][] dirs = { { -1, 0 }, { 0, 1 } , { 1, 0 }, { 0, -1 }};
	static int result = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();

		int x = sc.nextInt();
		int y = sc.nextInt();
		int d = sc.nextInt();

		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		clean(x, y, d);
		
		System.out.println(result);
	}

	public static void clean(int x, int y, int d) {
		if(map[x][y] == 0) {
			map[x][y] = 2;
			result++;
		}
		
		boolean flag = false;
		int origin = d;
		for (int i = 0; i < 4; i++){
			int newD = (d + 3) % 4;
			int newX = x + dirs[newD][0];
			int newY = y + dirs[newD][1];
			
			if(newX >= 0 && newY >= 0 && newX < n && newY < m) {
				if(map[newX][newY] == 0) {
					clean(newX, newY, newD);
					flag = true;
					break;
				}
			}
			d = (d + 3) % 4;
		}

		if(!flag) {
			int newD = (origin + 2) % 4;
			int newX = x + dirs[newD][0];
			int newY = y + dirs[newD][1];
			
			if(newX > 0 && newY > 0 && newX < n && newY < m) {
				if(map[newX][newY] != 1) {
					clean(newX, newY, origin);
				}
			}
		}
	}

}
