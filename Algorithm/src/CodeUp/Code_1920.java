package CodeUp;

import java.util.Scanner;

public class Code_1920 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		solution(n);
	}

	public static void solution(int n) {
		if(n == 0)
			return;
		
		solution(n / 2);
		System.out.print(n % 2);
		
	}
}
