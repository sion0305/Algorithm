package CodeUp;

import java.util.Scanner;

public class Code_1953 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		solution(n);
	}
	
	public static void solution(int n) {
		if(n == 1) {
			System.out.println("*");
			return;
		}
		
		solution(n-1);
		for(int i = 0; i < n; i++) {
			System.out.print("*");
		}
		System.out.println();
	}
}
