package baekjoon.clear;

import java.util.Scanner;

public class Main_2193 {

	static long[] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		dp = new long[n+1];
		
		dp[0] = 0;
		dp[1] = 1;
		
		for(int i = 2; i <= n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		System.out.println(dp[n]);
		
//		System.out.println(solution(n));
	}

	public static long solution(int n) {
		if(dp[n] != 0)
			return dp[n];
		
		return dp[n] = solution(n-1) + solution(n-2);
	}
}
