package baekjoon;

import java.util.Scanner;

public class Main_3109 { // 그리디
	static char[][] map;
	static int R;
	static int C;
	static int val;

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();

		map = new char[R][C];
		for (int i = 0; i < R; i++)
			map[i] = sc.next().toCharArray();

		for (int i = 0; i < R; i++)
			if (check(i, 0))
				val++;
		System.out.println(val);
	}

	public static boolean check(int x, int y) {
		map[x][y] = '-';

		if (y == C - 1) // 마지막 열(원웅이 빵집)에 도착했으면
			return true;

		if (x > 0 && map[x - 1][y + 1] == '.') // 오른쪽 위
			if (check(x - 1, y + 1))
				return true;
		if (map[x][y + 1] == '.') // 오른쪽
			if (check(x, y + 1))
				return true;
		if (x + 1 < R && map[x + 1][y + 1] == '.') // 오른쪽 아래
			if (check(x + 1, y + 1))
				return true;
		return false;
	}
}
