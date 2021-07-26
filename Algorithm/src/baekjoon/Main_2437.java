package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2437 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] weight = new int[n];
		
		for(int i = 0; i < n; i++) {
			weight[i] = sc.nextInt();
		}
		
		Arrays.sort(weight);
		
		int sum = 0;
		for(int i = 0; i < n; i++) {
			if(sum + 1 < weight[i]) {
				break;
			}
			sum += weight[i];
		}
		
		System.out.println(sum + 1);
	}

}
