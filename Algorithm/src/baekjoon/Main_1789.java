package baekjoon;

import java.util.Scanner;

public class Main_1789 {//수들의 합

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long n = sc.nextLong();
		
		long sum = 0;
		int count = 0;
		while(sum <= n) {
			sum += (++count);
		}
		
		count = sum == n ? count : count-1;
		System.out.println(count);
	}

}
