package baekjoon;

import java.util.Scanner;

public class Main_7568 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[][] size = new int[n][2];
		int[] rate = new int[n];
		
		for(int i = 0; i < n; i++) {
			size[i][0] = sc.nextInt();
			size[i][1] = sc.nextInt();
		}
		
		int count = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(size[i][0] < size[j][0] && size[i][1] < size[j][1]) {
					count++;
				}
			}
			rate[i] = count+1;
			count=0;
		}
		
		for(int r : rate) {
			System.out.print(r + " ");
		}
	}
}
