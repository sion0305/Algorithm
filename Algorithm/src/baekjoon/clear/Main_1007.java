package baekjoon.clear;

import java.util.*;

public class Main_1007 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
				
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[] weight = new int[n];
		int[] value = new int[n];
		
		int[][] dp = new int[n][k];
		
		for(int i = 0; i < n; i++) {
			weight[i] = sc.nextInt();
			value[i] = sc.nextInt();
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < k; j++) {
				if(weight[i] > k) {
					dp[i][j] = dp[i-1][j];
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - weight[i]] + value[i]);
				}
			}
		}
	}

}
