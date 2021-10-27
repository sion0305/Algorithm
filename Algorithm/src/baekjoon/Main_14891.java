package baekjoon;

import java.util.Scanner;

public class Main_14891 {
	static int[][] tires = new int[4][8];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < 4; i++) {
			String s = sc.nextLine();
			String[] split = s.split("");
			for(int j = 0; j < 8; j++) {
				tires[i][j] = Integer.parseInt(split[j]);
			}
		}
		
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			int tireNum = sc.nextInt();
			int dir = sc.nextInt();
			
			solution(tireNum-1, dir);
		}
		
		System.out.println(score());
	}
	
	static void solution(int idx, int dir) {
		rotateLeft(idx - 1, -dir);
		rotateRight(idx + 1, -dir);
		rotate(idx, dir);
	}
	
	public static void rotate(int idx, int dir) {
		if(dir == 1) {
			int tmp = tires[idx][7];
			for(int i = 7; i > 0; i--) {
				tires[idx][i] = tires[idx][i-1];
			}
			tires[idx][0] = tmp;
		}else {
			int tmp = tires[idx][0];
			for(int i = 0; i < 7; i++) {
				tires[idx][i] = tires[idx][i+1];
			}
			tires[idx][7] = tmp;
		}
	}
	
	public static void rotateLeft(int idx, int dir) {
		if (idx < 0)
			return;

		if (tires[idx][2] != tires[idx + 1][6]) {
			rotateLeft(idx - 1, -dir);
			rotate(idx, dir);
		}
	}
	
	public static void rotateRight(int idx, int dir) {
		if (idx > 3)
			return;

		if (tires[idx][6] != tires[idx - 1][2]) {
			rotateRight(idx + 1, -dir);
			rotate(idx, dir);
		}
	}
	
	public static int score() {
		int sum = 0;
		
		for(int i = 0; i < 4; i++) {
			if(tires[i][0] == 1) {
				sum += Math.pow(2, i);
			}
		}
		
		return sum;
	}

}
