package baekjoon.clear;

import java.util.Scanner;

public class Main_14501 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] t = new int[n+1];
		int[] p = new int[n+1];
		int[] dp = new int[n+1];
		
		for(int i = 0; i < n; i++) {
			t[i] = sc.nextInt();
			p[i] = sc.nextInt();
		}

		int max = 0;
		for(int i = 0; i <= n; i++) {
			dp[i] = Math.max(dp[i], max);
			
			if(t[i] + i <= n) {
				dp[t[i] + i] = Math.max(dp[t[i] + i], p[i] + dp[i]);
			}
			
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
	}

}
