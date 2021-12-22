package baekjoon;

import java.util.Scanner;

public class Main_16918 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt();
		int C = sc.nextInt();
		int N = sc.nextInt();

		StringBuilder sb = new StringBuilder();
		int[][] boom = new int[R][C];
		for (int i = 0; i < R; i++) {
			char[] tmp = sc.next().toCharArray();
			for (int j = 0; j < C; j++) {
				boom[i][j] = tmp[j] == 'O' ? 3 : 0;// 터지기 까지 남은 시간
			}
		}
		
		//0,1초에는 아무일도 일어나지 않음 2초부터 시작
		for (int n = 2; n <= N; n++) {
			//3,4 반복이니까 홀수에 폭발
			if (n % 2 == 1) {
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						//현재 초와 같으면 0 -> 상하좌우 폭발
						if (boom[i][j] == n) {
							boom[i][j] = 0;
							if (i > 0 && boom[i - 1][j] != n)
								boom[i - 1][j] = 0;
							if (j > 0 && boom[i][j - 1] != n)
								boom[i][j - 1] = 0;
							if (i < R - 1 && boom[i + 1][j] != n)
								boom[i + 1][j] = 0;
							if (j < C - 1 && boom[i][j + 1] != n)
								boom[i][j + 1] = 0;
						}
					}
				}
			} else {
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						boom[i][j] = boom[i][j] == 0 ? n + 3 : boom[i][j];
					}
				}
			}
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sb.append(boom[i][j] > 0 ? 'O' : '.');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

}
