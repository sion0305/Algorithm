package baekjoon.clear;

import java.util.Scanner;

public class Main_9095 {
	static int[] dp = new int[11];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for(int i = 0; i < t; i++) {
			int n = sc.nextInt();
			
			System.out.println(dp(n));
		}

	}
	
	public static int dp(int n) {
		if(dp[n] != 0)
			return dp[n];
		
		return dp[n] = dp(n-1) + dp(n-2) + dp(n-3);
	}

}
