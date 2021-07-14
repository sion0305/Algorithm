package CodeUp;

import java.util.Scanner;

public class Code_1905 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int sum = 0;
		
		System.out.println(solution(n));
	}

	public static int solution(int n) {
		if(n < 0)
			return 0;
		
		return n + solution(n-1);
	}
}
