package baekjoon.clear;

import java.util.Scanner;

public class Main_3109 { // �׸���
	static char[][] map;
	static int R;
	static int C;
	static int val;

	public static void main(String[] args)  {
//		Scanner sc = new Scanner(System.in);
//		R = sc.nextInt();
//		C = sc.nextInt();
//
//		map = new char[R][C];
//		for (int i = 0; i < R; i++)
//			map[i] = sc.next().toCharArray();
//
//		for (int i = 0; i < R; i++)
//			if (check(i, 0))
//				val++;
//		System.out.println(val);
		
		int[] arr = new int[3];
		
		System.out.println(arr.toString());
	}

	public static boolean check(int x, int y) {
		map[x][y] = '-';

		if (y == C - 1) // ������ ��(������ ����)�� ����������
			return true;

		if (x > 0 && map[x - 1][y + 1] == '.') // ������ ��
			if (check(x - 1, y + 1))
				return true;
		if (map[x][y + 1] == '.') // ������
			if (check(x, y + 1))
				return true;
		if (x + 1 < R && map[x + 1][y + 1] == '.') // ������ �Ʒ�
			if (check(x + 1, y + 1))
				return true;
		return false;
	}
}
