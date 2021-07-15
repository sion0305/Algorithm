package CodeUp;

import java.util.Scanner;

public class Code_1929 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		solution(n);
	}
	
	public static void solution(int n) {
		if(n == 1) {
			System.out.println(n);
			return;
		}
		
		if(n % 2 == 0) {
			solution(n/2);
		}else {
			solution(3 * n+1);
		}
		System.out.println(n);
	}

}
