package baekjoon;

import java.util.Scanner;

public class Main_2447 {
	private static char star[][];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		star = new char[num][num];
		
		star(num, 0, 0);
		
		for(int i = 0; i < num; i++) {
			for(int j = 0; j < num; j++) {
				System.out.print(star[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void star(int n, int x, int y) {
		if(n == 1) {
			star[x][y] = '*';
			return;
		}
		n /= 3;
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(i == 1 && j == 1) {
					star[i][j] = ' ';
				}else {
					star(n, x + i * n, y + j * n);
				}
			}
		}
	}
}
