package baekjoon;

import java.util.Scanner;

public class Main_9461 {
	static long[] dp = new long[101];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		
		for(int i = 0; i < t; i++) {
			int n = sc.nextInt();
			
			System.out.println(solution(n));
		}
	}
	
	public static long solution(int n) {
		if(dp[n] != 0) {
			return dp[n];
		}
		
		return dp[n] = solution(n-2) + solution(n-3);
	}

}
