package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main_11399 {//ATM

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] time = new int[n];
		
		for(int i = 0; i < n; i++) {
			time[i] = sc.nextInt();
		}
		
		Arrays.sort(time);
		
		int sum = time[0];
		for(int i = 1; i < n; i++) {
			time[i] += time[i-1];
			sum += time[i];
		}
		
		System.out.println(sum);
	}
}
