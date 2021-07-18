package baekjoon;

import java.util.Scanner;

public class Main_13305 {//주요소
	//int 랑 long 확인 필수

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		long[] time = new long[n-1];
		long[] cost = new long[n];
		
		for(int i = 0; i < n - 1; i++) {
			time[i] = sc.nextInt();
		}
		
		for(int i = 0; i < n; i++) {
			cost[i] = sc.nextInt();
		}
		
		long sum = 0;
		long min = cost[0];
		for(int i = 0; i < n-1; i++) {
			//i가 n-1보다 작은 동안이어야 index오류가 발생하지 않음
			//n-1은 도착지이기 때문에 계산 필요 x
			if(cost[i] < min) {
				min = cost[i];
			}
			
			sum += (min * time[i]);
		}
		
		System.out.println(sum);
	}

}
