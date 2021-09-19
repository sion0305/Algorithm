package baekjoon;

import java.util.Scanner;

public class Main_2617 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		int[][] board = new int[n + 1][n + 1];

		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			board[a][b] = 1;
			board[b][a] = -1;
		}

		for (int k = 1; k <= n; k++) {
			for (int a = 1; a <= n; a++) {
				for (int b = 1; b <= n; b++) {
					if (board[a][k] == -1 && board[k][b] == -1) {
						board[a][b] = -1;
						board[b][a] = 1;
					}
				}
			}
		}

		int lightMax = n / 2;
		int heavyMax = n / 2;

		int answer = 0;
		for (int i = 1; i <= n; i++) {
			int lightNum = 0, heavyNum = 0;
			for (int j = 1; j <= n; j++) {

				if (board[i][j] == -1)
					heavyNum++;
				else if (board[i][j] == 1)
					lightNum++;

			}
			if (lightNum > lightMax || heavyNum > heavyMax)
				answer++;
		}

		System.out.println(answer);

	}

}
