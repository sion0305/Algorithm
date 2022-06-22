package baekjoon.clear;

import java.util.Scanner;

public class Main_1904 {

	static int[] dp = new int[1000001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
//		dp = new int[n+1];
		
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		
	
		System.out.println(count(n));
	}
	
	public static int count (int n) {
		if(dp[n] != 0) {
			return dp[n];
		}
		
		return dp[n] = (count(n-1) + count(n-2)) % 15746;
	}

}
