package CodeUp;

import java.util.Scanner;

public class Code_1902 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		solution(n);
	}

	public static void solution(int n) {
		if(n < 1)
			return;
		
		System.out.println(n);
		solution(n-1);
	}
}
