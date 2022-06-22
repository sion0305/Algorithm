package baekjoon.clear;

import java.util.Scanner;

public class Main_13305 {//�ֿ��
	//int �� long Ȯ�� �ʼ�

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
			//i�� n-1���� ���� �����̾�� index������ �߻����� ����
			//n-1�� �������̱� ������ ��� �ʿ� x
			if(cost[i] < min) {
				min = cost[i];
			}
			
			sum += (min * time[i]);
		}
		
		System.out.println(sum);
	}

}
