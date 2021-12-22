package baekjoon;

import java.util.Scanner;

public class Main_16967 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		int[][] arrA = new int[a][b];
		int[][] arrB = new int[a + x][b + y]; //겹치는 부분은 값을 더해서 만들어

		for (int i = 0; i < arrB.length; i++) {
			for (int j = 0; j < arrB[i].length; j++) {
				arrB[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < x; i++) {
			for (int j = 0; j < arrA[i].length; j++) {
				arrA[i][j] = arrB[i][j];
			}
		}

		for (int i = x; i < arrA.length; i++) {
			for (int j = 0; j < arrA[i].length; j++) {
				if (j <= y - 1) {
					arrA[i][j] = arrB[i][j];
				} else {
					arrA[i][j] = arrB[i][j] - arrA[i - x][j - y];
				}
			}
		}

		for (int i = 0; i < arrA.length; i++) {
			for (int j = 0; j < arrA[i].length; j++) {
				System.out.print(arrA[i][j] + " ");
			}
			System.out.println();
		}
	}

}
