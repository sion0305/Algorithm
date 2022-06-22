package baekjoon.clear;

import java.util.Scanner;

public class Main_2630 {
	static int [][] paper;
	static int white = 0, blue = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		paper = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				paper[i][j] = sc.nextInt();
			}
		}
		
		cut(n, 0, 0);
		
		System.out.println(white);
		System.out.println(blue);
	}

	//n : �簢�� ����, x : ���� �� , y : ���� ��
	public static void cut(int n, int x, int y) {
		if(isSame(n,x,y)) {
			if(paper[x][y] == 0)
				white++;
			else
				blue++;
		}else {
			cut(n/2, x, y);
			cut(n/2, x + n/2, y);
			cut(n/2, x, y + n/2);
			cut(n/2, x + n/2, y + n/2);
		}
		
	}
	
	public static boolean isSame(int n, int x, int y) {
		int same = paper[x][y];
		for(int i = x; i < x+n; i++) {
			for(int j = y; j < y+n; j++) {
				if(same != paper[i][j]) 
					return false;
			}
		}
		return true;
	}
}
