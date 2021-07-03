package baekjoon;

import java.util.Scanner;

public class Main_12852 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int[] dp = new int[num+1];
		
		for(int i = 2; i <= num; i++) {
			dp[i] = dp[i-1] + 1;
			if(i % 3 == 0) {
				dp[i] = Math.min(dp[i] ,  dp[i/3] + 1);
			}
			if(i % 2 == 0) {
				dp[i] = Math.min(dp[i], dp[i/2] + 1);
			}
		}
		
		System.out.println(dp[num]);
		
		while(num != 1) {
			System.out.print(num + " ");
			if(num - 1 >= 0 && dp[num - 1] == dp[num]-1) {
				num -= 1;
			}else if(num % 3 == 0 && dp[num/3] == dp[num] - 1) {
				num /= 3;
			}else if(num%2 == 0 && dp[num/2] == dp[num] - 1){
				num /= 2;
			}
		}
		System.out.println(1);

	}
	
}
