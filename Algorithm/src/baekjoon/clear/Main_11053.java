package baekjoon.clear;

import java.util.Scanner;

public class Main_11053 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] dp = new int[n];
		int[] a = new int[n];
		
		for(int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		
		for(int i = 0; i < n; i++) {
			dp[i] = 1;
			for(int j = 0; j < n; j++) {
				if(a[j] < a[i] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
				}
			}
		}
		
		int max = 0;
		for(int i = 0; i < n; i++) {
			max = Math.max(max, dp[i]);
		}

		System.out.println(max);
	}
}
