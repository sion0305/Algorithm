package baekjoon;

import java.util.Scanner;

public class Main_13458 {

	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		long[] test = new long[n];
		long count = 0;
		
		for(int i = 0; i < n; i++) {
			test[i] = sc.nextInt();
		}
		
		long b = sc.nextInt();
		long c = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			count++;
			if(test[i] <= b) {
				continue;
			}
			
			test[i] -= b;
			if(test[i] % c == 0) {
				count += test[i] / c;
			}else {
				count += test[i] / c;
				count++;
			}
		}
		
		System.out.println(count);
	}

}
